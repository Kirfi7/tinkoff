package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    // Приватный конструктор класса
    private Task3() {

    }

    // Метод freqDict, который принимает список объектов и возвращает Map (словарь) частоты элементов
    public static Map<Object, Integer> freqDict(List<Object> list) {
        // Создание пустого словаря для хранения частот
        Map<Object, Integer> freqMap = new HashMap<>();

        // Перебор элементов в переданном списке
        for (Object item : list) {
            // Помещение элемента в словарь с увеличением счетчика частоты (или установкой в 1, если элемент новый)
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        // Возвращение словаря частоты элементов
        return freqMap;
    }
}
