package ru.mikova.student;

/**
 * Задание 1.9 Диапазон оценок.
 * Измените сущность Студент из задачи 1.5.6. Необходимо гарантировать, что добавлять Студенту
 * можно только оценки в диапазоне от 2 до 5, при этом у Студента всегда можно узнать список
 * оценок.
 * Продемонстрируйте на примерах, что нет способа задать Студенту некорректную оценку.
 */
public class Student {
    private final String name;
    private final int[] marks;

    /**
     * Создает объект Student с указанным именем и оценками.
     * Проверяет, что все оценки находятся в допустимом диапазоне (2-5).
     * Если массив оценок пуст, создается пустой массив оценок.
     *
     * @param name имя студента
     * @param marks массив оценок студента (должны быть в диапазоне 2-5)
     * @throws IllegalArgumentException если какая-либо оценка не в диапазоне 2-5
     */
    public Student(String name, int... marks) {
        checkMarks(marks);
        this.name = name;
        this.marks = marks.length > 0 ? marks : new int[0];
    }

    /**
     * Проверяет массив оценок на соответствие допустимому диапазону (2-5).
     *
     * @param marks массив оценок для проверки
     * @throws IllegalArgumentException если какая-либо оценка не в диапазоне 2-5
     */
    public void checkMarks(int[] marks) {
        for (int mark : marks) {
            if (mark < 2 || mark > 5)
                throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        }
    }

    /**
     * Возвращает копию массива оценок студента.
     *
     * @return массив оценок студента
     */
    public int[] getMarks() {
        return marks;
    }

    /**
     * Вычисляет средний балл студента.
     * Если у студента нет оценок, возвращает 0.
     *
     * @return средний балл студента (0 если нет оценок)
     */
    public double averageMark() {
        if (marks.length == 0) return 0;
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum/marks.length;
    }

    /**
     * Проверяет, является ли студент отличником.
     * Студент считается отличником, если у него есть оценки и все они равны 5.
     *
     * @return true если все оценки равны 5, false в противном случае или если нет оценок
     */
    public boolean isExellent() {
        if (marks.length == 0) return false;
        for (int mark : marks) {
            if (mark != 5) return false;
        }
        return true;
    }

    /**
     * Изменяет оценку по указанному номеру.
     * Нумерация оценок начинается с 1.
     *
     * @param n номер оценки для изменения (начиная с 1)
     * @param newMark новая оценка (должна быть в диапазоне 2-5)
     * @throws IllegalArgumentException если новая оценка не в диапазоне 2-5
     * @throws ArrayIndexOutOfBoundsException если указан неверный номер оценки
     */
    public void changeMark(int n, int newMark) {
        if (newMark < 2 || newMark > 5)
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        this.marks[n-1] = newMark;
    }

    /**
     * Изменяет все оценки студента.
     * Новый массив оценок должен быть той же длины, что и текущий.
     * Все новые оценки должны быть в допустимом диапазоне (2-5).
     *
     * @param newMarks новый массив оценок (должен быть той же длины и содержать оценки 2-5)
     * @throws IllegalArgumentException если какая-либо новая оценка не в диапазоне 2-5
     * @throws ArrayIndexOutOfBoundsException если новый массив другой длины
     */
    public void changeAllMarks(int[] newMarks) {
        checkMarks(newMarks);
        for (int i = 0; i < newMarks.length; i++) {
            this.marks[i] = newMarks[i];
        }
    }

    /**
     * Возвращает строковое представление студента в формате "Имя: оценка1 оценка2 ...".
     *
     * @return строковое представление студента
     */
    @Override
    public String toString() {
        String array_out = "";
        for (int mark : marks) {
            array_out = array_out + " " + mark;
        }
        return name + ":" + array_out;
    }
}