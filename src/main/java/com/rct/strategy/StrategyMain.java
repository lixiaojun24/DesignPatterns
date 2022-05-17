package com.rct.strategy;

import java.util.Arrays;

public class StrategyMain {
    public static void main(String[] args) {
        Cat[] arrys = {new Cat(3,3), new Cat(2,2), new Cat(5,5)};
        Arrays.sort(arrys);
        for(Cat cat : arrys) {
            System.out.print(cat);
        }
        System.out.println();
        Cat[] arrys2 = {new Cat(3,7), new Cat(2,2), new Cat(5,5)};
        Arrays.sort(arrys2, new HeightComparator());
        for(Cat cat : arrys2) {
            System.out.print(cat);
        }
    }
}
