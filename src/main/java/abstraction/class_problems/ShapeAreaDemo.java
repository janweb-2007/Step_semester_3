package abstraction.class_problems;

public class ShapeAreaDemo {

    static abstract class Shape {
        abstract double area();
    }

    static class Circle extends Shape {
        double radius;
        Circle(double radius) { this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
    }

    static class Square extends Shape {
        double side;
        Square(double side) { this.side = side; }
        double area() { return side * side; }
    }

    public static void main(String[] args) {
        Shape[] shapes = { new Circle(5), new Square(4) };
        for (Shape s : shapes) {
            System.out.printf("Area: %.2f%n", s.area());
        }
    }
}