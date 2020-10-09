package com.Miles.Lab_9;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company comp = new Company();

        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            Employee emp = new Employee("Ivan", "Ivanov", LocalDate.of(rand.nextInt(30)+1970, rand.nextInt(11)+1, rand.nextInt(30)+1), "Moscow, Tverskaya str., 13", "8-495-999-99-99",  rand.nextInt(100_000)+50_000);
            comp.staffList.add(emp);
        }

        System.out.println("_Staff_List_");
        for ( Employee bufEmp : comp.staffList) {
            System.out.println(bufEmp.toString());
        }

        comp.doSmthWithEmployee(new BDaySelector(LocalDate.of(1973,01,01), LocalDate.of(1997,01,01)), HandleEmployees(employee, i));

        /*LocalDate checkbday = LocalDate.of(1997,1,1);
        comp.doSmthWithEmployee(new EmployeeSelector(){
            @Override
            public boolean isNeedEmployee(Employee employee) {
                int z = employee.getBday().compareTo(checkbday);
                return employee;
            }
        }, new EmployeeHandler(){
            @Override
            public void HandleEmployees(Employee employee, int index) {

            }
        });*/
    }
}
