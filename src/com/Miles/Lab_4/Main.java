package com.Miles.Lab_4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle( 4,  "black",  true);
        Rectangle rectangle = new Rectangle(5,  4, "red", true);
        Square square = new Square(5, "blue", true);
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}
