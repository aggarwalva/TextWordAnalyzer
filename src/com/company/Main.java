package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        String output = "output.txt";
        TextReader reader = new TextReader(path);
        TextWriter writer = new TextWriter(output);
        ArrayList<RepeatWord> list = reader.repeatPhraseAnalysis(2);
        for(RepeatWord word : list){
            System.out.println(word);
        }
        writer.writeWordArray(list);
    }
}
