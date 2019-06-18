package com.spring.boot.temp.serializable;

import java.io.Serializable;

/**
 * @ClassName B
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/18 10:06
 * @Version 1.0
 */
public class B implements Serializable {

    private static final long serialVersionUID = 2L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
