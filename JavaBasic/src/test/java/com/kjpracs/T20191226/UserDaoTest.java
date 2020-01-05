package com.kjpracs.T20191226;

import java.lang.reflect.Proxy;

public class UserDaoTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(32);
        user.setName("张三");

        UserDao dao = new UserDaoImpl();
        dao.save(user);

        // static proxy
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(-2);

        UserDao dao2 = new UserDaoImpl();
        UserDaoProxy proxy = new UserDaoProxy(dao2);
        proxy.save(user2);

        // auto proxy
        UserDao dao3 = new UserDaoImpl();

        ClassLoader classLoader = dao.getClass().getClassLoader();
        Class[] interfaces = dao.getClass().getInterfaces();
        CheckHandler handler = new CheckHandler(dao3);

        UserDao proxy2 = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, handler);
        User user3 = new User();
        user3.setName("王五");
        user3.setAge(1);
        proxy2.save(user3);

        // cglib proxy
        UserDao dao4 = new UserDaoImpl();

        User user4 = new User();
        user4.setName("张三");
        user4.setAge(-1);

        UserDao proxy4 = (UserDao) new CgligProxy(dao).getProxyInstance();
        proxy4.save(user4);
    }
}
