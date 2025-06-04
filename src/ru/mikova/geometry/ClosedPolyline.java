package ru.mikova.geometry;

class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point[] points) {
        super(points);
        if (!points[0].equals(points[points.length - 1])) {
            throw new IllegalArgumentException("Первая и последняя точки должны совпадать для замкнутой ломаной.");
        }
    }

    public double length() {
        double totalLength = 0;
        Point[] points = super.getPoints();
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            Point p2 = points[(i + 1) % points.length];
            double distance = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
            totalLength += distance;
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "Замкнутая " + super.toString();
    }
}