package com.kjpracs.T20191226;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.lang.reflect.Method;
import java.util.List;

public class CgligProxy implements IMethodInterceptor, Callback {
    private Object target;

    public CgligProxy(Object target) {
        this.target = target;
    }

    private boolean checkSaveUserParam(String methodName, Object[] args) {
        if (!(target instanceof UserDao)) {
            return true;
        }
        if (!"save".equals(methodName)) {
            return true;
        }
        if (args == null || args.length < 1 || !(args[0] instanceof User))
        {
            return true;
        }
        User user = (User) args[0];

        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存");
            return false;
        }
        if (user.getAge() == null || user.getAge() < 0 || user.getAge() >
                200) {
            System.out.println("age 不在有效范围 0~200 内，不保存");
            return false;
        }

        return true;
    }

    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        if (checkSaveUserParam(method.getName(), args)) {
            return method.invoke(target, args);
        }
        return null;
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        return null;
    }

    public static void main(String[] args) {
        // cglib proxy
        UserDao dao4 = new UserDaoImpl();

        User user4 = new User();
        user4.setName("张三");
        user4.setAge(33);

        UserDao proxy4 = (UserDao) new CgligProxy(dao4).getProxyInstance();
        proxy4.save(user4);
    }
}
