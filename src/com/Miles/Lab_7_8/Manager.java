package com.Miles.Lab_7_8;

import java.util.Random;

public class Manager implements EmployeePosition{
    private double totalSalary = 0;

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double basicSalary) {
        return basicSalary + totalSalary * 0.05;
    }

    private Random rand = new Random();

    public double generateTotalSalary(){
        totalSalary = (rand.nextInt(25000) + 115000);
        return totalSalary;
    }
}
