package com.example.dynamic_proxy_demo.cglib;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 房天下平台 {

    public static void main(String[] args) {
        房东 jay = new 业主本人();
//        房东 a = 中介所A.newProxyInstance(业主本人.class);
//        房东 b = 中介所B.newProxyInstance(业主本人.class);

        jay.租房子("Jasper");
//        a.租房子("Jasper");
//        b.租房子("Jasper");
    }
}
