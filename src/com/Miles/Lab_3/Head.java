package com.Miles.Lab_3;

public class Head {
    int intelligence = 180;
    public Head(){}
    public Head(int Intelligence){
        intelligence = Intelligence;
    }
    public void setIntelligence(int IQ){
        intelligence = IQ;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public void thinking(){
        System.out.println("There is a process of thought");
    }
}
