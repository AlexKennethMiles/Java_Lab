package com.Miles.Lab_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise 5.1");
        System.out.println("---");
        MovablePoint p1 = new MovablePoint();
        MovableCircle c1 = new MovableCircle();

        System.out.println(p1.toString());
        p1.move(5,-10);
        System.out.println(p1.toString());

        System.out.println("---");

        System.out.println(c1.toString());
        c1.move(2, 8);
        System.out.println(c1.toString());
        System.out.println("---");

        System.out.println("Exercise 5.2");
        System.out.println("---");

        MovableRectangle wow = new MovableRectangle(0,5,5,0);
        System.out.println(wow.toString());
    }
}
