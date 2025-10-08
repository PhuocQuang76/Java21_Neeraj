package com.synergisticit.collection;

import java.util.*;

public class SequenceCollection {
    Map<Integer,String> map = new HashMap<>();

    public static void main(String[] args) {
        // Different implementations, same interface
        SequencedCollection<String> arrayList = new ArrayList<>();
        SequencedCollection<String> linkedList = new LinkedList<>();
        SequencedCollection<String> deque = new ArrayDeque<>();

        // Same operations work on all
        arrayList.addFirst("5");
        arrayList.addLast("10");
        arrayList.addFirst("15");


        linkedList.addFirst("5");
        linkedList.addLast("10");
        linkedList.addFirst("15");


        deque.addFirst("5");
        deque.addLast("10");
        deque.addFirst("15");

        // But performance varies:
        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(deque);

        System.out.println(arrayList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(deque.getLast());
        String str = """
             Str
             Str""";
        System.out.println(str.length());
    }
}
