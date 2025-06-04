package ru.mikova.point;

/**
 * Интерфейс для работы с точками в двумерном пространстве.
 * Определяет базовые операции для работы с координатами точек.
 */
public interface IPoint extends Cloneable {
    /**
     * Возвращает координату X точки.
     * @return значение координаты X типа double
     */
    double getX();

    /**
     * Возвращает координату Y точки.
     * @return значение координаты Y типа double
     */
    double getY();

    /**
     * Устанавливает новые значения координат точки.
     * @param x новая координата X
     * @param y новая координата Y
     * @throws IllegalArgumentException если координаты равны NaN
     */
    void setValue(double x, double y);

    /**
     * Создает и возвращает копию текущей точки.
     * @return клон текущей точки
     * @throws CloneNotSupportedException если клонирование не поддерживается
     */
    IPoint clone() throws CloneNotSupportedException;

    /**
     * Сравнивает текущую точку с указанным объектом.
     * @param obj объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    boolean equals(Object obj);

    /**
     * Возвращает строковое представление точки.
     * @return строковое представление точки
     */
    String toString();
}