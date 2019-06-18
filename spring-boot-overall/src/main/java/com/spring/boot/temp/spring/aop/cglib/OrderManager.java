package com.spring.boot.temp.spring.aop.cglib;

import java.util.UUID;

/**
 * @ClassName OrderManager
 * @Description 要代理的类
 * @Author xuery
 * @Date 2019/6/13 17:41
 * @Version 1.0
 */
public class OrderManager {

    private String user = null;

    public OrderManager() {
    }

    public OrderManager(String user) {
        this.setUser(user);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //...

    public void save(UUID orderId, String name) {
        System.out.println("call save()方法,save:" + name);
    }

    public void update(UUID orderId, String name) {
        System.out.println("call update()方法");
    }

    public String getByName(String name) {
        System.out.println("call getByName()方法");
        return "aoho";
    }
}
