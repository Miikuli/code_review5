package ru.mikova.polyline;

import ru.mikova.point.Point;
import java.util.Arrays;

/**
 * Класс, представляющий ломаную линию из последовательности точек.
 * Является базовым классом для замкнутых ломаных линий.
 */
public class Polyline {
    protected Point[] points;

    /**
     * Создает новую ломаную линию из массива точек.
     *
     * @param points массив точек, образующих ломаную
     * @throws IllegalArgumentException если массив точек null или содержит менее 2 точек
     */
    public Polyline(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Массив точек не может быть null");
        }
        if (points.length < 2) {
            throw new IllegalArgumentException("Ломаная должна содержать минимум 2 точки");
        }
        this.points = Arrays.copyOf(points, points.length);
    }

    /**
     * Возвращает массив точек ломаной.
     *
     * @return копия массива точек
     */
    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }

    /**
     * Вычисляет общую длину ломаной линии.
     *
     * @return сумма длин всех отрезков ломаной
     */
    public double length() {
        double length = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Line segment = new Line(points[i], points[i + 1]);
            length += segment.length();
        }
        return length;
    }

    /**
     * Возвращает строковое представление ломаной.
     *
     * @return строка с перечислением всех точек
     */
    @Override
    public String toString() {
        return "Ломаная линия через точки: " + Arrays.toString(points);
    }
}