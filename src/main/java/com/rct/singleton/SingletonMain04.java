package com.rct.singleton;

/**
 * 懒汉式 单例模式
 * 双重判断，避免在多线程并发情况下创建多个实例。
 */
public class SingletonMain04 {
    private static volatile SingletonMain04 INSTANCE;

    private SingletonMain04(){}

    public static SingletonMain04 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonMain04.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new SingletonMain04();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain04.getInstance().hashCode());
            }).start();
        }
    }
}
