package ru.mikova.figure;

import ru.mikova.point.Point;

/**
 * Класс, представляющий прямоугольник.
 * Наследуется от абстрактного класса Figure.
 */
public class Rectangle extends Figure {
    private Point topLeftCorner;
    private double width;
    private double height;

    /**
     * Создает новый прямоугольник.
     * @param topLeftCorner левая верхняя точка прямоугольника
     * @param width ширина прямоугольника
     * @param height высота прямоугольника
     * @throws IllegalArgumentException если ширина или высота не положительные
     */
    public Rectangle(Point topLeftCorner, double width, double height) {
        super(topLeftCorner, "Прямоугольник");
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными");
        }
        this.topLeftCorner = topLeftCorner;
        this.width = width;
        this.height = height;
    }

    /**
     * Вычисляет площадь прямоугольника.
     * @return площадь прямоугольника
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Возвращает строковое представление прямоугольника.
     * @return строка с описанием прямоугольника
     */
    @Override
    public String toString() {
        return "Прямоугольник с верхним левым углом " + topLeftCorner +
                ", шириной " + width + " и высотой " + height;
    }
}