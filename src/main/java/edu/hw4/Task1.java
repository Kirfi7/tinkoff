package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task1 { // Объявление класса Task1

    private Task1() { // Приватный конструктор класса Task1

    }

    // Метод для сортировки списка животных по их росту
    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        List<Animal> sortedAnimals = new ArrayList<>(animals); // Создание копии списка животных
        // Сортировка списка по возрастанию высоты животных с использованием лямбда-выражения
        Collections.sort(sortedAnimals, Comparator.comparingInt(Animal::height));
        return sortedAnimals; // Возврат отсортированного списка животных
    }
}
