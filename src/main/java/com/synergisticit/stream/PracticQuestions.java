package com.synergisticit.stream;

import java.util.*;
import java.util.stream.Collectors;


public class PracticQuestions {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1,9,3,4,8,6,7,5,2,10);

        //1. Filter Even Numbers
        List<Integer> result = integerList.stream()
                .filter(i -> i % 2 != 0)
                .collect(Collectors.toList());
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        //2. Find Maximum
        System.out.println();
        int max = integerList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        System.out.println("Max value: " + max);

        System.out.println();
        int max2 = integerList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                        .orElse(0);
        System.out.println("Max value2 : " + max2);

        //stream.max() ->  return Optional
        //stream.maptoInt.max() -> return OptionalInt

        //3. Sum of Elements
        int sumValue = integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum value: " + sumValue);

        //4. List of Names to Uppercase
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> list1 = names.stream()
                .map(s -> s.toUpperCase()) //ma(String::toUPperCase)
                .collect(Collectors.toList());
        System.out.println(list1);

        //5. Sort List
        List<Integer> sortedList = integerList
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);

        //6. Count Elements - Count the number of elements in a list that are greater than 5.
        long countNunberGreatThan5 = integerList.stream()
                .filter(i -> i > 5)
                .count();
        System.out.println(countNunberGreatThan5);

        //7. Get Distinct Elements
        //Problem: Get a list of distinct elements from a list of integers.
        List<Integer> integerList2 = Arrays.asList(1,4,7,2,7,4,7,8,6,10,3,2);
        List<Integer> distinctList = integerList2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctList);

        // 8. Reduce to Sum
        //Problem: Reduce a list of integers to their sum.

        int sum = integerList2.stream()
//                .mapToInt(Integer::intValue)
                .reduce(0,(a,b) -> a + b);
        System.out.println(sum);

        //9. Find Any
        //Problem: Return any element from a list of integers.
        List<Integer> integerList3 = Arrays.asList(1,4,7,2,7,4,7,8,6,10,3,2);
        int anyElement = integerList3
                .parallelStream()
                .findAny()
                .orElse(0);
        System.out.println(anyElement);

        //10. List First Names
        //Problem: Extract first names from a list of full names.
        List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");

        List<String> firstNames = fullNames
                .stream()
                .map(name -> name.split(" ")[0])
                .collect(Collectors.toList());

        System.out.println(firstNames);

        //11. All Match
        //Problem: Check if all numbers in a list are positive.
        List<Integer> integerList4 = Arrays.asList(13,2,3,4,5,6,7,8,9,10);
        boolean allPositive = integerList4.stream()
                .allMatch(n -> n > 0);
        System.out.println(allPositive);

        //12. None Match
        //Problem: Check if there are no negative numbers in a list.
        boolean noNgative = integerList4.stream()
                .noneMatch(n -> n < 0);
        System.out.println(noNgative);

        //13. Find First
        // Problem: Find the first element in a list of integers.
        int firstElement = integerList4.parallelStream()
                .findFirst()
                .orElse(0);
        System.out.println(firstElement);


        //14. FlatMap for Nested Lists
        //Problem: Flatten a nested list structure.
        List<List<Integer>> listOfList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );


        List<Integer> flatLists = listOfList.stream()
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
        System.out.println(flatLists);

        //15. Grouping Elements
        //Problem: Group users by age.
        List<User> users = Arrays.asList(
                new User(1, "Alice", 34),
                new User(2, "Bob", 55),
                new User(3, "Charlie",35),
                new User(4, "John", 55),
                new User(5, "Hono", 35)
        );

        Map<Integer, List<User>> listGroupedByAge = users.stream()
                .collect(Collectors.groupingBy(User::getAge));
        System.out.println(listGroupedByAge);
        //16. Peek Elements
        //Problem: Print elements of a stream during processing without altering the stream.
        List<Integer> integerLists = integerList4.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(integerLists);

        //17. Limit Stream
        //Problem: Limit the output to the first 3 elements of the list.
        List<Integer> limitList = integerList4.stream()
                .filter(n -> n > 1)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitList);

        //18. Skip Elements
        //Problem: Skip the first 2 elements of a list and return the rest.
        List<Integer> skipList = integerList4.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skipList);

        //19. Convert to Set
        //Problem: Convert a list of integers to a set to remove duplicates.
        List<Integer> duplicateList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10);
        Set<Integer> setList = duplicateList.stream()
                .collect(Collectors.toSet());
        System.out.println("Set: " + setList);

        //20. Summarizing Statistics
        //Problem: Get summary statistics for a list of integers.
        //summaryStatistics provides a summary (max, min, average, sum, count) for a stream of integers.
        IntSummaryStatistics stats = integerList4.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println(stats);






    }
}

class User {
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}







/*
1. Filter Even Numbers
Problem: Given a list of integers, return a list containing only even numbers.

Solution:
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> evenNumbers = numbers.stream()
.filter(n -> n % 2 == 0)
.collect(Collectors.toList());
Explanation: The filter method is used to apply a condition that keeps only even numbers. The collect method gathers the results into a new list. 2. Find Maximum
Problem: Find the maximum value in a list of integers.
Solution:
Optional<Integer> max = numbers.stream()
.max(Integer::compare);
Explanation: The max method takes a comparator and returns the maximum element wrapped in an Optional. 3. Sum of Elements
Problem: Calculate the sum of elements in a list of integers.
Solution:
int sum = numbers.stream()
.mapToInt(Integer::intValue)
.sum();
Explanation: mapToInt converts the stream to an IntStream, which provides the sum method to get the total. 4. List of Names to Uppercase
Problem: Convert all strings in a list to uppercase.
Solution:
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");


List<String> upperNames = names.stream()
.map(String::toUpperCase)
.collect(Collectors.toList());
Explanation: The map function applies String::toUpperCase to each element, transforming them to uppercase. 5. Sort List
Problem: Sort a list of integers in ascending order.
Solution:
List<Integer> sortedNumbers = numbers.stream()
.sorted()
.collect(Collectors.toList());
Explanation: The sorted method sorts the elements of the stream in natural order. 6. Count Elements
Problem: Count the number of elements in a list that are greater than 5.
Solution:
long count = numbers.stream()
.filter(n -> n > 5)
.count();
Explanation: The filter method removes elements that don't satisfy the condition, and count returns the number of elements remaining. 7. Get Distinct Elements
Problem: Get a list of distinct elements from a list of integers.
Solution:
List<Integer> distinctNumbers = numbers.stream()
.distinct()
.collect(Collectors.toList());
Explanation: The distinct method filters the stream to include only unique elements. 8. Reduce to Sum
Problem: Reduce a list of integers to their sum.
Solution:
int total = numbers.stream()
.reduce(0, Integer::sum);


Explanation: The reduce method takes an identity (0 in this case) and an accumulator function (Integer::sum) to calculate the total. 9. Find Any
Problem: Return any element from a list of integers.
Solution:
Optional<Integer> anyElement = numbers.stream()
.findAny();
Explanation: findAny potentially returns any element from the stream, wrapped in an Optional. 10. List First Names
Problem: Extract first names from a list of full names.
Solution:
List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");
List<String> firstNames = fullNames.stream()
.map(name -> name.split(" ")[0])
.collect(Collectors.toList());
Explanation: The map function splits each name string and selects the first part. 11. All Match
Problem: Check if all numbers in a list are positive.
Solution:
boolean allPositive = numbers.stream()
.allMatch(n -> n > 0);
Explanation: allMatch returns true if every element in the stream matches the given predicate. 12. None Match
Problem: Check if there are no negative numbers in a list.
Solution:
boolean noneNegative = numbers.stream()
.noneMatch(n -> n < 0);
Explanation: noneMatch checks that no elements match the negative condition.


13. Find First
Problem: Find the first element in a list of integers.
Solution:
Optional<Integer> first = numbers.stream()
.findFirst();
Explanation: findFirst returns the first element of the stream, wrapped in an Optional. 14. FlatMap for Nested Lists
Problem: Flatten a nested list structure.
Solution:
List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
List<Integer> flatList = nestedNumbers.stream()
.flatMap(List::stream)
.collect(Collectors.toList());
Explanation: flatMap converts each element into its own stream and then merges them into a single stream. 15. Grouping Elements
Problem: Group users by age.
Solution:
Map<Integer, List<User>> usersByAge = users.stream()
.collect(Collectors.groupingBy(User::getAge));
Explanation: The groupingBy collector groups elements based on the age property, creating a map where each key is an age and each value is a list of users with that age. 16. Peek Elements
Problem: Print elements of a stream during processing without altering the stream.
Solution:
List<Integer> peekedAtNumbers = numbers.stream()
.peek(System.out::println)
.collect(Collectors.toList());
Explanation: peek is used for debugging or performing actions without changing the stream. It prints each element before passing it along the stream.


17. Limit Stream
Problem: Limit the output to the first 3 elements of the list.
Solution:
List<Integer> limited = numbers.stream()
.limit(3)
.collect(Collectors.toList());
Explanation: limit truncates the stream to be no longer than the specified size. 18. Skip Elements
Problem: Skip the first 2 elements of a list and return the rest.
Solution:
List<Integer> skipped = numbers.stream()
.skip(2)
.collect(Collectors.toList());
Explanation: skip discards the first n elements of the stream. 19. Convert to Set
Problem: Convert a list of integers to a set to remove duplicates.
Solution:
Set<Integer> uniqueNumbers = numbers.stream()
.collect(Collectors.toSet());
Explanation: Collecting the stream into a Set automatically removes duplicates. 20. Summarizing Statistics
Problem: Get summary statistics for a list of integers.
Solution:
IntSummaryStatistics stats = numbers.stream()
.mapToInt(Integer::intValue)
.summaryStatistics();
Explanation: summaryStatistics provides a summary (max, min, average, sum, count) for a stream of integers.

 */