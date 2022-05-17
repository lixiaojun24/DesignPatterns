package com.rct.singleton;

/**
 * 懒汉式 单例模式
 * 方法上加锁，但是每次都要加锁，性能不好
 */
public class SingletonMain02 {
    private static SingletonMain02 INSTANCE;

    private SingletonMain02(){}

    public static synchronized SingletonMain02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonMain02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain02.getInstance().hashCode());
            }).start();
        }
    }
}
