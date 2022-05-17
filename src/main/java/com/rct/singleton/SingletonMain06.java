package com.rct.singleton;

/**
 * 懒汉式 单例模式
 * 枚举类，没有构造方法，保证单例
 */
public enum SingletonMain06 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(SingletonMain06.INSTANCE.hashCode());
            }).start();
        }
    }
}
