package org.bbelovic.kata.generics;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class PropertyExtractorTest {
    @Test
    public void
    should_extract_property_using_provided_function() {
        List<Apple> apples = asList(new Apple(1), new Apple(10), new Apple(2), new Apple(15));
        List<Orange> oranges = asList(new Orange(1), new Orange(10), new Orange(2), new Orange(15));
        Function<Apple, String> propertyExtractor = (Apple a) -> a.getName();
        Function<Orange, String> propertyExtractor2 = (Orange a) -> a.getName();

//        extractAppleProperty(apples, propertyExtractor);
//        extractAppleProperty(oranges, propertyExtractor2);

        Function<Fruit, String> nameExtractor = Fruit::getName;
        Function<Object, Integer> hashCodeExtractor = Object::hashCode;
        extractProperty(oranges, hashCodeExtractor);

        extractProperty(apples, nameExtractor);
    }

    private void extractAppleProperty(List<Apple> apples, Function<Apple, String> propertyExtractor) {
        List<String> appleNames = apples.stream()
                .map(propertyExtractor)
                .collect(Collectors.toList());
    }

    private void extractOrangeProperty(List<Orange> oranges, Function<Orange, String> propertyExtractor2) {
        List<String> orangeNames = oranges.stream()
                .map(propertyExtractor2)
                .collect(Collectors.toList());
    }

    private <T, U> void extractProperty(List<? extends T> collection, Function<T, U> extractor) {
        List<U> result = collection.stream()
                .map(extractor)
                .collect(Collectors.toList());
    }


}
