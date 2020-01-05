package com.kjpracs.T20191226;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        if(name != null && name.length() > 0){
            sb.append(name);
        }
        sb.append(",年龄：");
        if(age != null){
            sb.append(age);
        }
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
