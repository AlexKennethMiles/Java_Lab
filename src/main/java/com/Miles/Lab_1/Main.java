package com.Miles.Lab_1;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        System.out.println("Exercise 1.1");
        int[] array = {12, 32, 13, 543, 1};
        int length = array.length;
        int buf = 0;
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        for(int i = 0;i < length; i++) {
            res1 = res1 + array[i];
        }
        while(buf<length) {
            res2 = res2 + array[buf];
            buf++;
        }
        buf = 0;
        do{
            res3 = res3 + array [buf];
            buf++;
        }while(buf!=length);
        System.out.println("for: " + res1);
        System.out.println("while: " + res2);
        System.out.println("do while: " + res3);

        ////////
        System.out.println();
        System.out.println("Exercise 1.2");
        int str_length = args.length;
        if (str_length==0)
            System.out.println("String[] args length " + str_length);
        else {
            for (int i = 0; i < str_length; i++) {
                System.out.println(args[i]);
            }
        }

        ////////
        System.out.println();
        System.out.println("Exercise 1.3");
        System.out.print("1/1 ");
        for(int i = 2; i < 11; i++) {
            System.out.print(" 1/" + i + ' ');
        }

        ////////
        System.out.println('\n');
        System.out.println("Exercise 1.4");
        System.out.print("Math.random: ");
        int arr[] = new int[10];
        for(int i = 0; i < arr.length-1; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
        }
        buf = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
            }
        }
        System.out.println();
        System.out.print("Sort: ");
        for(int i = 0; i < arr.length-1; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.print("Class Random: ");
        Random rand = new Random();
        for(int i = 0; i < arr.length-1; i++) {
            arr[i] = rand.nextInt(10);
            System.out.print(arr[i] + " ");
        }
        buf = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
            }
        }
        System.out.println();
        System.out.print("Sort: ");
        for(int i = 0; i < arr.length-1; i++)
            System.out.print(arr[i] + " ");

        System.out.println('\n');
        System.out.println("Exercize 1.5");
        Scanner in = new Scanner(System.in);
        System.out.print("Your number: ");
        int num = in.nextInt();
        System.out.print("Factorial of your number: " + Fact(num));

    }
    public static int Fact(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * Fact(f - 1);
        }
    }
}