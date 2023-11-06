package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task5 {

    // Приватный конструктор класса
    private Task5() {
        // Конструктор оставлен приватным, возможно, для того, чтобы предотвратить создание экземпляров этого класса.
    }

    // Метод для парсинга контактов
    public static List<Contact> parseContacts(String[] names, String order) {
        // Проверка на случай пустого массива имен
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }

        // Создание списка контактов для заполнения
        List<Contact> contacts = new ArrayList<>();
        for (String name : names) {
            contacts.add(new Contact(name)); // Добавление нового контакта в список
        }

        // Сортировка списка в зависимости от порядка сортировки
        if (order.equals("ASC")) {
            Collections.sort(contacts, Comparator.comparing((Contact c) -> c.lastName).thenComparing(c -> c.firstName));
        } else if (order.equals("DESC")) {
            Collections.sort(contacts, Comparator.comparing((Contact c) -> c.lastName).reversed().thenComparing(c ->
                c.firstName));
        }

        // Возврат отсортированного списка контактов
        return contacts;
    }

    // Внутренний класс, представляющий контакт
    static class Contact {
        String firstName; // Имя контакта
        String lastName; // Фамилия контакта

        // Конструктор контакта
        Contact(String fullName) {
            String[] names = fullName.split(" "); // Разделение полного имени на имя и фамилию
            if (names.length > 1) {
                this.firstName = names[0]; // Если есть фамилия, присвоить имя и фамилию
                this.lastName = names[1];
            } else {
                this.firstName = fullName; // Если фамилия отсутствует, использовать имя, фамилия - пустая строка
                this.lastName = "";
            }
        }

        // Метод для получения полного имени контакта
        public String getFullName() {
            return this.firstName + " " + this.lastName;
        }
    }
}
