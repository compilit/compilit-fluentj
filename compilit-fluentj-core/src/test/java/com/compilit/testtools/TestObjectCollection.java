package com.compilit.testtools;

import java.util.ArrayList;
import java.util.Collection;

public class TestObjectCollection<T> {

    private final Collection<TestObject<T>> collection;

    private TestObjectCollection(T value, int size) {
        this.collection = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            collection.add(TestObject.withValue(value));
        }

    }

    public static <T> TestObjectCollection<T> of(T value, int size) {
        return new TestObjectCollection<>(value, size);
    }

    public Collection<TestObject<T>> getCollection() {
        return collection;
    }
}
