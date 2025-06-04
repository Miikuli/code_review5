package ru.mikova.geometry;

public class Triangle extends Figure{
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        super(a, "Треугольник");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double ab = distance(a, b);
        double bc = distance(b, c);
        double ca = distance(c, a);
        double s = (ab + bc + ca) / 2;
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public String toString() {
        return "Треугольник с вершинами " + a + ", " + b + ", " + c;
    }
}