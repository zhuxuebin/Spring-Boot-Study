package com.spring.boot.temp.spring.aop.jdk;

import java.util.UUID;

/**
 * @ClassName OrderServiceImpl
 * @Description 具体实现类
 * @Author xuery
 * @Date 2019/6/13 16:23
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    private String user = null;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void save(UUID orderId, String name) {
        System.out.println("call save()方法,save:" + name);
    }

    @Override
    public void update(UUID orderId, String name) {
        System.out.println("call update()方法");
    }

    @Override
    public String getByName(String name) {
        System.out.println("call getByName()方法");
        return "aoho";
    }
}
