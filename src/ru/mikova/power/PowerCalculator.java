package ru.mikova.power;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Реализация возведения в степень с обработкой ошибок
 */
public class PowerCalculator implements IPowerCalculator {
    /**
     * Вычисляет степень числа с автоматической обработкой ошибок
     * @param base строка с целым числом (основание)
     * @param exponent строка с целым числом (показатель)
     * @return результат base^exponent или 0.0 при ошибке ввода
     */
    @Override
    public double calculatePower(String base, String exponent) {
        try {
            return pow(parseInt(base), parseInt(exponent));
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: оба параметра должны быть целыми числами");
            return 0.0;
        }
    }
}