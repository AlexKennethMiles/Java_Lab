package com.Miles.Lab_7_8;

public class Employee {
    private String lastName;
    private String firstName;
    private double basicSalary;
    private EmployeePosition position;

    public Employee(String lastName, String firstName, int basicSalary, EmployeePosition position) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.basicSalary = basicSalary;
        this.position = position;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
}
