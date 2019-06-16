package com.java.spi.impl;

import com.java.spi.Robot;

/**
 * @ClassName Bumblebee
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 18:12
 * @Version 1.0
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("hello, i am bumblebee robot");
    }
}
