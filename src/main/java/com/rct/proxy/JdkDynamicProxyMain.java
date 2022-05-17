package com.rct.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyMain {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Animal cat = new Cat();
        Animal catProxy = (Animal) Proxy.newProxyInstance(Cat.class.getClassLoader(),
                new Class[]{Animal.class}, new LogHandler(cat));
        catProxy.eat();
    }
}

interface Animal{
    void eat();
}

class Cat implements Animal{
    @Override
    public void eat(){
        System.out.println("The cat eat fish...");
    }
}

class LogHandler implements InvocationHandler{
    private Animal animal;

    public LogHandler(Animal animal){
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(animal, args);
        after();
        return result;
    }

    private void before(){
        System.out.println("LogHandler do something before target method invoke...");
    }

    private void after(){
        System.out.println("LogHandler do something after target method invoke...");
    }
}
