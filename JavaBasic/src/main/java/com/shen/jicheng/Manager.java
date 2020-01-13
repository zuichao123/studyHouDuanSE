package com.shen.jicheng;

public class Manager extends Employee {
    private Integer bonus;

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public Integer getSalary(){
        if(bonus == null){
            return super.getSalary();
        }else {
            return super.getSalary() + bonus;
        }
    }
}
