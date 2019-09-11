package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextReader {
    File raw;
    FileReader rawIn = null;
    BufferedReader in = null;
    Scanner s = null;

    public TextReader(File raw){
        this.raw = raw;
    }

    public void printFile(){
        try{
            rawIn = new FileReader(raw);
            s = new Scanner(rawIn);

            while(s.hasNext()){
                System.out.println(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
