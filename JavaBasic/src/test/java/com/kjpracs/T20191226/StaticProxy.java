package com.kjpracs.T20191226;

/**
 * 因为调⽤⽅⽆法保证 User 实例中的姓名 name 有值、年龄 age 在有效范围之内 0~200。我
 * 们需要增加⼀个验证，name 不能为空且 age 在 0~200范围内时才进⾏保存操作；并且不允许修改
 * UserDaoImpl 类的代码。
 * 静态代理
 */
public class StaticProxy implements UserDao {
    private UserDao target;
    public StaticProxy(UserDao dao){
        target = dao;
    }

    @Override
    public void save(User user) {
        if(user.getName() == null || user.getName().length() == 0){
            System.out.println("name 为空，不保存");
            return;
        }
        if(user.getAge() == null || user.getAge() < 0 || user.getAge() > 200){
            System.out.println("age 不在有效范围内，不保存");
            return;
        }
        target.save(user);
    }

    @Override
    public void delete() {
        System.out.printf("staticproxy 执行删除");
    }

    public static void main(String[] args) {
        // static proxy
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(2);

        UserDao dao2 = new UserDaoImpl();
        StaticProxy proxy = new StaticProxy(dao2);
        proxy.save(user2);
    }
}
