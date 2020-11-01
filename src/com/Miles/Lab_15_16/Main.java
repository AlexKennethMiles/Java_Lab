package com.Miles.Lab_15_16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner cin = new Scanner(System.in);
        int count = 0;

        while (true) {
            if (count == -1) {
                break;
            }
            count = cin.nextInt();
            if (count == 0 || count == 1) {
                graph.move(count);
            } else if (count != -1) {
                System.out.println("\u001B[33m" + "Only movement (0/1), no jokes" + "\u001B[0m");
            }
        }

        graph.getInstructions();
    }
}
