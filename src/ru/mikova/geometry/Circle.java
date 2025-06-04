package ru.mikova.geometry;

public class Circle extends Figure{
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        super(center, "Круг");
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным");
        }
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг с центром " + center + " и радиусом " + radius;
    }
}