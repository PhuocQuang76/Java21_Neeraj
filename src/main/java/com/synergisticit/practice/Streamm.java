package com.synergisticit.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Streamm {
    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        l.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
//
//        Integer[] array = new Integer[] {1, 2, 3, 4, 5};
//        java.util.stream.Stream<Integer> s1 = Arrays.stream(array);
//        java.util.stream.Stream<Integer> s2 = java.util.stream.Stream.of(array);

        //Using builder
//        java.util.stream.Stream.Builder<Integer> builder = java.util.stream.Stream.builder();
//        builder.add(1);
//        builder.add(2);
//        builder.add(3);
//        builder.add(4);
//        builder.add(5);
//        java.util.stream.Stream<Integer> s3 = builder.build();
//
//
//
//        java.util.stream.Stream<String> stream = java.util.stream.Stream.of("a", "b", "c","d","d");
//        stream.map(String::toUpperCase).forEach(System.out::println);
//        stream.distinct().forEach(System.out::println);
//
//        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(10,12,14));
//        lists.stream()
//                .flatMap(list -> list.stream())
//                .forEach(System.out::println);


//        int sum = java.util.stream.Stream.of(1, 2, 3, 4, 5)
//                .reduce(1, (a, b) -> a + b);
//        System.out.println(sum);


//        int totalLength = java.util.stream.Stream.of("a", "bb", "ccc")
//                .reduce(0,
//                        (sum, str) -> sum + str.length(),  // Accumulator
//                        Integer::sum);
//        System.out.println(totalLength);// Combiner


        List<String> list = new ArrayList<>();
        java.util.stream.Stream.of("a", "b", "c")
                .peek(list::add)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println(list);

        List<Integer> ll = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);  // Fixed: removed trailing comma

        List<Integer> result = ll.stream()
                .filter(i -> i > 2)  // Changed to a meaningful condition
                .peek(i -> System.out.println("After filter: " + i))
                .map(i -> i * -1)
                .peek(i -> System.out.println("After map: " + i))
                .sorted()
                .peek(i -> System.out.println("After sort: " + i))
                .collect(Collectors.toList());  // Added terminal operation

        System.out.println("Final result: " + result);
        //System.out.println(result.stream().count());
        //result.stream.collect(Collectors.toList());  // Terminal operation
        //long count = stream.count();  // IllegalStateException: stream has alre

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


        System.out.println("Sequential stream:");
        long time = System.currentTimeMillis();


        numbers.stream()
                .forEach(i -> {System.out.println();});
        System.out.println("Time taken: " + (System.currentTimeMillis() - time));


    }
}
