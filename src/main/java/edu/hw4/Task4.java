package edu.hw4;

import java.util.List;

public class Task4 { // Объявление класса Task4

    private Task4() { // Приватный конструктор класса Task4

    }

    // Метод для поиска животного с самым длинным именем в списке
    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        if (animals.isEmpty()) { // Проверка, пуст ли список животных
            return null; // Возврат null, если список пуст
        }
        Animal longestNameAnimal = animals.get(0); // Инициализация переменной для животного с самым длинным именем
        // Итерация по каждому животному в списке для поиска животного с самым длинным именем
        for (Animal animal : animals) {
            // Проверка длины имени текущего животного и обновление longestNameAnimal при необходимости
            if (animal.name().length() > longestNameAnimal.name().length()) {
                longestNameAnimal = animal; // Обновление longestNameAnimal, если текущее имя длиннее
            }
        }
        return longestNameAnimal; // Возврат животного с самым длинным именем
    }
}

