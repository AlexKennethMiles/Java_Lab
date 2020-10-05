package com.Miles.Lab_9;

import java.util.ArrayList;

public class Company {
    ArrayList<Employee> staffList= new ArrayList<Employee>();

    public void hire(Employee emp){
        staffList.add(emp);
    }

    public void fire(int index){
        staffList.remove(index);
    }


}
