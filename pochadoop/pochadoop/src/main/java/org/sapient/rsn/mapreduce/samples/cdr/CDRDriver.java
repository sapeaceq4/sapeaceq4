package org.sapient.rsn.mapreduce.samples.cdr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by rsi164 on 12/28/2016.
 */
public class CDRDriver {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        if (args.length != 2) {
            System.err.println("Usage: stdsubscriber < in> < out>");
            System.exit(2);
        }
        Job job = new Job(conf, "STD Subscribers");
        job.setJarByClass(CDRDriver.class);
        job.setMapperClass(CDRMapper.class);
        job.setCombinerClass(CDRReducer.class);
        job.setReducerClass(CDRReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
