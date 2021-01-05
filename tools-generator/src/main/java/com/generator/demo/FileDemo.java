package com.generator.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        System.out.println(file);
        System.out.println(file.exists());
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
    }
}
