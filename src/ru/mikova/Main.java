package ru.mikova;

import ru.mikova.TelephoneDirectory.TelephoneDirectory;
import ru.mikova.figure.Areas;
import ru.mikova.figure.IShape;
import ru.mikova.inputhandler.InputHandler;
import ru.mikova.inputhandler.config.DoubleCheckConfig;
import ru.mikova.figure.*;
import ru.mikova.point.Point;
import ru.mikova.point.Point2;
import ru.mikova.student.Student;
import ru.mikova.power.PowerCalculator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Диапазон оценок
        Student student_1 = new Student("Вася", 2, 3, 4);
        Student student_2 = new Student("Петя");
        Student student_3 = new Student("Максим");
        System.out.println("Студенты: ");
        System.out.println(student_1);
        System.out.println(student_2);
        System.out.println(student_3);
        System.out.println();

        // Желтые страницы
        TelephoneDirectory contacts = new TelephoneDirectory();
        System.out.println("Телефонный справочник: ");
        System.out.printf("Добавляем 88005553535-Джон: ");
        System.out.println(contacts.add("88005553535", "Джон"));
        System.out.printf("Добавляем 89222322232-Настя: ");
        System.out.println(contacts.add("89222322232", "Настя"));
        System.out.printf("Добавляем 88005553535-Вася: ");
        System.out.println(contacts.add("85555555555", "Вася"));
        System.out.printf("Добавляем 89676655655-Настя: ");
        System.out.println(contacts.add("89676655655", "Настя"));
        System.out.printf("Добавляем 85555555555-Петя: ");
        System.out.println(contacts.add("85555555555", "Петя"));
        System.out.println("Контакты: " + contacts);
        System.out.println();
        System.out.println("Удалим Васю из контактов");
        contacts.delete("Вася");
        System.out.println("Контакты: " + contacts);
        System.out.println();
        System.out.println("Получим номер Джона: ");
        System.out.println(contacts.getNumber("Джон"));
        System.out.println();
        System.out.printf("Есть ли Петя в справонике?: ");
        System.out.println(contacts.containsName("Петя") ? "Да" : "Нет");
        System.out.printf("Есть ли Джон в справонике?: ");
        System.out.println(contacts.containsName("Джон") ? "Да" : "Нет");
        System.out.printf("Есть ли 85555555555 в справонике?: ");
        System.out.println(contacts.containsNumber("85555555555") ? "Да" : "Нет");
        System.out.printf("Есть ли 88005553535 в справонике?: ");
        System.out.println(contacts.containsNumber("88005553535") ? "Да" : "Нет");
        System.out.println();
        System.out.println("Кол-во контактов в справочнике " + contacts.size());
        System.out.println("Контакты: ");
        for (String name : contacts.getAllPairs()) {
            System.out.println(name);
        }
        System.out.println();
        System.out.println("Имена: ");
        for (String name : contacts.getAllNames()) {
            System.out.println(name);
        }
        System.out.println();
        System.out.println("Номера: ");
        for (String name : contacts.getAllNumbers()) {
            System.out.println(name);
        }
        System.out.println();
        System.out.println("Добавим Джорджа и выведем имена, начинающиеся с Дж");
        contacts.add("8998457865", "Джордж");
        for (String name : contacts.findNamesStartingWith("Дж")) {
            System.out.println(name);
        }

        // Трехмерная точка
        System.out.println("\nПоочередно введите 3 точки координат");
        double x_1 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки x_1: ")
                .build());
        double y_1 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки y_1: ")
                .build());
        double z_1 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки z_1: ")
                .build());
        double x_2 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки x_2: ")
                .build());
        double y_2 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки y_2: ")
                .build());
        double z_2 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки z_2: ")
                .build());
        double x_3 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки x_3: ")
                .build());
        double y_3 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки y_3: ")
                .build());
        double z_3 = InputHandler.getDouble(new DoubleCheckConfig.Builder()
                .setPrompt("Введите координату точки z_3: ")
                .build());

        Point2 pont_1 = new Point2(x_1, y_1, z_1);
        Point2 pont_2 = new Point2(x_2, y_2, z_2);
        Point2 pont_3 = new Point2(x_3, y_3, z_3);
        System.out.println(pont_1);
        System.out.println(pont_2);
        System.out.println(pont_3);

        // Фигуры
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);

        Point squareTopLeft = new Point(1, 1);
        Square square = new Square(squareTopLeft, 4);

        Point rectangleTopLeft = new Point(2, 2);
        Rectangle rectangle = new Rectangle(rectangleTopLeft, 3, 6);

        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));

        System.out.println(circle);
        System.out.println("Площадь круга: " + circle.area());

        System.out.println(square);
        System.out.println("Площадь квадрата: " + square.area());

        System.out.println(rectangle);
        System.out.println("Площадь прямоугольника: " + rectangle.area());

        System.out.println(triangle);
        System.out.println("Площадь треугольника: " + triangle.area());
        System.out.println();

        // Общая площадь
        ArrayList<IShape> shapes = new ArrayList<>();

        Circle circle1 = new Circle(new Point(0, 0), 5);
        Circle circle2 = new Circle(new Point(3, 3), 2);
        Square square1 = new Square(new Point(1, 1), 4);

        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(square1);

        for (IShape shape : shapes) {
            System.out.println(shape);
            System.out.println("Площадь: " + shape.area());
        }

        System.out.println("Общая площадь фигур: " + Areas.totalArea(shapes));
        System.out.println();

        // Замкнутый квадрат
        Square square2 = new Square(new Point(0, 0), 4);
        System.out.println("Замкнутый квадрат: " + square2.getClosedPolyline());
        System.out.println();

        // Сравнение точек
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(1.0, 2.0);
        Point p3 = new Point(2.0, 3.0);
        System.out.println("Точки: ");
        System.out.println("Точка p1: " + p1);
        System.out.println("Точка p2: " + p2);
        System.out.println("Точка p3: " + p3);

        System.out.println("Точки p1 и p2 равны: " + (p1.equals(p2) ? "Да" : "Нет"));
        System.out.println("Точки p1 и p3 равны: " + (p1.equals(p3) ? "Да" : "Нет"));
        System.out.println();

        // Возведение в степень
        if (args.length < 2) {
            System.out.println("Необходимо передать два аргумента: X и Y.");
            return;
        }

        String x = args[0];
        String y = args[1];

        PowerCalculator powerCalculator = new PowerCalculator();
        try {
            double result = powerCalculator.calculatePower(x, y);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: как минимум одно из значений не является числом.");
        }
    }

}