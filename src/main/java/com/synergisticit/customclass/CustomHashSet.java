package com.synergisticit.customclass;

public class CustomHashSet<E> {
    private static final Object DUMMY = new Object();
    private CustomHashMap<E, Object> map;

    public CustomHashSet() {
        map = new CustomHashMap<>();
    }

    public boolean add(E element) {
        return map.put(element, DUMMY) == null;
        //map return null : no prvious mapping
        //map return old value : previous mapping

        //true = Set was modified (new element added)
        //false = Set was NOT modified (element already existed)
    }
    public boolean remove(E element) {
        return map.remove(element) == DUMMY;
    }
}
