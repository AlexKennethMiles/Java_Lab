package com.Miles.Lab_9;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company comp = new Company();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee("Ivan", "Ivanov", LocalDate.of(rand.nextInt(25)+1970, rand.nextInt(12), rand.nextInt(31)), "Moscow, Tverskaya str., 13", rand.nextInt(100_000)+50_000);
            comp.staffList.add(emp);
        }


        for ( Employee bufEmp : comp.staffList) {
            System.out.println(bufEmp.toString());
        }
    }
}
