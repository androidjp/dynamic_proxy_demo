package com.example.dynamic_proxy_demo.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 中介所A implements MethodInterceptor {

    public static <T extends 房东> 房东 newProxyInstance(Class<T> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new 中介所A());
        return (房东) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("租房子")) {
            System.out.println(objects[0] + "你好，我是房东，我诚挚向你推荐这间房子");
            return null;
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
