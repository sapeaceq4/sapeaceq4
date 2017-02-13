package com.sapient.ace.Utils;

/**
 * Created by Ravdeep Singh on 13-02-2017.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class FileCreator {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resource/input.txt");
        FileWriter fos = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fos);
        while (true) {
            printWriter.write(UUID.randomUUID().toString());
            printWriter.write("\n");
            if (file.length() / (1024 * 1024 * 100) >= 1) {
                break;
            }
        }
        printWriter.flush();
        printWriter.close();

        System.out.println("File created of size " + file.length() / (1024 * 1024) + " MB");
    }
}

