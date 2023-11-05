package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 { // Объявление класса Task6

    private Task6() { // Приватный конструктор класса Task6

    }

    // Метод для поиска самого тяжелого животного для каждого типа животных в списке
    public static Map<Animal.Type, Animal> findHeaviestAnimalForEachType(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviestAnimalMap = new HashMap<>(); // Создание отображения для хранения самого
        // тяжелого животного каждого типа
        // Итерация по каждому животному в списке для обновления самого тяжелого животного каждого типа
        for (Animal animal : animals) {
            // Проверка, содержит ли отображение самое тяжелое животное для данного типа, или если текущее животное
            // тяжелее
            if (!heaviestAnimalMap.containsKey(animal.type()) || animal.weight() > heaviestAnimalMap.get(animal.type())
                .weight()) {
                heaviestAnimalMap.put(animal.type(), animal); // Обновление самого тяжелого животного для данного типа
            }
        }
        return heaviestAnimalMap; // Возврат отображения с самыми тяжелыми животными для каждого типа
    }
}






