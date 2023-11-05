package edu.hw4;

import java.util.List;

public class Task9 { // Объявление класса Task9

    private Task9() { // Приватный конструктор класса Task9

    }

    // Метод для подсчета общего количества лап у всех животных в списке
    public static int countTotalPaws(List<Animal> animals) {
        int totalPaws = 0; // Переменная для подсчета общего количества лап
        // Итерация по каждому животному в списке для подсчета количества лап
        for (Animal animal : animals) {
            totalPaws += animal.paws(); // Увеличение общего количества лап на количество лап текущего животного
        }
        return totalPaws; // Возврат общего количества лап у всех животных в списке
    }
}

