package com.Miles.Lab_5;

public class MovablePoint extends Shape implements Movable {

    private double x, y;

    public MovablePoint(){
        this.x = 0;
        this.y = 0;
        this.color = "black";
        this.filled = true;
    }

    public MovablePoint(double x, double y){
        this.x = x;
        this.y = y;
        this.color = "black";
        this.filled = true;
    }


    public MovablePoint(String color, boolean filled, double x, double y) {
        super(color, filled);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
