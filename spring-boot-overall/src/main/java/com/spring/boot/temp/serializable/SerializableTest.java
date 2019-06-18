package com.spring.boot.temp.serializable;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/18 10:22
 * @Version 1.0
 */
public class SerializableTest {

    public static void main(String[] args) {
        A a = new A();
        a.setName("zxb");

        B b = JSON.parseObject(JSON.toJSONString(a), B.class);

        System.out.println(JSON.toJSONString(b));

        String s = "1";
        System.out.println(s.substring(1));
    }
}
