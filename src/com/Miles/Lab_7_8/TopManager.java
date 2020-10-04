package com.Miles.Lab_7_8;

public class TopManager implements EmployeePosition{
    Company comp = new Company();
    private double totalSalary = 0;

    public TopManager(Company comp){
        this.comp = comp;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double basicSalary) {
        if (comp.getProfit() > 10000000){
            return basicSalary * 2.5;
        }
        else{
            return  basicSalary;
        }
    }
}
