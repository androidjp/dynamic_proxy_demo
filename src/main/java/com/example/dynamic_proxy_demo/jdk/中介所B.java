package com.example.dynamic_proxy_demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 中介所B implements InvocationHandler {
    private 房东 person;

    public 中介所B(房东 person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(args[0] + "你好，其实我是中介B，让我帮你转接电话给业务本人吧：");
        return method.invoke(person, args);
    }

    public static 房东 newProxyInstance(房东 target) {
        return (房东) Proxy.newProxyInstance(中介所B.class.getClassLoader(),
                new Class<?>[]{房东.class},
                new 中介所B(target));
    }
}
