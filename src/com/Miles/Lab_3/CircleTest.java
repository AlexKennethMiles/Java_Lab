package com.Miles.Lab_3;

public class CircleTest {
    public static void main(String[] args){
        System.out.println("Exercise 3.1");
        Circle c1 = new Circle();
        c1.setCircle(0,0,1, 1, "black");
        System.out.println("Center is (" + c1.getX()+ ";" + c1.getY() + ")"
                        + "; Radius is " + c1.getRadius()
                        + "; Weight is " + c1.getWeight()
                        + "; Color is " + c1.getColor()
                        + "; Area is " + c1.getArea());
        Circle c2 = new Circle();
        c2.setCircle(1,1,2, 2, "red");
        System.out.println("Center is (" + c2.getX()+ ";" + c2.getY() + ")"
                + "; Radius is " + c2.getRadius()
                + "; Weight is " + c2.getWeight()
                + "; Color is " + c2.getColor()
                + "; Area is " + c2.getArea());
        Circle c3 = new Circle();
        c3.setCircle(5,5,3, 3, "blue");
        System.out.println("Center is (" + c3.getX()+ ";" + c3.getY() + ")"
                + "; Radius is " + c3.getRadius()
                + "; Weight is " + c3.getWeight()
                + "; Color is " + c3.getColor()
                + "; Area is " + c3.getArea());
        ///
        System.out.println("---");
        System.out.println("Exercise 3.2");
        Human human = new Human();
        human.head.setIntelligence(300);


    }
}
