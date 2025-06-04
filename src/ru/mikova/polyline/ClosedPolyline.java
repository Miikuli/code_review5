package ru.mikova.polyline;

import ru.mikova.point.Point;
import java.util.Arrays;

/**
 * Класс, представляющий замкнутую ломаную линию.
 * Наследуется от класса Polyline и добавляет функциональность замкнутой фигуры.
 */
public class ClosedPolyline extends Polyline {

    /**
     * Создает новую замкнутую ломаную линию.
     * @param points массив точек, где первая и последняя точки должны совпадать
     * @throws IllegalArgumentException если первая и последняя точки не совпадают
     */
    public ClosedPolyline(Point[] points) {
        super(points);
        if (!points[0].equals(points[points.length - 1])) {
            throw new IllegalArgumentException("Первая и последняя точки должны совпадать для замкнутой ломаной.");
        }
    }

    /**
     * Вычисляет общую длину замкнутой ломаной линии.
     * @return суммарная длина всех отрезков ломаной
     */
    public double length() {
        double totalLength = 0;
        Point[] points = super.getPoints();
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            totalLength += Math.sqrt(dx * dx + dy * dy);
        }
        return totalLength;
    }

    /**
     * Возвращает строковое представление замкнутой ломаной.
     * @return строковое описание ломаной
     */
    @Override
    public String toString() {
        return "Замкнутая ломаная линия с точками: " + Arrays.toString(super.getPoints());
    }
}