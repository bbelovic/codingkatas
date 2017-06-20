package org.bbelovic.kata.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubTypingTest {
    @Test
    public void test() {
        // Apple extend Fruit (extends Object)
        // Apple is subtype of Fruit which is subtype of Object
        Assert.assertTrue(new Apple(1) instanceof Fruit);


        Fruit fruit = new Apple(1);
        Object o = new Apple(1);

        // List is subtype of Collection
        // ArrayList is subtype of List

        List<Fruit> fruits = new ArrayList<>();
        Assert.assertTrue(fruits instanceof Collection);
        Collection<Fruit> c = fruits;

        Assert.assertTrue(fruits instanceof ArrayList);

        fruits.add(new Apple(1));
        fruits.add(new Orange(2));


        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1));

        // List<Apple> is not subtype of List<Fruit>
//        fruits = apples; // not allowed
//        fruits.add(new Orange(1));
    }
}
