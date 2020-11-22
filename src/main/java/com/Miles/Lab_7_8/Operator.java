package com.Miles.Lab_7_8;

public class Operator implements EmployeePosition{
    private double totalSalary = 0;

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double basicSalary) {
        return basicSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
