package com.Miles.Lab_5;

public class MovableCircle extends Circle implements Movable{
    Circle circle = new Circle( 4,  "black",  true);
    private double x, y;

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
    public String toString() {
        return "MovableCircle{" +
                "circle=" + circle +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
