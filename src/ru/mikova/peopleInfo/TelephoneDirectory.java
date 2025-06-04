package ru.mikova.peopleInfo;

import java.util.HashMap;

public class TelephoneDirectory {
    private final HashMap<String, String> directory;

    public TelephoneDirectory() {
        this.directory = new HashMap<>();
    }

    public String addPair(String number, String name) {
        if (this.directory.containsValue(number)) return "Такой номер уже существует";
        String oldNumber = "";
        if (this.directory.containsKey(name)) oldNumber = directory.get(name);
        this.directory.put(name, number);
        return oldNumber;
    }

    public void deletePair(String name) {
        this.directory.remove(name);
    }

    public String getNumber(String name) {
        return this.directory.get(name);
    }

    @Override
    public String toString() {
        String hash_out = "";
        for (String name : this.directory.keySet()) {
            hash_out += this.directory.get(name) + "-" + name + " ";
        }
        return hash_out;
    }

    public boolean checkName(String name) {
        if (this.directory.containsKey(name)) return true;
        return false;
    }

    public boolean checkNumber(String number) {
        if (this.directory.containsValue(number)) return true;
        return false;
    }

    public int countContacts() {
        return this.directory.size();
    }

    public String[] getContacts() {
        String[] hash_out = new String[this.directory.size()];
        int index = 0;
        for (String name : this.directory.keySet()) {
            hash_out[index] = this.directory.get(name) + "-" + name;
            index++;
        }
        return hash_out;
    }

    public String[] getNames() {
        String[] hash_out = new String[this.directory.size()];
        int index = 0;
        for (String name : this.directory.keySet()) {
            hash_out[index] = name;
            index++;
        }
        return hash_out;
    }

    public String[] getNumbers() {
        String[] hash_out = new String[this.directory.size()];
        int index = 0;
        for (String name : this.directory.values()) {
            hash_out[index] = name;
            index++;
        }
        return hash_out;
    }

    public String[] getNamesStartingWith(String nameStart) {
        return this.directory.keySet().stream().filter(name -> name.startsWith(nameStart)).toArray(String[]::new);
    }

}
