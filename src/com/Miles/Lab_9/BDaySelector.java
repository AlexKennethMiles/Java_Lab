package com.Miles.Lab_9;

import java.time.LocalDate;

public class BDaySelector implements  EmployeeSelector{
     private LocalDate lowerLimit;
     private LocalDate upperLimit;

    public BDaySelector(LocalDate lowerLimit, LocalDate upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }


    @Override
    public boolean isNeedEmployee(Employee employee) {
        int x = employee.getBday().compareTo(lowerLimit);
        int y = employee.getBday().compareTo(upperLimit);
        if ((x>=1||x==0) && (y<=-1||y==0)){
            return true;
        }
        return false;
    }
}
