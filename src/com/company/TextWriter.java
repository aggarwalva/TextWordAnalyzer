package com.company;

import java.io.*;
import java.util.ArrayList;

public class TextWriter {
    File output;
    FileWriter fileOut;
    BufferedWriter write;

    public TextWriter(String path){
        this.output = new File(path);
    }

    public void initializeWriter(){
        try{
            fileOut = new FileWriter(output);
            write = new BufferedWriter(fileOut);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeWordArray(ArrayList<RepeatWord> list){
        initializeWriter();
        try{
            for(RepeatWord w : list){
                write.write(w.toString() + "\n");
            }
            write.close();
            fileOut.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
