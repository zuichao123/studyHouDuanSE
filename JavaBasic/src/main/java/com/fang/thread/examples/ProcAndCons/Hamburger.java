package com.fang.thread.examples.ProcAndCons;

public class Hamburger {
    private int id;

    public Hamburger(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hamburger[ " +
                "id=" + id +
                " ]";
    }
}
