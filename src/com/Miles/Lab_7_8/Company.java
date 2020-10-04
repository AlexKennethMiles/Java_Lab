package com.Miles.Lab_7_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private double profit = 0;
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee); // удаляем Employee по объекту
        calcProfit(); // пересчитываем доход компании
    }

    public void calcProfit(){
        this.profit = 0;
        for (Employee emp : employeeList) // пробегаемся по всему листу с Employee'ми
            if (emp.getPosition() instanceof Manager) { // если наткнулись на Manager
                profit += ((Manager) emp.getPosition()).generateTotalSalary(); // то плюсуем его доход в прибыл компании
            }
    }

    public double getProfit() {
        return profit;
    }

    public void fire(int index) {
        employeeList.remove(index); // удаляем Employee по номеру в List
        calcProfit(); // пересчитываем доход компании
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> buffer = employeeList; // buffer List
        Employee buf; // buffer object
        for (int i = 0; i < buffer.size() - 1; i++) { //bubble sort
            for (int j = i + 1; j < buffer.size(); j++) {
                if (buffer.get(i).getPosition().calcSalary(buffer.get(i).getBasicSalary()) < buffer.get(j).getPosition().calcSalary(buffer.get(j).getBasicSalary())) {
                    buf = buffer.get(j);
                    buffer.set(j, buffer.get(i));
                    buffer.set(i, buf);
                }
            }
        }
        return buffer.subList(0, count); // возвращаем отсортированный лист с Employee'ми
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> buffer = employeeList; // buffer List
        Employee buf; // buffer object
        for (int i = 0; i < buffer.size() - 1; i++) { //bubble sort
            for (int j = i + 1; j < buffer.size(); j++) {
                if (buffer.get(i).getPosition().calcSalary(buffer.get(i).getBasicSalary()) > buffer.get(j).getPosition().calcSalary(buffer.get(j).getBasicSalary())) {
                    buf = buffer.get(j);
                    buffer.set(j, buffer.get(i));
                    buffer.set(i, buf);
                }
            }
        }
        return buffer.subList(0, count); // возвращаем отсортированный лист с Employee'ми
    }

    public int getStaffListSize() { // вспомогательный метод
        return employeeList.size();
    }
}
