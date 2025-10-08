package com.synergisticit.compare;

public class GenericComparatorBox<T>{
    private T value;

    public GenericComparatorBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericComparatorBox{" +
                "value=" + value +
                '}';
    }
}
