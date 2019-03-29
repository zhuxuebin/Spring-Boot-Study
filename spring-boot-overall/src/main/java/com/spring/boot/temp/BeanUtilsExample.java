package com.spring.boot.temp;

import org.springframework.beans.BeanUtils;

/**
 * @ClassName BeanUtilsExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/29 10:45
 * @Version 1.0
 */
public class BeanUtilsExample {

    public static void main(String[] args) {

        Object1 object1 = new Object1();
        object1.setName("zxb");
        object1.setAge("1");
        Object2 object2 = new Object2();
        BeanUtils.copyProperties(object1,object2);

        System.out.println(object2);
    }
}

class Object1{

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class Object2{

    private String name;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Object2{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}



