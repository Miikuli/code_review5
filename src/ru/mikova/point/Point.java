package ru.mikova.point;

/**
 * Задание 6.2. Сравнение точек.
 * Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по
 * состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они
 * расположены в одинаковых координатах.
 * Задание 8.4. Клонирование точки.
 * Измените сущность Точка из 3.6.2. Переопределите метод клонирования, унаследованный от
 * класса Object, таким образом, чтобы при его вызове возвращался новый объект Точки, значения
 * полей которого будут копиями оригинальной Точки.
 */
public class Point implements IPoint, Cloneable {
    private double x;
    private double y;

    /**
     * Создает новую точку с указанными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            System.err.println("Координаты не могут быть NaN");
            return;
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     *
     * @return значение координаты X
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату Y точки.
     *
     * @return значение координаты Y
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Устанавливает новые значения координат точки.
     *
     * @param x новая координата X
     * @param y новая координата Y
     */
    @Override
    public void setValue(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            System.err.println("Координаты не могут быть NaN");
            return;
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Создает и возвращает копию текущей точки.
     *
     * @return клон текущей точки
     */
    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }

    /**
     * Возвращает строковое представление точки в формате "{X;Y}".
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает текущую точку с указанным объектом.
     *
     * @param obj объект для сравнения
     * @return true если объекты равны (имеют одинаковые координаты), false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return Double.compare(x, other.x) == 0 &&
                Double.compare(y, other.y) == 0;
    }
}