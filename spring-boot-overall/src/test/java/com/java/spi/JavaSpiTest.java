package com.java.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @ClassName JavaSpiTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 18:15
 * @Version 1.0
 */
public class JavaSpiTest {

    @Test
    public void test_sayHello(){
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java Spi");
        serviceLoader.forEach(Robot::sayHello);
    }
}
