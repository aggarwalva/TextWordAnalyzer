package com.company;

public class RepeatWord {
    String word;
    int repeats;

    public RepeatWord(String word){
        this.word = word;
        this.repeats = 1;
    }

    public RepeatWord(String word, int repeats){
        this(word);
        this.repeats = repeats;
    }

    public void repeat(){
        repeats++;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getWord(){
        return word;
    }

    public void setRepeats(int repeats){
        this.repeats = repeats;
    }

    public int getRepeats(){
        return repeats;
    }

    @Override
    public boolean equals(Object obj){
        try{
            RepeatWord temp = (RepeatWord)obj;
            return this.word.equals(temp.word);
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString(){
        return word + " : " + repeats;
    }
}
