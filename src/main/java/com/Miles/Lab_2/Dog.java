package com.Miles.Lab_2;

public class Dog {
    String name;
    int age;
    public Dog(String Name, int Age){
        name = Name;
        age = Age;
    }
    public void setDog(String Name, int Age){
        name = Name;
        age = Age;
    }
    public void getDog(){
        System.out.println("The dog's name: " + name + ", Age: " + age);
    }
    public void convertAge(){
        System.out.println("Convert Age: " + (age * 7));
    }
    public String ToString(){
        return "The dog's name: " + name + ", Age: " + age + ", Convert Age: " + (age * 7);
    }
}
