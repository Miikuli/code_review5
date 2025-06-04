package ru.mikova.figure;

import ru.mikova.point.Point;

/**
 * Класс, представляющий круг.
 * Наследуется от абстрактного класса Figure.
 */
public class Circle extends Figure {
    private Point center;
    private double radius;

    /**
     * Создает новый круг.
     * @param center центр круга
     * @param radius радиус круга
     * @throws IllegalArgumentException если радиус не положительный
     */
    public Circle(Point center, double radius) {
        super(center, "Круг");
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным");
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * Вычисляет площадь круга.
     * @return площадь круга
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Возвращает строковое представление круга.
     * @return строка с описанием круга
     */
    @Override
    public String toString() {
        return "Круг с центром " + center + " и радиусом " + radius;
    }
}