package com.rct.strategy;

import java.util.Comparator;

public class HeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getHeight() > o2.getHeight()) return 1;
        else if (o1.getHeight() < o2.getHeight()) return -1;
        return 0;
    }
}
