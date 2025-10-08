package com.synergisticit.compare;

public class ComparableEmployee implements Comparable<ComparableEmployee> {
    private String name;
    private int age;
    private double salary;

    public ComparableEmployee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(ComparableEmployee other) {
        return Double.compare(this.salary, other.salary);
    }
    
    @Override
    public String toString() {
        return "ComparableEmployee{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               '}';
    }
}
