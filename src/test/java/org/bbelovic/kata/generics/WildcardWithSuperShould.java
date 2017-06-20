package org.bbelovic.kata.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class WildcardWithSuperShould {

    @Test
    public void
    allow_processing_of_apples_and_oranges() {
        List<Apple> apples = asList(new Apple(1), new Apple(2));
        List<Orange> oranges = asList(new Orange(10), new Orange(20));
        List<Fruit> fruits = asList(new Orange(3), new Apple(4));

        List<Fruit> dst = new ArrayList<>();

        List<Object> objects = Collections.singletonList(new Object());

        List<Apple> dstApple = new ArrayList<>();
        List<Orange> dstOrange = new ArrayList<>();
        List<Fruit> dstFruit = new ArrayList<>();
        copy(objects, apples);
        copy(objects, oranges);
        copy(objects, fruits);
        copy(objects, dst);
    }

    private <T> void copy(List<? super T> dst, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.add(src.get(i));
        }
    }
}
