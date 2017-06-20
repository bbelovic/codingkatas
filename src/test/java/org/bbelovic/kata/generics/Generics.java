package org.bbelovic.kata.generics;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Generics {

    public void test() {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.addAll(asList(new Apple(2), new Apple(3)));

        ArrayList<Orange> oranges = new ArrayList<>();
        oranges.addAll(asList(new Orange(4), new Orange(5)));

        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(asList("a", "b", "c"));
    }
}
