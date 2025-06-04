package ru.mikova.geometry;

public class Rectangle extends Figure {
    private Point topLeft;
    private double side1;
    private double side2;

    public Rectangle(Point topLeft, double side1, double side2) {
        super(topLeft, "Прямоугольник");
        if (side1 <= 0 || side2 <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными");
        }
        this.topLeft = topLeft;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double area() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        return "Прямоугольник с верхним левым углом " + topLeft + ", шириной " + side1 + " и высотой " + side2;
    }
}