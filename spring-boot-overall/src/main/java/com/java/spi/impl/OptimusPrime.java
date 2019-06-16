package com.java.spi.impl;

import com.java.spi.Robot;

/**
 * @ClassName OptimusPrime
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/20 18:11
 * @Version 1.0
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("hello, i am optimusPrime robot");
    }
}
