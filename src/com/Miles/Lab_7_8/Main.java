package com.Miles.Lab_7_8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String[] name = {"Michael", "Alice", "Cecil", "Annabel", "Ambrose", "Brian", "Robert", "Thomas", "Francis"};
        final String[] secondName = {"Tate", "Morgan", "Knight", "Wiggins", "Allison", "Joseph"};
        Company company = new Company();
        int baseSalary = 50000;

        // подглядел у коллеги и забрал сюда, потому что это очень красиво
        for (int i = 0; i < 180; i++) {
            company.hire(new Employee(name[i % 2], secondName[i % 4], baseSalary, new Operator()));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Employee(name[(i + 2) % 9], secondName[(i + 4) % 6], baseSalary, new Manager()));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(name[(i + 5) % 9], secondName[(i + 3) % 6], baseSalary, new TopManager(company)));
        }

        company.calcProfit();
        System.out.println("Company income: " + company.getProfit());
        outputTopSalary(company, 11);
        outputLowSalary(company, 30);

        System.out.println("!!!");
        System.out.println("Fire Staff list Size");
        for (int i = 0; i < company.getStaffListSize()/2 ; i++) {
            company.fire(i);
        }
        System.out.println("!!!");

        outputTopSalary(company, 15);
        outputLowSalary(company, 30);

    }

    public static void outputTopSalary(Company company, int num) {
        List<Employee> tmp;
        tmp = company.getTopSalaryStaff(num);
        System.out.println("Sort for TOP salary");
        for (int i = 0; i < num; i++) {
            System.out.printf(tmp.get(i).getPosition().getJobTitle() + "  ");
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBasicSalary()));
            System.out.println(" rub");
        }
    }
    public static void outputLowSalary(Company company, int num) {
        List<Employee> tmp;
        tmp = company.getLowestSalaryStaff(num);
        System.out.println("Sort for LOW salary");
        for (int i = 0; i < num; i++) {
            System.out.printf(tmp.get(i).getPosition().getJobTitle() + "  ");
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBasicSalary()));
            System.out.println(" rub");
        }
    }
}
