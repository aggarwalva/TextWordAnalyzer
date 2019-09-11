package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        TextReader reader = new TextReader(new File(path));
        reader.printFile();
    }
}
