package com.example.dynamic_proxy_demo.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 中介所B implements MethodInterceptor {

    public static <T extends 房东> 房东 newProxyInstance(Class<T> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new 中介所B());
        return (房东) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.print(objects[0] + "你好，其实我是中介B，让我帮你转接电话给业务本人吧：");
        return methodProxy.invokeSuper(o, objects);
    }
}
