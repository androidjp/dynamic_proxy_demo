package com.example.dynamic_proxy_demo.jdk;

/**
 * @author Jasper Wu
 * @date 2019/11/20
 **/
public class 业主本人 implements 房东 {
    @Override
    public void 租房子(String 租客) {
        System.out.println(租客 +", 你好, 我是业主本人，你爱租不租");
    }
}
