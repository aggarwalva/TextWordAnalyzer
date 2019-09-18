package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "test.txt";
        String output = "output.txt";
        TextReader reader = new TextReader(path);
        TextWriter writer = new TextWriter(output);
        TextWriter wordsOutput = new TextWriter("wordsOutput.txt");
        ArrayList<RepeatWord> list = reader.repeatPhraseAnalysis(2);
        ArrayList<RepeatWord> wordsOnly = reader.repeatWordAnalysis();
        for (RepeatWord word : list) {
            System.out.println(word);
        }
        writer.writeWordArray(list);
        wordsOutput.writeWordArray(wordsOnly);
    }
}
