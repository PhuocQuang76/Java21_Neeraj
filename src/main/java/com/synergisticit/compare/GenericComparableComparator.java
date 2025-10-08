package com.synergisticit.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class GenericComparableComparator {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("===== Generic Comparable =====" );
        List<GenericComparableBox<Integer>> box1 = new ArrayList<>();
        box1.add(new GenericComparableBox<>(10));
        box1.add(new GenericComparableBox<>(5));
        box1.add(new GenericComparableBox<>(20));

        Collections.sort(box1);
        for (GenericComparableBox<Integer> box : box1) {
            System.out.println(box);
        }

        System.out.println();
        System.out.println("===== Generic Comparable =====/n");
        List<GenericComparableBox<String>> box2 = new ArrayList<>();
        box2.add(new GenericComparableBox<>("Apple"));
        box2.add(new GenericComparableBox<>("Orange"));
        box2.add(new GenericComparableBox<>("Banana"));

        Collections.sort(box2);
        for (GenericComparableBox<String> box : box2) {
            System.out.println(box);
        }

        System.out.println();
        System.out.println("===== Generic Comparator =====/n");
        //Comparator
        List<GenericComparableBox<Integer>> box3 = new ArrayList<>();
        box3.add(new GenericComparableBox<>(10));
        box3.add(new GenericComparableBox<>(5));
        box3.add(new GenericComparableBox<>(20));

        Collections.sort(box3, Comparator.comparingInt(GenericComparableBox::getValue));
        for (GenericComparableBox<Integer> box : box3) {
            System.out.println(box);
        }


        System.out.println();
        System.out.println("===== Generic Comparator =====/n");
        List<GenericComparableBox<String>> box4 = new ArrayList<>();
        box4.add(new GenericComparableBox<>("Apple"));
        box4.add(new GenericComparableBox<>("Orange"));
        box4.add(new GenericComparableBox<>("Banana"));

        Collections.sort(box4, Comparator.comparing(GenericComparableBox::getValue));
        for (GenericComparableBox<String> box : box4) {
            System.out.println(box);
        }

    }
}
