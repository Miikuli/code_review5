package ru.mikova.geometry;

public class Square extends Figure {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        super(topLeft, "Квадрат");
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public Square(int x, int y, double sideLength) {
        this(new Point(x, y), sideLength);
    }

    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double area() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " и длиной стороны " + sideLength;
    }

    public ClosedPolyline getClosedPolyline() {
        Point[] corners = new Point[5];
        corners[0] = topLeft;
        corners[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        corners[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength);
        corners[3] = new Point(topLeft.getX(), topLeft.getY() - sideLength);
        corners[4] = topLeft;
        return new ClosedPolyline(corners);
    }
}