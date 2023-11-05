package edu.hw4;

import java.util.List;

public class Task5 { // Объявление класса Task5

    private Task5() { // Приватный конструктор класса Task5

    }

    // Метод для сравнения количества самцов и самок в списке животных
    public static Animal.Sex compareSexCount(List<Animal> animals) {
        int maleCount = 0; // Переменная для подсчета количества самцов
        int femaleCount = 0; // Переменная для подсчета количества самок
        // Итерация по каждому животному в списке для подсчета количества самцов и самок
        for (Animal animal : animals) {
            if (animal.sex() == Animal.Sex.M) { // Проверка, является ли животное самцом
                maleCount++; // Увеличение счетчика самцов
            } else if (animal.sex() == Animal.Sex.F) { // Проверка, является ли животное самкой
                femaleCount++; // Увеличение счетчика самок.
            }
        }
        if (maleCount > femaleCount) { // Проверка, больше ли количество самцов, чем самок
            return Animal.Sex.M; // Возврат значения, указывающего на преобладание самцов
        } else if (femaleCount > maleCount) { // Проверка, больше ли количество самок, чем самцов
            return Animal.Sex.F; // Возврат значения, указывающего на преобладание самок
        } else {
            return null; // Возврат null, если количество самцов и самок одинаково
        }
    }
}


