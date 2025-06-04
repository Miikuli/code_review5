package ru.mikova.TelephoneDirectory;

import java.util.HashMap;

/**
 * Желтые страницы.
 * Необходимо разработать сущность ТелефонныйСправочник, который будет использоваться для
 * создания справочника со списком телефонов и имен, с целью поиска телефона по имени. Будем
 * считать достаточным хранение пар телефон-строка, например “89003337788 - Вася”.
 * Состояние сущности описывается набором пар “телефон – имя”, причем и телефон и имя являются
 * строками. В целях упрощения задачи будем считать, что одному имени всегда соответствует один
 * телефон, и один телефон соответствует одному имени.
 * Инициализация сущности выполняется без аргументов.
 * Поведение сущности описывают следующие действия:
 * Добавление новой пары “телефон – имя” (как два отдельных аргумента). Конкретное
 * местоположение добавленной пары не важно. Если добавляемое имя уже есть в списке, то
 * имеющийся телефон заменяется на новый, и затем старый телефон возвращается из
 * метода.
 * Удаление значения. Для удаления необходимо указать имя удаляемого контакта, после
 * чего удаляется вся пара.
 * Получение значений. Для получения необходимо указать имя контакта, тогда
 * возвращается его телефон.
 * Может быть приведен к строке. Строка должна представлять собой полный перечень всех
 * хранимых пар.
 * Можно проверить есть ли конкретный телефон или конкретное имя в списке.
 * Можно узнать текущее количество контактов.
 * Можно запросить в виде массива:
 * Все пары
 * Все телефоны
 * Все имена
 * Можно получить массив всех имен, указав часть названия (начиная с первого символа).
 * Продемонстрируйте работоспособность решения на примерах
 */
public class TelephoneDirectory implements ITelephoneDirectory {
    private final HashMap<String, String> nameToNumber;
    private final HashMap<String, String> numberToName;

    /**
     * Создает новый пустой телефонный справочник.
     */
    public TelephoneDirectory() {
        this.nameToNumber = new HashMap<>();
        this.numberToName = new HashMap<>();
    }

    /**
     * Добавляет новую пару "телефон-имя" в справочник.
     * Если имя уже существует, заменяет телефон и возвращает старый.
     * Если телефон уже существует, возвращает сообщение об ошибке.
     *
     * @param number телефон для добавления (не должен быть null)
     * @param name имя для добавления (не должен быть null)
     * @return предыдущий номер телефона для этого имени или пустую строку,
     *         либо сообщение об ошибке если номер уже существует
     */
    @Override
    public String add(String number, String name) {
        if (numberToName.containsKey(number)) {
            return "Такой номер уже существует";
        }

        String oldNumber = nameToNumber.getOrDefault(name, "");

        // Удаляем старую пару если имя уже существует
        if (nameToNumber.containsKey(name)) {
            numberToName.remove(nameToNumber.get(name));
        }

        nameToNumber.put(name, number);
        numberToName.put(number, name);

        return oldNumber;
    }

    /**
     * Удаляет пару по имени из справочника.
     *
     * @param name имя для удаления (не должен быть null)
     */
    @Override
    public void delete(String name) {
        if (nameToNumber.containsKey(name)) {
            String number = nameToNumber.get(name);
            nameToNumber.remove(name);
            numberToName.remove(number);
        }
    }

    /**
     * Получает номер телефона по имени.
     *
     * @param name имя для поиска (не должен быть null)
     * @return номер телефона или null если не найден
     */
    @Override
    public String getNumber(String name) {
        return nameToNumber.get(name);
    }

    /**
     * Проверяет наличие имени в справочнике.
     *
     * @param name имя для проверки (не должен быть null)
     * @return true если имя существует, false в противном случае
     */
    @Override
    public boolean containsName(String name) {
        return nameToNumber.containsKey(name);
    }

    /**
     * Проверяет наличие номера телефона в справочнике.
     *
     * @param number номер для проверки (не должен быть null)
     * @return true если номер существует, false в противном случае
     */
    @Override
    public boolean containsNumber(String number) {
        return numberToName.containsKey(number);
    }

    /**
     * Возвращает количество контактов в справочнике.
     *
     * @return количество контактов
     */
    @Override
    public int size() {
        return nameToNumber.size();
    }

    /**
     * Получает все пары "телефон-имя" в виде массива строк.
     *
     * @return массив строк в формате "телефон-имя"
     */
    @Override
    public String[] getAllPairs() {
        return nameToNumber.entrySet().stream()
                .map(entry -> entry.getValue() + "-" + entry.getKey())
                .toArray(String[]::new);
    }

    /**
     * Получает все имена из справочника.
     *
     * @return массив всех имен
     */
    @Override
    public String[] getAllNames() {
        return nameToNumber.keySet().toArray(new String[0]);
    }

    /**
     * Получает все номера телефонов из справочника.
     *
     * @return массив всех номеров
     */
    @Override
    public String[] getAllNumbers() {
        return numberToName.keySet().toArray(new String[0]);
    }

    /**
     * Находит все имена, начинающиеся с указанной строки.
     *
     * @param prefix начальная часть имени для поиска (не должен быть null)
     * @return массив подходящих имен
     */
    @Override
    public String[] findNamesStartingWith(String prefix) {
        return nameToNumber.keySet().stream()
                .filter(name -> name.startsWith(prefix))
                .toArray(String[]::new);
    }

    /**
     * Возвращает строковое представление справочника.
     * Формат: "телефон1-имя1 телефон2-имя2 ..."
     *
     * @return строковое представление справочника
     */
    @Override
    public String toString() {
        return String.join(" ", getAllPairs());
    }
}