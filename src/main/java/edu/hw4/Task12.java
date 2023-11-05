package edu.hw4;

import java.util.List;

public class Task12 { // Объявление класса Task12

    private Task12() { // Приватный конструктор класса Task12

    }

    // Метод для подсчета количества животных с весом больше высоты
    public static int countAnimalsWeightGreaterThanHeight(List<Animal> animals) {
        int count = 0; // Переменная для подсчета количества животных
        // Итерация по каждому животному в списке для проверки, если вес превышает высоту
        for (Animal animal : animals) {
            if (animal.weight() > animal.height()) { // Проверка, превышает ли вес животного его высоту
                count++; // Увеличение счетчика, если условие выполняется
            }
        }
        return count; // Возврат количества животных с весом больше высоты
    }
}


