package com.sapient.ace.Utils;

/**
 * Created by Ravdeep Singh on 13-02-2017.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class FileCreator {
    public static void main(String[] args) throws IOException {
        if(args.length <1){
            System.out.printf("Usage - Size in KB");
            System.exit(0);
        }
        int sizeInKB = Integer.parseInt(args[0]);
        File file = new File("src/main/resources/input.txt");
        FileWriter fos = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fos);
        Random r = new Random();


        while (true) {
            char[] charArray = new char[256];
            char c = (char) (r.nextInt(26) + 'a');
            Arrays.fill(charArray,c);
            printWriter.write(charArray);
//            printWriter.write(UUID.randomUUID().toString());
            printWriter.write("\n");
            if (file.length() / (1024 * /*1024 **/ sizeInKB) >= 1) {
                break;
            }
        }
        printWriter.flush();
        printWriter.close();

        System.out.println("File created of size " + file.length() / (1024 /** 1024*/) + " KB");
    }
}

