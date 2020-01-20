package com.fang.reflect;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private double mony;
    public String hibby;

    public Person(){}
    private Person(int id){}
    private Person(String name, String hibby){
        this.name = name;
        this.hibby = hibby;
    }
    private Person(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Person(String name, double mony){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mony=" + mony +
                ", hibby='" + hibby + '\'' +
                '}';
    }
}
