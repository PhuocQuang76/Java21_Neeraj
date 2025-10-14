package com.synergisticit.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByToList {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> personList = Arrays.asList(
                new Person(1, "John", "IT", 70000),
                new Person(2, "Jane", "HR", 65000),
                new Person(3, "Mike", "IT", 75000),
                new Person(4, "Sarah", "Finance", 80000),
                new Person(5, "David", "HR", 60000)
        );

        Map<String, List<Person>> list = personList.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment()));
        System.out.println(list);
    }
}


class Person {
    int id;
    String name;
    String department;
    int salary;

    public Person(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }

    @Override
    public String toString() {
        return "Person [id=" + id +
                ", name=" + name +
                ", department=" + department +
                ", salary=" + salary + "]";
    }
}