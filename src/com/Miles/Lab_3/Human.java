package com.Miles.Lab_3;

public class Human {
    Head head;
    Leg legR;
    Leg legL;
    Hand handR;
    Hand handL;

    public Human(){
        head = new Head();
        System.out.println("Intelligence is: " + head.getIntelligence());
        head.thinking();
        legR = new Leg();
        System.out.println("Endurance of the right leg: " + legR.getEndurance());
        legL = new Leg(241);
        System.out.println("Endurance of the left leg: " + legL.getEndurance());
        legL.walking();
        handR = new Hand();
        System.out.println("The power of the right hand: " + handR.getPower());
        handL = new Hand(209);
        System.out.println("The power of the left hand: " + handL.getPower());
        handR.press();
    }

}
