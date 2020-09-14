package com.Miles.Lab_2;

public class Shape {
    private int X1 = 2;
    private int Y1 = 2;
    private int X2 = 7;
    private int Y2 = 5;
    private int weight = 3;
    private String color = "black";
    /*public void Show(){
        System.out.print("First point: (" + X1 + ';' + Y1 + ')' + '\n' +
                "Second point: (" + X2 + ';' + Y2 + ')' + '\n' +
                "Weight: " + weight + '\n' +
                "Color: " + color);
    }*/
    @Override
    public String toString() {
        return ("First point: (" + X1 + ';' + Y1 + ')' + '\n' +
                "Second point: (" + X2 + ';' + Y2 + ')' + '\n' +
                "Weight: " + weight + '\n' +
                "Color: " + color);
    }
}
