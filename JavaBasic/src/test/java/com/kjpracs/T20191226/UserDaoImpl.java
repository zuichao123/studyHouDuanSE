package com.kjpracs.T20191226;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("保存用户信息：" + user.toString());
    }

    @Override
    public void delete() {
        System.out.printf("执行删除");
    }

    public static void main(String[] args) {
        // 普通实现
        User user = new User();
        user.setAge(32);
        user.setName("张三");

        UserDao dao = new UserDaoImpl();
        dao.save(user);
    }
}
