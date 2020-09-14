package com.Miles.Lab_2;

public class PitomnikSobak {
    Dog[] dogs = new Dog[10];
    public void addDog(int I, String Name, int Age){
        dogs[I] = new Dog(Name, Age);
        if (Age == 1) {
            System.out.println("Добавлена собака под номером " + (I + 1) + " По кличке " + Name + " и возрастом " + Age + " год");
        }
        else if ((Age == 2)||(Age == 3)||(Age == 4)){
            System.out.println("Добавлена собака под номером " + (I+1) + " По кличке " + Name + " и возрастом " + Age + " года");
        }
        else{
            System.out.println("Добавлена собака под номером " + (I+1) + " По кличке " + Name + " и возрастом " + Age + " лет");
        }

    }
}
