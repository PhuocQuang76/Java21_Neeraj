package com.synergisticit.practice;

public class JAVA {
    static int calculateArea(Shape s) {
        return switch (s) {
            case Circle c -> 100;
            case Square q -> 50;
//            default -> throw new IllegalStateException("Unexpected shape: " + s.getClass());
        };

    }
    public static void main(String[] args) {
        System.out.println(calculateArea(new Circle(5)));
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