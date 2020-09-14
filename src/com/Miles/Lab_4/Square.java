package com.Miles.Lab_4;

public class Square extends Shape{
    private double side;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super.color = color;
        super.filled = filled;
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
