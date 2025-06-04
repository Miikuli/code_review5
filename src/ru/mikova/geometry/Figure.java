package ru.mikova.geometry;

import ru.mikova.main.Shape;

abstract class Figure implements Shape {
    private Point location;
    private String name;

    public Figure(Point location, String name) {
        this.name = name;
        this.location = location;
    }

    public abstract double area();

    @Override
    public String toString() {
        return "Фигура: " + name + ", Позиция: " + location;
    }
}
