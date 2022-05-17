package com.rct.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new LogInterceptor());
        Dog dog = (Dog) enhancer.create();
        dog.eat();
    }
}

class Dog{
    public void eat(){
        System.out.println("eat bone......");
    }
}

class LogInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before(){
        System.out.println("LogInterceptor do something before target method invoke...");
    }

    private void after(){
        System.out.println("LogInterceptor do something after target method invoke...");
    }
}