package com.spring.boot.temp.spring.aop.jdk;

import java.util.UUID;

/**
 * @ClassName AOPTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/13 17:36
 * @Version 1.0
 */
public class AOPTest {

    public static void main(String[] args) {
        JDKProxy factory = new JDKProxy();

        OrderService orderService = (OrderService) factory.createProxyInstance(new OrderServiceImpl("zxb"));

        orderService.save(UUID.randomUUID(),"zxb");
    }
}
