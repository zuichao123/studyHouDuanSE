package com.kjpracs.T20191220;

import java.util.Date;

public class Manager extends Employee {
    private Integer bonus;

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public Integer getSalary() {
        return super.getSalary() + bonus;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("普通员⼯");
        employee.setHireDay(new Date());
        employee.setSalary(100);
        System.out.println(employee.toString());

        Manager manager = new Manager();
        manager.setName("经理");
        manager.setHireDay(new Date());
        manager.setSalary(120);
        manager.setBonus(30);
        System.out.println(manager.toString());
    }
}
