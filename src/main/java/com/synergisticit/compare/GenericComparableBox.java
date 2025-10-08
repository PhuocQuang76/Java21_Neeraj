package com.synergisticit.compare;

public class GenericComparableBox<T extends Comparable<T>> implements Comparable<GenericComparableBox<T>>{
    private T value;

    public GenericComparableBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(GenericComparableBox<T> other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return "GenericComparableBox{" +
                "value=" + value +
                '}';
    }
}
