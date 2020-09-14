package com.Miles.Lab_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise 2.1");
        TestShape example = new TestShape();
        //
        System.out.println("---");
        System.out.println("Exercise 2.2");
        Ball ball = new Ball();
        //
        System.out.println("---");
        System.out.println("Exercise 2.3");
        Book book = new Book();
        //
        System.out.println("---");
        System.out.println("Exercise 2.4");
        PitomnikSobak pitomnik = new PitomnikSobak();
        System.out.println("В питомник:");
        pitomnik.addDog(0, "Sharik", 4);
        pitomnik.addDog(1, "Archi", 5);
        pitomnik.addDog(2, "Brut", 1);

    }
}
