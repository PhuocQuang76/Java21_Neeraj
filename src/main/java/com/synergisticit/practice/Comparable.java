package com.synergisticit.practice;

import java.util.*;

public class Comparable<C> {

    public static void main(String[] args) {
//        Person p1 = new Person("John", 30);
//        Person p2 = new Person("John", 30);  // Same values as p1
//        System.out.println(p1.equals(p2));   // Will print true
//        System.out.println(p1.hashCode());
//        System.out.println(p2.hashCode());


//        ExecutorService executor = Executors.newCachedThreadPool();
//        Callable<String> task1 = () -> {
//            Thread.sleep(100);
//            return "Hello";
//        };
//
//        Callable<String> task2 = () -> {
//            Thread.sleep(200);
//            return "World";
//        };
//
//        Future<String> future1 = executor.submit(task1);
//        Future<String> future2 = executor.submit(task2);
//
//        System.out.println(future2.get(150, TimeUnit.MILLISECONDS));
//        System.out.println(future1.get());
//
//        executor.shutdown();
          // Line 4
// What is the output?


        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        for (String key : map.keySet()) {
            map.remove(key);
        }
        System.out.println(map.size());
    }
}


class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                (name != null ? name.equals(person.name) : person.name == null);
    }
}

class Person1 {
    private String name;
    private int age;
    private String city;

    public Person1(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // Constructor, getters, toString
}
