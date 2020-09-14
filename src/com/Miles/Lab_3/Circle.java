package com.Miles.Lab_3;

public class Circle {
    private double radius;
    private int x, y;
    private double weight;
    private String color;
    public void setCircle(int X, int Y, double Radius, double Weight, String Color){
        radius = Radius;
        x = X;
        y = Y;
        weight = Weight;
        color = Color;
    }
    public double getRadius(){
        return radius;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getWeight(){
        return weight;
    }
    public String  getColor(){
        return color;
    }
    public double getArea(){
        return (radius+(weight/2)) * (radius+(weight/2)) * Math.PI;
    }


}
