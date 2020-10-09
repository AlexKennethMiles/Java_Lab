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
        int count = 0;
        for (Employee employee: staffList) {
            if (selector.isNeedEmployee(employee)) {
                handler.HandleEmployees(employee, count);
                count++;
            }
        }
        System.out.println("RESULT: We have " + count + " person in needed Bday range");
    }

    @Override
    public String toString() {
        return "Company{" +
                "staffList=" + staffList +
                '}';
    }
}
