package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {

    // Приватный конструктор класса
    private Task2() {

    }

    // Метод clusterize разбивает входную строку на кластеры, заключенные в скобках.
    // Возвращает список строк-кластеров.
    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>(); // Создание списка для хранения кластеров
        Stack<Integer> stack = new Stack<>(); // Инициализация стека для отслеживания открывающих и закрывающих скобок
        char[] chars = input.toCharArray(); // Преобразование входной строки в массив символов
        int start = 0; // Индекс начала текущего кластера

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') { // Если текущий символ - открывающая скобка
                stack.push(i); // Добавляем индекс открывающей скобки в стек
            } else if (chars[i] == ')') { // Если текущий символ - закрывающая скобка
                stack.pop(); // Удаляем соответствующую открывающую скобку из стека
                if (stack.isEmpty()) { // Если стек пуст, то все скобки до текущей закрыты
                    clusters.add(input.substring(start, i + 1)); // Добавляем найденный кластер в список
                    start = i + 1; // Обновляем индекс начала для следующего кластера
                }
            }
        }

        if (!stack.isEmpty()) { // Если стек не пуст, значит имеются непарные скобки
            throw new IllegalArgumentException("Invalid input: Unbalanced brackets"); // Генерация исключения
        }

        return clusters; // Возвращаем список кластеров
    }
}
