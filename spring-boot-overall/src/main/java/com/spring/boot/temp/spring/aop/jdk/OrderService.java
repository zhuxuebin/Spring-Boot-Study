package com.spring.boot.temp.spring.aop.jdk;

import java.util.UUID;

/**
 * @ClassName OrderService
 * @Description 接口类
 * @Author xuery
 * @Date 2019/6/13 16:22
 * @Version 1.0
 */
public interface OrderService {
    public void save(UUID orderId, String name);

    public void update(UUID orderId, String name);

    public String getByName(String name);
}
