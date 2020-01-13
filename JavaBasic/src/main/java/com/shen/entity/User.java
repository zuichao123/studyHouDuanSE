package com.shen.entity;

/**
 * 实现Comparable接口，便于对象比较大小
 */
public class User implements Comparable{
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if(this.id > user.getId()){
            return 1;
        }else if(this.id == user.getId()){
            return 0;
        }else {
            return -1;
        }
    }
}
