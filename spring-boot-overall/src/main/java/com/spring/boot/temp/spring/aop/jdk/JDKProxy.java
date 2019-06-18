package com.spring.boot.temp.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxy
 * @Description 代理类
 * @Author xuery
 * @Date 2019/6/13 17:28
 * @Version 1.0
 */
public class JDKProxy implements InvocationHandler {

    //需要代理的目标对象
    private Object targetObject;

    //返回代理对象，之后调用代理对象的方法时会调用对应的invoke方法
    public Object createProxyInstance(Object targetObject){
        this.targetObject = targetObject;

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //被代理对象
        OrderServiceImpl bean = (OrderServiceImpl) this.targetObject;

        Object result = null;

        System.out.println("before invoke...");

        if(bean.getUser() != null){
            result = method.invoke(targetObject, args);
        }

        System.out.println("after invoke...");
        return result;
    }
}
