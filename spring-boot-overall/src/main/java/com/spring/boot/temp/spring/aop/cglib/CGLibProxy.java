package com.spring.boot.temp.spring.aop.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CGLibProxy
 * @Description cglib动态代理类
 * @Author xuery
 * @Date 2019/6/13 17:42
 * @Version 1.0
 */
public class CGLibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj){
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);

        //增强后的目标类
        Object proxyObj = enhancer.create();

        return proxyObj;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        //切面逻辑（advise），此处是在目标类代码执行之前
        System.out.println("---before intercept----");
        obj = method.invoke(targetObject, args);
        System.out.println("---after intercept----");
        return obj;
    }

}
