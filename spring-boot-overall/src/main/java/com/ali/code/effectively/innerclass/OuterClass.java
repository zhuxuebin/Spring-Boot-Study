package com.ali.code.effectively.innerclass;

/**
 * @ClassName OuterClass
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/17 13:43
 * @Version 1.0
 */
public class OuterClass {

    /**
     * 成员内部类
     */
    private class InstanceInnerClass {}

    /**
     * 静态内部类-最常用
     * 访问权限：在同一个包中的其他类，可以通过OuterClass.StaticInnerClass访问
     */
    static class StaticInnerClass {}

    public static void main(String[] args) {

         //匿名内部类
        (new Thread(){}).start();
        (new Thread(){}).start();

        //方法内部类
        class MethodClass1 {}
        class MethodClass2 {}
    }

}
