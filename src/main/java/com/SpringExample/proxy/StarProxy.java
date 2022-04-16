package com.SpringExample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
明星演出前需要有人收钱，由于要准备演出，自己不做这个工作，一般交给一个经纪人。
便于理解，它的名字以Proxy结尾，但他不是代理类，
原因是它没有实现我们的明星接口，无法对外服务，它仅仅是一个wrapper。
 */
public class StarProxy implements InvocationHandler {

    // 目标类，也就是被代理对象
    private Object target;
    public void setTarget(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以做增强
        System.out.println("收钱");

        Object result = method.invoke(target, args);
        return result;
    }

    // 生成代理类
    public Object CreatProxyedObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
