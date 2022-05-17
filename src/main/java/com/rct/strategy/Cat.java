package com.rct.strategy;

public class Cat implements Comparable<Cat>{
    private int weight;

    private int height;

    public Cat(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat other) {
        if (this.weight < other.weight) return -1;
        else if (this.weight > other.weight) return 1;
        return 0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
