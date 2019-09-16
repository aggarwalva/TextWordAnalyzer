package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TextReader {
    File raw;
    FileReader rawIn = null;
    BufferedReader in = null;
    Scanner s = null;

    public TextReader(File raw){
        this.raw = raw;
    }

    public ArrayList<RepeatWord> repeatWordAnalysis(){
        initializeReader();
        ArrayList<RepeatWord> out = new ArrayList<>();
        while(s.hasNext()){
            RepeatWord temp = new RepeatWord(s.next().toLowerCase());
            if(out.contains(temp)){
                out.get(out.indexOf(temp)).repeat();
            } else{
                out.add(temp);
            }
        }
        out.sort(new Comparator<RepeatWord>() {
            @Override
            public int compare(RepeatWord o1, RepeatWord o2) {
                return o2.repeats - o1.repeats;
            }
        });
        return out;
    }

    public void initializeReader(){
        try{
            rawIn = new FileReader(raw);
            s = new Scanner(rawIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printFile(){
        initializeReader();
        while(s.hasNext()){
            System.out.println(s.next());
        }
    }
}
