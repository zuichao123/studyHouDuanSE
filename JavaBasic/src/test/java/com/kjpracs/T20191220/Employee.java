package com.kjpracs.T20191220;

import java.util.Date;

public class Employee {
    private String name;
    private Date hireDay;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("员⼯：");
        str.append(getName());
        str.append("，⼊职时间：");
        str.append(getHireDay());
        str.append("，薪⽔：");
        str.append(getSalary());

        return str.toString();
    }
}


