package com.Miles.Lab_3;

public class Hand {
    int power = 210;
    public Hand(){}
    public  Hand(int Power){
        power = Power;
    }
    public void setPower(int Power){
        power = Power;
    }
    public int getPower(){
        return power;
    }
    public void press(){
        System.out.println("The process of push-UPS");
    }
}
