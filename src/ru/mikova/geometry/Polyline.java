package ru.mikova.geometry;

import java.util.Arrays;

class Polyline {
    private Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}