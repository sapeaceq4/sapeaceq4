package com.sapient.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MergeLarge {


	private static void displayUsage() {
		System.out.println("java com.google.externalsorting.ExternalSort inputfile outputfile");
		System.out.println("Flags are:");
		System.out.println("-v or --verbose: verbose output");
		System.out.println("-d or --distinct: prune duplicate lines");
		System.out.println("-t or --maxtmpfiles (followed by an integer): specify an upper bound on the number of temporary files");
		System.out.println("-c or --charset (followed by a charset code): specify the character set to use (for sorting)");
		System.out.println("-z or --gzip: use compression for the temporary files");
		System.out.println("-H or --header (followed by an integer): ignore the first few lines");
		System.out.println("-s or --store (following by a path): where to store the temporary files");
		System.out.println("-h or --help: display this message");
	}

	public static long estimateAvailableMemory() {
		System.gc();

		Runtime r = Runtime.getRuntime();
		long allocatedMemory = r.totalMemory() - r.freeMemory();
		long presFreeMemory = r.maxMemory() - allocatedMemory;
		return presFreeMemory;
	}

	public static long estimateBestSizeOfBlocks(final long sizeoffile,
			final int maxtmpfiles, final long maxMemory) {
		long blocksize = sizeoffile / maxtmpfiles + (sizeoffile % maxtmpfiles == 0 ? 0 : 1);

		if (blocksize < maxMemory / 2) {
			blocksize = maxMemory / 2;
		}
		return blocksize;
	}

	public static void main(final String[] args) throws IOException {
		boolean verbose = false;
		boolean distinct = false;
		int maxtmpfiles = DEFAULTMAXTEMPFILES;
		Charset cs = Charset.defaultCharset();
		String inputfile = null, outputfile = null;
		File tempFileStore = null;
		boolean usegzip = false;
		boolean parallel = true;
		int headersize = 0;
		for (int param = 0; param < args.length; ++param) {
			if (args[param].equals("-v")
					|| args[param].equals("--verbose")) {
				verbose = true;
			} else if ((args[param].equals("-h") || args[param].equals("--help"))) {
				displayUsage();
				return;
			} else if ((args[param].equals("-d") || args[param].equals("--distinct"))) {
				distinct = true;
			} else if ((args[param].equals("-t") || args[param].equals("--maxtmpfiles"))&& args.length > param + 1) {
				param++;
				maxtmpfiles = Integer.parseInt(args[param]);
				if (headersize < 0) {
					System.err.println("maxtmpfiles should be positive");
				}
			} else if ((args[param].equals("-c") || args[param].equals("--charset"))&& args.length > param + 1) {
				param++;
				cs = Charset.forName(args[param]);
			} else if ((args[param].equals("-z") || args[param].equals("--gzip"))) {
				usegzip = true;
			} else if ((args[param].equals("-H") || args[param].equals("--header")) && args.length > param + 1) {
				param++;
				headersize = Integer.parseInt(args[param]);
				if (headersize < 0) {
					System.err.println("headersize should be positive");
				}
			} else if ((args[param].equals("-s") || args[param].equals("--store")) && args.length > param + 1) {
				param++;
				tempFileStore = new File(args[param]);
			} else {
				if (inputfile == null) {
					inputfile = args[param];
				} else if (outputfile == null) {
					outputfile = args[param];
				} else {
					System.out.println("Unparsed: "	+ args[param]);
				}
			}
		}
		if (outputfile == null) {
			System.out.println("please provide input and output file names");
			displayUsage();
			return;
		}
		Comparator<String> comparator = defaultcomparator;
		List<File> l = sortInBatch(new File(inputfile), comparator,maxtmpfiles, cs, tempFileStore, distinct, headersize,usegzip, parallel);
		if (verbose) {
			System.out.println("created " + l.size() + " tmp files");
		}
		mergeSortedFiles(l, new File(outputfile), comparator, cs,
				distinct, false, usegzip);
	}

	public static int mergeSortedFiles(BufferedWriter fbw,
			final Comparator<String> cmp, boolean distinct,
			List<BinaryFileBuffer> buffers) throws IOException {
			PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<>(
				11, new Comparator<BinaryFileBuffer>() {
					@Override
					public int compare(BinaryFileBuffer i,
							BinaryFileBuffer j) {
						return cmp.compare(i.peek(), j.peek());
					}
				});
		for (BinaryFileBuffer bfb : buffers) {
			if (!bfb.empty()) {
				pq.add(bfb);
			}
		}
		int rowcounter = 0;
		try {
			if (!distinct) {
				while (pq.size() > 0) {
					BinaryFileBuffer bfb = pq.poll();
					String r = bfb.pop();
					fbw.write(r);
					fbw.newLine();
					++rowcounter;
					if (bfb.empty()) {
						bfb.fbr.close();
					} else {
						pq.add(bfb); // add it back
					}
				}
			} else {
				String lastLine = null;
				if(pq.size() > 0) {
					BinaryFileBuffer bfb = pq.poll();
					lastLine = bfb.pop();
					fbw.write(lastLine);
					fbw.newLine();
					++rowcounter;
					if (bfb.empty()) {
						bfb.fbr.close();
					} else {
						pq.add(bfb); // add it back
					}
				}
				while (pq.size() > 0) {
					BinaryFileBuffer bfb = pq.poll();
					String r = bfb.pop();
					// Skip duplicate lines
					if  (cmp.compare(r, lastLine) != 0) {
						fbw.write(r);
						fbw.newLine();
						lastLine = r;
					}
					++rowcounter;
					if (bfb.empty()) {
						bfb.fbr.close();
					} else {
						pq.add(bfb); // add it back
					}
				}
			}
		} finally {
			fbw.close();
			for (BinaryFileBuffer bfb : pq) {
				bfb.close();
			}
		}
		return rowcounter;

	}

	public static int mergeSortedFiles(List<File> files, File outputfile)
			throws IOException {
		return mergeSortedFiles(files, outputfile, defaultcomparator,Charset.defaultCharset());
	}
	public static int mergeSortedFiles(List<File> files, File outputfile,
			final Comparator<String> cmp) throws IOException {
		return mergeSortedFiles(files, outputfile, cmp,	Charset.defaultCharset());
	}

	public static int mergeSortedFiles(List<File> files, File outputfile,
			final Comparator<String> cmp, boolean distinct)	throws IOException {
		return mergeSortedFiles(files, outputfile, cmp,Charset.defaultCharset(), distinct);
	}

	public static int mergeSortedFiles(List<File> files, File outputfile,final Comparator<String> cmp, Charset cs) throws IOException {
		return mergeSortedFiles(files, outputfile, cmp, cs, false);
	}

	public static int mergeSortedFiles(List<File> files, File outputfile,final Comparator<String> cmp, Charset cs, boolean distinct)throws IOException {
		return mergeSortedFiles(files, outputfile, cmp, cs, distinct,false, false);
	}

	public static int mergeSortedFiles(List<File> files, File outputfile,final Comparator<String> cmp, Charset cs, boolean distinct,boolean append, boolean usegzip) throws IOException {
		ArrayList<BinaryFileBuffer> bfbs = new ArrayList<>();
		for (File f : files) {
			final int BUFFERSIZE = 2048;
			InputStream in = new FileInputStream(f);
			BufferedReader br;
			if (usegzip) {
				br = new BufferedReader(new InputStreamReader(new GZIPInputStream(in,BUFFERSIZE), cs));
			} else {
				br = new BufferedReader(new InputStreamReader(in, cs));
			}

			BinaryFileBuffer bfb = new BinaryFileBuffer(br);
			bfbs.add(bfb);
		}
		BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile, append), cs));
		int rowcounter = mergeSortedFiles(fbw, cmp, distinct, bfbs);
		for (File f : files) {
			f.delete();
		}
		return rowcounter;
	}

	public static void sort(final File input, final File output)throws IOException {
		MergeLarge.mergeSortedFiles(MergeLarge.sortInBatch(input),output);
	}

	public static File sortAndSave(List<String> tmplist,Comparator<String> cmp, Charset cs, File tmpdirectory)throws IOException {
		return sortAndSave(tmplist, cmp, cs, tmpdirectory, false, false, true);
	}
	public static File sortAndSave(List<String> tmplist,Comparator<String> cmp, Charset cs, File tmpdirectory,boolean distinct, boolean usegzip, boolean parallel) throws IOException {
		if (parallel) {
			tmplist = tmplist.parallelStream().sorted(cmp).collect(Collectors.toCollection(ArrayList<String>::new));
		} else {
			Collections.sort(tmplist, cmp);
		}
		File newtmpfile = File.createTempFile("sortInBatch","flatfile", tmpdirectory);
		newtmpfile.deleteOnExit();
		OutputStream out = new FileOutputStream(newtmpfile);
		int ZIPBUFFERSIZE = 2048;
		if (usegzip) {
			out = new GZIPOutputStream(out, ZIPBUFFERSIZE) {
				{
					this.def.setLevel(Deflater.BEST_SPEED);
				}
			};
		}
		try (BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(out, cs))) {
			if (!distinct) {
				for (String r : tmplist) {
					fbw.write(r);
					fbw.newLine();
				}
			} else {
				String lastLine = null;
				Iterator<String> i = tmplist.iterator();
				if(i.hasNext()) {
					lastLine = i.next();
					fbw.write(lastLine);
					fbw.newLine();
				}
				while (i.hasNext()) {
					String r = i.next();
					// Skip duplicate lines
					if (cmp.compare(r, lastLine) != 0) {
						fbw.write(r);
						fbw.newLine();
						lastLine = r;
					}
				}
			}
		}
		return newtmpfile;
	}

	public static List<File> sortInBatch(final BufferedReader fbr,final long datalength) throws IOException {
		return sortInBatch(fbr, datalength, defaultcomparator,DEFAULTMAXTEMPFILES, estimateAvailableMemory(),Charset.defaultCharset(), null, false, 0, false, true);
	}

	public static List<File> sortInBatch(final BufferedReader fbr,final long datalength, final Comparator<String> cmp,final boolean distinct) throws IOException {
		return sortInBatch(fbr, datalength, cmp, DEFAULTMAXTEMPFILES,estimateAvailableMemory(), Charset.defaultCharset(),null, distinct, 0, false, true);
	}

	
	public static List<File> sortInBatch(final BufferedReader fbr,final long datalength, final Comparator<String> cmp,final int maxtmpfiles, long maxMemory, final Charset cs,
			final File tmpdirectory, final boolean distinct,final int numHeader, final boolean usegzip, final boolean parallel)	throws IOException {
		List<File> files = new ArrayList<>();
		long blocksize = estimateBestSizeOfBlocks(datalength,maxtmpfiles, maxMemory);// in
				// bytes

		try {
			List<String> tmplist = new ArrayList<>();
			String line = "";
			try {
				int counter = 0;
				while (line != null) {
					long currentblocksize = 0;// in bytes
					while ((currentblocksize < blocksize)
							&& ((line = fbr.readLine()) != null)) {
						// as long as you have enough
						// memory
						if (counter < numHeader) {
							counter++;
							continue;
						}
						tmplist.add(line);
						//currentblocksize += StringSizeEstimator.estimatedSizeOf(line);
					}
					files.add(sortAndSave(tmplist, cmp, cs,tmpdirectory, distinct, usegzip, parallel));
					tmplist.clear();
				}
			} catch (EOFException oef) {
				if (tmplist.size() > 0) {
					files.add(sortAndSave(tmplist, cmp, cs,tmpdirectory, distinct, usegzip, parallel));
					tmplist.clear();
				}
			}
		} finally {
			fbr.close();
		}
		return files;
	}
	public static List<File> sortInBatch(File file) throws IOException {
		return sortInBatch(file, defaultcomparator);
	}

	
	public static List<File> sortInBatch(File file, Comparator<String> cmp)throws IOException {
		return sortInBatch(file, cmp, false);
	}
	public static List<File> sortInBatch(File file, Comparator<String> cmp,boolean distinct) throws IOException {
		return sortInBatch(file, cmp, DEFAULTMAXTEMPFILES,Charset.defaultCharset(), null, distinct);
	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp,File tmpdirectory,boolean distinct, int numHeader)throws IOException {
		return sortInBatch(file, cmp, DEFAULTMAXTEMPFILES,Charset.defaultCharset(), tmpdirectory, distinct,numHeader);
	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp,	int maxtmpfiles, Charset cs, File tmpdirectory, boolean distinct)throws IOException {
		return sortInBatch(file, cmp, maxtmpfiles, cs, tmpdirectory,distinct, 0);
	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp,Charset cs, File tmpdirectory,boolean distinct, int numHeader)throws IOException {
		BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
			return sortInBatch(fbr, file.length(), cmp, DEFAULTMAXTEMPFILES,estimateAvailableMemory(), cs, tmpdirectory, distinct,numHeader, false, true);
	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp,int maxtmpfiles, Charset cs, File tmpdirectory,boolean distinct, int numHeader)throws IOException {
		BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
		return sortInBatch(fbr, file.length(), cmp, maxtmpfiles,estimateAvailableMemory(), cs, tmpdirectory, distinct,numHeader, false, true);
	}

	public static List<File> sortInBatch(File file, Comparator<String> cmp,int maxtmpfiles, Charset cs, File tmpdirectory,boolean distinct, int numHeader, boolean usegzip)	throws IOException {
		BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
		return sortInBatch(fbr, file.length(), cmp, maxtmpfiles,estimateAvailableMemory(), cs, tmpdirectory, distinct,numHeader, usegzip, true);
	}


	public static List<File> sortInBatch(File file, Comparator<String> cmp,	int maxtmpfiles, Charset cs, File tmpdirectory,	boolean distinct, int numHeader, boolean usegzip, boolean parallel)	throws IOException {
		BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
		return sortInBatch(fbr, file.length(), cmp, maxtmpfiles,estimateAvailableMemory(), cs, tmpdirectory, distinct,numHeader, usegzip, parallel);
	}

	public static Comparator<String> defaultcomparator = new Comparator<String>() {
		@Override
		public int compare(String r1, String r2) {
			return r1.compareTo(r2);
		}
	};

	
	public static final int DEFAULTMAXTEMPFILES = 1024;

}


final class BinaryFileBuffer {
	public BinaryFileBuffer(BufferedReader r) throws IOException {
		this.fbr = r;
		reload();
	}
	public void close() throws IOException {
		this.fbr.close();
	}

	public boolean empty() {
		return this.cache == null;
	}

	public String peek() {
		return this.cache;
	}

	public String pop() throws IOException {
		String answer = peek().toString();// make a copy
		reload();
		return answer;
	}

	private void reload() throws IOException {
		this.cache = this.fbr.readLine();
	}

	public BufferedReader fbr;

	private String cache;

}

