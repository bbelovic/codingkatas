package org.bbelovic.kata.generics;

public class Fruit implements Comparable<Fruit> {
    private final String name;
    protected int size;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Fruit o) {
        return this.size > o.size ? 1 : this.size == o.size ? 0 : -1;
    }
}
