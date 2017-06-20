package org.bbelovic.kata.generics;

public class Orange extends Fruit {
    public Orange(int size) {
        super("Orange");
        super.size = size;
    }

    public int getSize() {
        return size;
    }

//    @Override
//    public int compareTo(Orange o) {
//        return this.size > o.size ? 1 : this.size == o.size ? 0 : -1;
//    }
}
