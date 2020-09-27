package com.Miles.Lab_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        System.out.println("Input size: ");
        int size = cin.nextInt();

        int[][] origin = new int[size][size];
        int[][] buffer = new int[size][size];

        System.out.println("Creating array...");
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                origin[i][j] = cin.nextInt();
            }
        }

        int max;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (i == size - 1 && j == size - 1) {
                    buffer[i][j] = origin[i][j];
                }
                else if (i == size - 1) {
                    buffer[i][j] = origin[i][j] + buffer[i][j + 1];
                }
                else if (j == size - 1) {
                    buffer[i][j] = origin[i][j] + buffer[i + 1][j];
                }
                else {
                    max = origin[i][j] + buffer[i + 1][j];
                    if (max < origin[i][j] + buffer[i][j + 1])
                        max = origin[i][j] + buffer[i][j + 1];
                    buffer[i][j] = max;
                }
            }
        }

        System.out.println(buffer[0][0]);
    }
}
