package ru.mikova.figure;
import java.util.List;

/**
 * Задание 5.3. Общая площадь.
 * Разработайте метод, который принимает набор фигур из задачи 2.4.4 и считает их общую
 * площадь (без учета возможного перекрытия фигурами друг друга). Продемонстрируйте
 * работоспособность метода, передав туда несколько кругов и квадратов.
 */
public class Areas {

    /**
     * Вычисляет суммарную площадь всех фигур в переданном списке.
     *
     * @param shapes список геометрических фигур, реализующих интерфейс Shape
     * @return суммарная площадь всех фигур в списке
     */
    public static double totalArea(List<IShape> shapes) {
        if (shapes == null) {
            System.err.println("Список фигур не может быть null");
            return 0;
        }

        double total = 0;
        for (IShape shape : shapes) {
            total += shape.area();
        }
        return total;
    }
}