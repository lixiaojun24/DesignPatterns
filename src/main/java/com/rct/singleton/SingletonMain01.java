package com.rct.singleton;

/**
 * 饿汉式 单例模式
 * 类加载的时候就初始化
 */
public class SingletonMain01 {
    private final static SingletonMain01 INSTANCE = new SingletonMain01();

    private SingletonMain01(){}

    public static SingletonMain01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain01.getInstance().hashCode());
            }).start();
        }
    }
}
