package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 { // Объявление класса Task2

    private Task2() { // Приватный конструктор класса Task2

    }

    // Метод для сортировки списка животных по весу и выбора верхних k элементов
    public static List<Animal> sortAndSelectTopKByWeight(List<Animal> animals, int k) {
        List<Animal> sortedAnimals = new ArrayList<>(animals); // Создание копии списка животных
        // Сортировка списка по убыванию веса животных с использованием лямбда-выражения
        Collections.sort(sortedAnimals, Comparator.comparingInt(Animal::weight).reversed());
        // Выбор подсписка из начала списка, ограниченного значением k или размером списка
        return sortedAnimals.subList(0, Math.min(k, sortedAnimals.size()));
    }
}

