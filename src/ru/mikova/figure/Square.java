package ru.mikova.figure;

import ru.mikova.point.Point;
import ru.mikova.polyline.ClosedPolyline;

/**
 * Задание 5.6. Замкнутый квадрат.
 * Измените сущность Квадрат из задачи 2.4.4, таким образом, что бы она возвращала не обычную
 * ломаную линию, а замкнутую ломаную линию из задачи 2.3.2. При этом сигнатура метода,
 * возвращающую Ломаную, должна остаться без изменений.
 */
public class Square extends Figure {
    private Point topLeft;
    private double sideLength;

    /**
     * Создает новый квадрат.
     * @param topLeft левая верхняя точка квадрата
     * @param sideLength длина стороны квадрата
     */
    public Square(Point topLeft, double sideLength) {
        super(topLeft, "Квадрат");
        if (sideLength <= 0) {
            System.err.println("Длина стороны должна быть положительной");
            this.sideLength = 1.0; // Устанавливаем значение по умолчанию
        } else {
            this.sideLength = sideLength;
        }
        this.topLeft = topLeft;
    }

    /**
     * Генерирует замкнутую ломаную линию, представляющую квадрат.
     * @return замкнутая ломаная линия из 5 точек (с совпадающими начальной и конечной точками)
     */
    public ClosedPolyline getClosedPolyline() {
        Point[] corners = new Point[5];
        corners[0] = topLeft;
        corners[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        corners[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength);
        corners[3] = new Point(topLeft.getX(), topLeft.getY() - sideLength);
        corners[4] = topLeft; // Замыкаем квадрат
        return new ClosedPolyline(corners);
    }

    /**
     * Вычисляет площадь квадрата.
     * @return площадь квадрата
     */
    @Override
    public double area() {
        return sideLength * sideLength;
    }

    /**
     * Возвращает строковое представление квадрата.
     * @return строка с описанием квадрата
     */
    @Override
    public String toString() {
        return "Квадрат с верхним левым углом " + topLeft +
                " и длиной стороны " + sideLength;
    }
}