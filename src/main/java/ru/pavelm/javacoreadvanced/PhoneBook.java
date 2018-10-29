package ru.pavelm.javacoreadvanced;

import java.util.*;

public class PhoneBook {
    private Map<String, List<Integer>> phoneBook = new HashMap<>();

    public void addNumber (String name, int number) {
        if (this.phoneBook.containsKey(name)) {
            List<Integer> newList = new ArrayList<>(phoneBook.get(name));
            newList.add(number);
            this.phoneBook.put(name, newList);
        } else {
            this.phoneBook.put(name, Arrays.asList(number));
        }
    }

    public Map getPhoneBook() {
        return this.phoneBook;
    }

    public String getNumber(String name) {
        return this.phoneBook.get(name).toString();
    }
}
