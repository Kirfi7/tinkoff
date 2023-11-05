package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 { // Объявление класса Task15

    private Task15() { // Приватный конструктор класса Task15

    }

    // Метод для вычисления общего веса животных каждого типа в указанном диапазоне возрастов
    public static Map<Animal.Type, Integer> calculateTotalWeightByTypeInRange(List<Animal> animals, int k, int l) {
        Map<Animal.Type, Integer> totalWeightByType = new HashMap<>(); // Создание отображения для хранения общего веса
        // животных каждого типа
        // Итерация по каждому животному в списке для вычисления общего
        // веса каждого типа в указанном диапазоне возрастов
        for (Animal animal : animals) {
            if (animal.age() >= k && animal.age() <= l) { // Проверка, находится ли возраст животного
                // в указанном диапазоне
                totalWeightByType.put(animal.type(), totalWeightByType.getOrDefault(animal.type(), 0)
                    + animal.weight()); // Добавление веса текущего животного к общему весу для данного типа.
            }
        }
        return totalWeightByType; // Возврат отображения с общим весом животных каждого
        // типа в указанном диапазоне возрастов
    }
}

