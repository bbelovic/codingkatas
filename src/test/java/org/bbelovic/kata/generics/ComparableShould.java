package org.bbelovic.kata.generics;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ComparableShould {

    @Test
    public void
    find_maximum_in_fruit_collection() {
        List<Apple> apples = asList(new Apple(1), new Apple(10), new Apple(2), new Apple(15));
        Apple actual = max(apples);
        assertEquals(15, actual.getSize());

        List<Orange> oranges = asList(new Orange(1), new Orange(10), new Orange(2));
        Orange actualOrange = max(oranges);
        assertEquals(10, actualOrange.getSize());


        List<Fruit> fruits = new ArrayList<>();
        copy(fruits, oranges);
        copy(fruits, apples);

        max(fruits);

        Comparator<Orange> orangeComparator = naturalOrder(Orange::getSize);
        Orange max = max(oranges, orangeComparator);
        Assert.assertEquals(10, max.getSize());

    }

    private <T extends Comparable<? super T>> T max(Collection<? extends T> collection) {
        Iterator<? extends T> iterator = collection.iterator();
        T candidate = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next.compareTo(candidate) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }


    private <T extends Comparable<? super T>> T max(Collection<? extends T> collection, Comparator<T> comparator) {
        Iterator<? extends T> iterator = collection.iterator();
        T candidate = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (comparator.compare(next, candidate) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    private <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        Comparator<T> cmp = (left, right) -> left.compareTo(right);
        return cmp;
    }

    private <I, T extends Comparable<? super T>> Comparator<I> naturalOrder(Function<I, T> keyExtractor) {
        Comparator<I> cmp = (left, right) -> keyExtractor.apply(left).compareTo(keyExtractor.apply(right));
        return cmp;
    }

    private <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.add(src.get(i));
        }
    }


}
