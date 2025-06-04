package ru.mikova.point;


/**
 * Задание 3.5 Трехмерная точка.
 * Создайте такой подвид сущности Точка из задачи 1.1.1, которая будет иметь не две, а три
 * координаты на плоскости: X,Y,Z.
 * Задание 8.4. Клонирование точки.
 * Измените сущность Точка из 3.6.2. Переопределите метод клонирования, унаследованный от
 * класса Object, таким образом, чтобы при его вызове возвращался новый объект Точки, значения
 * полей которого будут копиями оригинальной Точки.
 */
public class Point2 extends Point {
    private double z;

    /**
     * Создает новую трехмерную точку с указанными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     * @param z координата по оси Z
     * @throws IllegalArgumentException если любая из координат равна NaN
     */
    public Point2(double x, double y, double z) {
        super(x, y);
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("Координата Z не может быть NaN");
        }
        this.z = z;
    }

    /**
     * Возвращает координату Z точки.
     *
     * @return значение координаты Z
     */
    public double getZ() {
        return z;
    }

    /**
     * Устанавливает новые значения координат точки (включая Z).
     *
     * @param x новая координата X
     * @param y новая координата Y
     * @param z новая координата Z
     * @throws IllegalArgumentException если любая из координат равна NaN
     */
    public void setValue(double x, double y, double z) {
        super.setValue(x, y);
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("Координата Z не может быть NaN");
        }
        this.z = z;
    }

    /**
     * Создает и возвращает копию текущей точки.
     *
     * @return клон текущей точки
     * @throws CloneNotSupportedException если клонирование не поддерживается
     */
    @Override
    public Point2 clone() throws CloneNotSupportedException {
        return (Point2) super.clone();
    }

    /**
     * Возвращает строковое представление точки в формате "{X;Y;Z}".
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "{" + super.getX() + ";" + super.getY() + ";" + z + "}";
    }

    /**
     * Сравнивает текущую точку с указанным объектом.
     *
     * @param obj объект для сравнения
     * @return true если объекты равны (имеют одинаковые координаты), false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Point2 other = (Point2) obj;
        return Double.compare(z, other.z) == 0;
    }
}