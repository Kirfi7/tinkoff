package edu.hw4;

import java.util.List;

public class Task14 { // Объявление класса Task14

    private Task14() { // Приватный конструктор класса Task14

    }

    // Метод для проверки, является ли высота собаки больше заданного значения k
    public static boolean isDogTallerThanK(List<Animal> animals, int k) {
        for (Animal animal : animals) { // Итерация по каждому животному в списке для проверки условия
            if (animal.type() == Animal.Type.DOG && animal.height() > k) { // Проверка, является ли животное собакой
                // и превышает ли его высота заданное значение k
                return true; // Возврат true, если условие выполняется хотя бы для одного животного
            }
        }
        return false; // Возврат false, если ни одно животное не соответствует условию
    }
}

