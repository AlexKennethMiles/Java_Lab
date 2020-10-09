package com.Miles.Lab_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company comp = new Company();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee("Ivan", "Ivanov", LocalDate.of(rand.nextInt(30)+1970, rand.nextInt(11)+1, rand.nextInt(30)+1), "Moscow, Tverskaya str., 13", "8-495-999-99-99",  rand.nextInt(100_000)+50_000);
            comp.staffList.add(emp);
        }

        System.out.println("_Staff_List_");
        for ( Employee bufEmp : comp.staffList) {
            System.out.println(bufEmp.toString());
        }

        System.out.println('\n' + "___Interface___");
        comp.doSmthWithEmployee(new BDaySelector(LocalDate.of(1975,01,01), LocalDate.of(1995,01,01)), (employee, i)->System.out.println("We find a needed person: " + employee.getFirstName() + " with Birthday: " + employee.getBday()));

        LocalDate checkFirstDate = LocalDate.of(1975,1,1);
        LocalDate checkSecondDate = LocalDate.of(1985,1,1);

        System.out.println('\n' + "___Anonymous_Class___");
        comp.doSmthWithEmployee(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                int x = employee.getBday().compareTo(checkFirstDate);
                int y = employee.getBday().compareTo(checkSecondDate);
                return (x>=1||x==0) && (y<=-1||y==0);
            }
        }, new EmployeeHandler() {
            @Override
            public void HandleEmployees(Employee employee, int index) {
                System.out.println("=====" + (index+1) + "======");
                System.out.println(employee);
            }
        });

        System.out.println('\n' + "___Lambda___");
        ArrayList<Employee> selection = new ArrayList<>();
        comp.doSmthWithEmployee(
                car -> car.getBasicSalary() > 100_000,
                (car, i) -> selection.add(car));
        for ( Employee bufEmp : selection) {
            System.out.println(bufEmp.toString());
        }

    }
}
