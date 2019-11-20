package com.example.dynamic_proxy_demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 中介所A implements InvocationHandler {
    private 房东 person;

    public 中介所A(房东 person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("租房子")) {
            System.out.println(args[0] + "你好，我是房东，我诚挚向你推荐这间房子");
            return null;
        }
        return method.invoke(person, args);
    }

    public static 房东 newProxyInstance(房东 target) {
        return (房东) Proxy.newProxyInstance(中介所A.class.getClassLoader(),
                new Class<?>[]{房东.class},
                new 中介所A(target));
    }
}
