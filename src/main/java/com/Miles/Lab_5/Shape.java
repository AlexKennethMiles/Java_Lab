package com.Miles.Lab_5;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(){}
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String  getColor(){
        return this.color;
    }
    public void  setColor(){
        this.color = color;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
