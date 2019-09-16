package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader {
    File raw;
    FileReader rawIn = null;
    BufferedReader in = null;
    Scanner s = null;

    public TextReader(String path){
        this.raw = new File(path);
    }

    public ArrayList<RepeatWord> repeatWordAnalysis(){
        initializeReader();
        ArrayList<RepeatWord> out = new ArrayList<>();
        while(s.hasNext()){
            RepeatWord temp = new RepeatWord(s.next());
            if(out.contains(temp)){
                out.get(out.indexOf(temp)).repeat();
            } else{
                out.add(temp);
            }
        }
        out.sort((o1, o2) -> o2.repeats - o1.repeats);
        return out;
    }

    public ArrayList<RepeatWord> repeatPhraseAnalysis(int phraseLength){
        initializeReader();
        ArrayList<RepeatWord> out = new ArrayList<>();
        while(s.hasNext()){
            String current = s.nextLine().replaceAll("[^a-zA-Z ]", "");
            String[] wordArray = current.split(" ");
            for(int i = 0; i < wordArray.length; i++){
                String phrase = "";
                for(int j = 0; j < phraseLength; j++){
                    try{
                        phrase = phrase + " " + wordArray[i+j];
                    } catch (ArrayIndexOutOfBoundsException e){
                        //Log
                    }
                }
                RepeatWord temp = new RepeatWord(phrase);
                if(out.contains(temp)){
                    out.get(out.indexOf(temp)).repeat();
                } else{
                    out.add(temp);
                }
            }
        }
        out.sort((o1, o2) -> o2.repeats - o1.repeats);
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
