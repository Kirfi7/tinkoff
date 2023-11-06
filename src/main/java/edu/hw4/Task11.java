package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task11 { // Объявление класса Task11

    private static final int NUM = 100; // Константа для сравнения с высотой животных

    private Task11() { // Приватный конструктор класса Task11

    }

    // Метод для поиска животных, способных кусать, с высотой больше 100
    public static List<Animal> findAnimalsCanBiteWithHeightGreaterThan100(List<Animal> animals) {
        List<Animal> resultAnimals = new ArrayList<>(); // Создание списка для хранения животных, соответствующих
        // условию
        // Итерация по каждому животному в списке для проверки способности кусать и высоты
        for (Animal animal : animals) {
            if (animal.bites() && animal.height() > NUM) { // Проверка, может ли животное кусать и превышает ли его
                // высота заданную константу
                resultAnimals.add(animal); // Добавление животного в список, если условие выполняется
            }
        }
        return resultAnimals; // Возврат списка животных, способных кусать, с высотой больше 100
    }
}

