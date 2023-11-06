package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task16 { // Объявление класса Task16

    private Task16() { // Приватный конструктор класса Task16

    }

    // Метод для сортировки животных по типу, полу и имени
    public static List<Animal> sortAnimalsByTypeSexAndName(List<Animal> animals) {
        return animals.stream() // Преобразование списка в поток для последующих операций
            .sorted(Comparator.comparing(Animal::type) // Сортировка по типу животного
                .thenComparing(Animal::sex) // Затем сортировка по полу
                .thenComparing(Animal::name)) // Затем сортировка по имени
            .collect(Collectors.toList()); // Сбор отсортированных элементов обратно в список
    }
}

