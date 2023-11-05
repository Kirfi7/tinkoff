package edu.hw4;

import java.util.List;

public class Task18 { // Объявление класса Task18

    private Task18() { // Приватный конструктор класса Task18

    }

    // Метод для поиска самой тяжелой рыбы в списке списков животных
    public static Animal findHeaviestFish(List<List<Animal>> animalLists) {
        Animal heaviestFish = null; // Инициализация переменной для хранения самой тяжелой рыбы
        // Итерация по каждому списку животных в списке списков для поиска самой тяжелой рыбы
        for (List<Animal> animals : animalLists) {
            for (Animal animal : animals) { // Итерация по каждому животному в текущем списке
                if (animal.type() == Animal.Type.FISH) { // Проверка, является ли тип животного рыбой
                    // Проверка, является ли текущая рыба самой тяжелой или самая тяжелая рыба еще не определена
                    if (heaviestFish == null || animal.weight() > heaviestFish.weight()) {
                        heaviestFish = animal; // Обновление самой тяжелой рыбы, если условие выполняется
                    }
                }
            }
        }
        return heaviestFish; // Возврат самой тяжелой рыбы в списке списков животных
    }
}

