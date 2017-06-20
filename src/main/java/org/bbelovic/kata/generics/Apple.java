package org.bbelovic.kata.generics;

public class Apple extends Fruit {

    public Apple(int size) {
        super("Apple");
        super.size = size;
    }

    public int getSize() {
        return size;
    }

//    @Override
//    public int compareTo(Apple o) {
//        return this.size > o.size ? 1 : (this.size == o.size ? 0 : -1);
//    }
}
