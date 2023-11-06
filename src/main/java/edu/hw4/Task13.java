package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task13 { // Объявление класса Task13

    private Task13() { // Приватный конструктор класса Task13

    }

    // Метод для поиска животных с именами, длина которых превышает два слова
    public static List<Animal> findAnimalsWithNamesLongerThanTwoWords(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>(); // Создание списка для хранения животных с именами длиннее двух
        // слов
        // Итерация по каждому животному в списке для проверки длины имени
        for (Animal animal : animals) {
            String[] words = animal.name().split(" "); // Разделение имени на отдельные слова
            if (words.length > 2) { // Проверка, содержит ли имя более двух слов
                resultAnimals.add(animal); // Добавление животного в список, если условие выполняется
            }
        }
        return resultAnimals; // Возврат списка животных с именами длиннее двух слов
    }
}

