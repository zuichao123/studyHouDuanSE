package com.kjpracs.T20191226;

public class UserDaoNoImplInterface {
    public void save(User user) {
        System.out.println("保存用户信息：" + user.toString());
    }
}
