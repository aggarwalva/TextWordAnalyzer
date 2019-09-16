package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        TextReader reader = new TextReader(new File(path));
        reader.printFile();
        ArrayList<RepeatWord> list = new ArrayList<>();
        list = reader.repeatWordAnalysis();
        for(RepeatWord word : list){
            System.out.println(word);
        }
    }
}
