package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task10 { // Объявление класса Task10

    private Task10() { // Приватный конструктор класса Task10

    }

    // Метод для поиска животных, у которых возраст не соответствует количеству лап
    public static List<Animal> findAnimalsWithAgeNotMatchingPaws(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>(); // Создание списка для хранения животных, не соответствующих
        // условию
        // Итерация по каждому животному в списке для проверки соответствия возраста количеству лап
        for (Animal animal : animals) {
            if (animal.age() != animal.paws()) { // Проверка, соответствует ли возраст количеству лап у животного
                resultAnimals.add(animal); // Добавление животного в список, если условие не выполняется
            }
        }
        return resultAnimals; // Возврат списка животных, у которых возраст не соответствует количеству лап
    }
}

