package com.Miles.Lab_3;

public class Leg {
    int endurance = 240;
    public Leg(){}
    public Leg(int Endurance){
        endurance = Endurance;
    }
    public void setEndurance(int Endurance){
        endurance = Endurance;
    }
    public int getEndurance(){
        return endurance;
    }
    public void walking(){
        System.out.println("The process of walking");
    }
}
