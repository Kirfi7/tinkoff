package edu.hw4;

import java.util.List;

public class Task7 { // Объявление класса Task7

    private Task7() { // Приватный конструктор класса Task7

    }

    // Метод для поиска самого старого животного в списке
    public static Animal findOldestAnimal(List<Animal> animals) {
        if (animals.isEmpty()) { // Проверка, пуст ли список животных
            return null; // Возврат null, если список пуст
        }
        Animal oldestAnimal = animals.get(0); // Инициализация переменной для самого старого животного
        // Итерация по каждому животному в списке для поиска самого старого животного
        for (Animal animal : animals) {
            // Проверка возраста текущего животного и обновление oldestAnimal при необходимости
            if (animal.age() > oldestAnimal.age()) {
                oldestAnimal = animal; // Обновление oldestAnimal, если текущее животное старше
            }
        }
        return oldestAnimal; // Возврат самого старого животного
    }
}


