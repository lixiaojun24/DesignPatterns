package com.rct.singleton;

/**
 * 懒汉式 单例模式
 * 加锁的范围小了，但是在多线程并发情况下，可能会导致有多个实例
 */
public class SingletonMain03 {
    private static volatile SingletonMain03 INSTANCE;

    private SingletonMain03(){}

    public static SingletonMain03 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonMain03.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new SingletonMain03();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain03.getInstance().hashCode());
            }).start();
        }
    }
}
