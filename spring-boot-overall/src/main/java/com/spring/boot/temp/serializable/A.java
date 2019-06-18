package com.spring.boot.temp.serializable;

import java.io.Serializable;

/**
 * @ClassName A
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/18 10:05
 * @Version 1.0
 */
public class A implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
