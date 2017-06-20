package org.bbelovic.kata.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class WildcardWithExtendsShould {

    @Test
    public void
    allow_both_apples_and_oranges_to_be_processed() {
        List<Apple> apples = asList(new Apple(1), new Apple(2));
        List<Orange> oranges = asList(new Orange(10), new Orange(20));
        String actual = concatenate(apples);
        Assert.assertEquals("AppleApple", actual);

        concatenate(oranges);
        List<Fruit> fruits = asList(new Orange(3), new Apple(4));
        concatenate(fruits);

    }


    private String concatenate(List<? extends Fruit> collection) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < collection.size(); i++) {
            sb.append(collection.get(i).getName());
        }
        return sb.toString();
    }
}
