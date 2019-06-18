package com.spring.boot.temp.spring.aop.cglib;

import java.util.UUID;

/**
 * @ClassName AOPTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/13 17:53
 * @Version 1.0
 */
public class AOPTest {

    public static void main(String[] args) {

        OrderManager order = (OrderManager) new CGLibProxy().createProxyObject(new OrderManager("aoho"));
        order.save(UUID.randomUUID(),"zxb");
    }
}
