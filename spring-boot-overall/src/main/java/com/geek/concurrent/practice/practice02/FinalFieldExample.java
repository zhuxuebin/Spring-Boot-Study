package com.geek.concurrent.practice.practice02;

/**
 * @ClassName FinalFieldExample
 * @Description "逸出"举例
 * @Author xuery
 * @Date 2019/4/22 15:03
 * @Version 1.0
 */
public class FinalFieldExample {

    final int x;

    public static FinalFieldExample global;

    public FinalFieldExample() {
        //(1)
//        x = 3;
        //(2)此处this逸出，global读取到的global.x可能为0；比如(1)/(2)重排序
        global = this;
        System.out.println(global.x);
        x = 3;
    }

    public static void main(String[] args) {
        FinalFieldExample example = new FinalFieldExample();
    }
}
