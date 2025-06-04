package ru.mikova.main;

import java.util.List;

public class Areas {

    public static double totalArea(List<Shape> shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.area();
        }
        return total;
    }
}