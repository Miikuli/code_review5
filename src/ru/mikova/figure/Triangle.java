package ru.mikova.figure;

import ru.mikova.point.Point;

/**
 * Класс, представляющий треугольник.
 * Наследуется от абстрактного класса Figure.
 */
public class Triangle extends Figure {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;

    /**
     * Создает новый треугольник.
     * @param vertexA первая вершина треугольника
     * @param vertexB вторая вершина треугольника
     * @param vertexC третья вершина треугольника
     */
    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        super(vertexA, "Треугольник");
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    /**
     * Вычисляет площадь треугольника по формуле Герона.
     * @return площадь треугольника
     */
    @Override
    public double area() {
        double sideAB = distance(vertexA, vertexB);
        double sideBC = distance(vertexB, vertexC);
        double sideCA = distance(vertexC, vertexA);
        double semiPerimeter = (sideAB + sideBC + sideCA) / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - sideAB) *
                (semiPerimeter - sideBC) *
                (semiPerimeter - sideCA));
    }

    /**
     * Вычисляет расстояние между двумя точками.
     * @param p1 первая точка
     * @param p2 вторая точка
     * @return расстояние между точками
     */
    private double distance(Point p1, Point p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Возвращает строковое представление треугольника.
     * @return строка с описанием треугольника
     */
    @Override
    public String toString() {
        return "Треугольник с вершинами " + vertexA + ", " + vertexB + ", " + vertexC;
    }
}