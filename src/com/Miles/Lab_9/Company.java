package com.Miles.Lab_9;

import java.util.ArrayList;

public class Company {
    ArrayList<Employee> staffList;

    public Company()
    {
        staffList = new ArrayList<Employee>();
    }
    public void hire(Employee emp){
        staffList.add(emp);
    }

    public void fire(int index){
        staffList.remove(index);
    }

    public void doSmthWithEmployee(EmployeeSelector selector, EmployeeHandler handler){
        System.out.println("We use the ___Interface___");
        int count = 0;
        for (Employee employee: staffList) {
            if (selector.isNeedEmployee(employee)) {
                handler.HandleEmployees(employee, count);
                count++;
                System.out.println("We find a needed person: " + employee.getFirstName() + " with Birthday: " + employee.getBday());
            }
        }
        System.out.println("We have " + count + " person in needed Bday range");
    }

    @Override
    public String toString() {
        return "Company{" +
                "staffList=" + staffList +
                '}';
    }
}
