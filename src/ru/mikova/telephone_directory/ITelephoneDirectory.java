package ru.mikova.telephone_directory;

/**
 * Интерфейс для телефонного справочника.
 * Определяет основные операции для работы со справочником.
 */
public interface ITelephoneDirectory {
    /**
     * Добавляет новую пару "телефон-имя" в справочник.
     * Если имя уже существует, заменяет телефон и возвращает старый.
     *
     * @param number телефон для добавления
     * @param name имя для добавления
     * @return предыдущий номер телефона для этого имени или пустую строку
     */
    String add(String number, String name);

    /**
     * Удаляет пару по имени.
     *
     * @param name имя для удаления
     */
    void delete(String name);

    /**
     * Получает номер телефона по имени.
     *
     * @param name имя для поиска
     * @return номер телефона или null если не найден
     */
    String getNumber(String name);

    /**
     * Проверяет наличие имени в справочнике.
     *
     * @param name имя для проверки
     * @return true если имя существует, false в противном случае
     */
    boolean containsName(String name);

    /**
     * Проверяет наличие номера телефона в справочнике.
     *
     * @param number номер для проверки
     * @return true если номер существует, false в противном случае
     */
    boolean containsNumber(String number);

    /**
     * Возвращает количество контактов в справочнике.
     *
     * @return количество контактов
     */
    int size();

    /**
     * Получает все пары "телефон-имя" в виде массива строк.
     *
     * @return массив строк в формате "телефон-имя"
     */
    String[] getAllPairs();

    /**
     * Получает все имена из справочника.
     *
     * @return массив всех имен
     */
    String[] getAllNames();

    /**
     * Получает все номера телефонов из справочника.
     *
     * @return массив всех номеров
     */
    String[] getAllNumbers();

    /**
     * Находит все имена, начинающиеся с указанной строки.
     *
     * @param prefix начальная часть имени для поиска
     * @return массив подходящих имен
     */
    String[] findNamesStartingWith(String prefix);
}
