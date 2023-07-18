package com.company.project.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 public class FileReadingThread extends Thread {
    private String fileName;
     public FileReadingThread(String fileName) {
        this.fileName = fileName;
    }
     @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static void main(String[] args) {
        String fileName = "D:\\project\\my_project\\spring-boot-base\\src\\main\\java\\com\\company\\project\\controller\\file.txt";
        FileReadingThread thread = new FileReadingThread(fileName);
        thread.start();
    }
}
