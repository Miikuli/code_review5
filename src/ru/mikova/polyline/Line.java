package ru.mikova.polyline;

import ru.mikova.point.Point;

/**
 * Класс, представляющий отрезок прямой между двумя точками.
 * Содержит методы для работы с отрезками на плоскости.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Создает новый отрезок между двумя точками.
     *
     * @param start начальная точка отрезка
     * @param end конечная точка отрезка
     */
    public Line(Point start, Point end) {
        if (start == null || end == null) {
            System.err.println("Точки не могут быть null");
            return;
        }
        this.start = start;
        this.end = end;
    }

    /**
     * Возвращает начальную точку отрезка.
     *
     * @return начальная точка
     */
    public Point getStart() {
        return start;
    }

    /**
     * Возвращает конечную точку отрезка.
     *
     * @return конечная точка
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Вычисляет длину отрезка.
     *
     * @return длина отрезка
     */
    public double length() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Возвращает строковое представление отрезка.
     *
     * @return строка в формате "Линия от {x1;y1} до {x2;y2}"
     */
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}