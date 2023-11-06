package edu.hw4;

import java.util.List;

public class Task17 { // Объявление класса Task17

    private Task17() { // Приватный конструктор класса Task17

    }

    // Метод для определения, кусают ли пауки больше, чем собаки, в списке животных
    public static boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        int spiderBites = 0; // Переменная для подсчета количества кусков пауков
        int dogBites = 0; // Переменная для подсчета количества кусков собак

        // Итерация по каждому животному в списке для подсчета количества кусков пауков и собак
        for (Animal animal : animals) {
            if (animal.type() == Animal.Type.SPIDER) { // Проверка, является ли тип животного пауком
                spiderBites++; // Увеличение счетчика кусков пауков
            } else if (animal.type() == Animal.Type.DOG) { // Проверка, является ли тип животного собакой
                dogBites++; // Увеличение счетчика кусков собак
            }
        }

        if (spiderBites == 0 && dogBites == 0) { // Проверка, если количество кусков пауков и собак равно 0
            return false; // Возврат false, если нет ни одного куска у пауков или собак
        } else {
            return spiderBites > dogBites; // Возврат true, если количество кусков пауков больше, чем у собак
        }
    }
}


