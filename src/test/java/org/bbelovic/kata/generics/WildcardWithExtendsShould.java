package org.bbelovic.kata.generics;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardWithExtendsShould {

    @Test
    public void
    allow_both_apples_and_oranges_to_be_processed() {
        List<Apple> apples = asList(new Apple(1), new Apple(2));
        List<Orange> oranges = asList(new Orange(10), new Orange(20));
        String actual = concatenate(apples);
        assertEquals("AppleApple", actual);

        concatenate(oranges);
        List<Fruit> fruits = asList(new Orange(3), new Apple(4));
        concatenate(fruits);


        Set<Fruit> fruitSet = toSet(fruits);
        fruitSet = toSet(fruits);
    }


    private String concatenate(List<? extends Fruit> collection) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < collection.size(); i++) {
            sb.append(collection.get(i).getName());
        }
        return sb.toString();
    }


    private <T> Set<T> toSet(List<T> inputCollection) {
        Set<T> c = new HashSet<>(inputCollection);
        return c;
    }
}
