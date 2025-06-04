package ru.mikova.power;

/**
 * Интерфейс для вычисления степени числа.
 * Определяет контракт для классов, реализующих возведение в степень.
 */
public interface IPowerCalculator {
    /**
     * Вычисляет результат возведения числа в степень.
     * @param base основание степени в виде строки
     * @param exponent показатель степени в виде строки
     * @return результат возведения в степень
     * @throws NumberFormatException если строки не содержат целые числа
     */
    double calculatePower(String base, String exponent) throws NumberFormatException;
}