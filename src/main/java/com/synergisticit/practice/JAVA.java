package com.synergisticit.practice;

public class JAVA {
    static int calculateArea(Shape s) {
        return switch (s) {
            case Circle c -> 100;
            case Square q -> 50;
            default -> throw new IllegalStateException("Unexpected shape: " + s.getClass());
        };

    }
    public static void main(String[] args) {
        System.out.println(calculateArea(new Circle(5)));
        //Shape1
        Shape1 s1 = new Circle1();
        System.out.println(s1.area());

        System.out.println(GuardedPattern.checkNumber(5));
        System.out.println(GuardedPattern.checkNumber(-1.0));


    }

}

sealed interface Shape {

}

non-sealed class Circle implements Shape {
    int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
}

non-sealed class Square implements Shape {
    int length;
    public Square(int length) {
        this.length = length;
    }
}

//================
sealed interface Shape1 permits Circle1, Rectangle1 {
    double area();
}

non-sealed class Circle1 implements Shape1 {
    private double radius;
    public double area() { return Math.PI * radius * radius; }
}

non-sealed class Rectangle1 implements Shape1 {
    protected double width, height;
    public double area() { return width * height; }
}

//================
class GuardedPattern {
    static String checkNumber(Object obj) {
        return switch (obj) {
            case Integer i when i > 0 -> "Positive";
            case Integer i -> "Non-positive";
            case Double d when d > 0 -> "Positive double";
            case Number n -> "Other number";
            default -> "Not a number";
        };
    }
}