package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 { // Объявление класса Task3

    private Task3() { // Приватный конструктор класса Task3

    }

    // Метод для подсчета количества животных каждого типа в списке
    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> animalCountMap = new HashMap<>(); // Создание отображения для подсчета
        // Итерация по каждому животному в списке для обновления количества каждого типа
        for (Animal animal : animals) {
            // Помещение значения в отображение, увеличивая счетчик, если тип уже существует, иначе установка значения 1
            animalCountMap.put(animal.type(), animalCountMap.getOrDefault(animal.type(), 0) + 1);
        }
        return animalCountMap; // Возврат отображения с подсчитанным количеством животных каждого типа
    }
}

