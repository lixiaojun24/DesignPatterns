package com.rct.singleton;

/**
 * 懒汉式 单例模式
 * 静态内部类的方式，jvm保证单例
 */
public class SingletonMain05 {
    private SingletonMain05(){}

    private static class SingletonMain05Holder {
        private static SingletonMain05 INSTANCE = new SingletonMain05();
    }

    public static SingletonMain05 getInstance() {
        return SingletonMain05Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain05.getInstance().hashCode());
            }).start();
        }
    }
}
