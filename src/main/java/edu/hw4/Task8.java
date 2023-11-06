package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 { // Объявление класса Task8

    private Task8() { // Приватный конструктор класса Task8

    }

    // Метод для поиска самого тяжелого животного с высотой ниже заданного значения k в списке
    public static Optional<Animal> findHeaviestAnimalBelowHeight(List<Animal> animals, int k) {
        return animals.stream() // Преобразование списка в поток для последующих операций
            .filter(animal -> animal.height() < k) // Фильтрация животных по высоте меньше k
            .max(Comparator.comparingInt(Animal::weight)); // Поиск максимального животного по весу из отфильтрованных
    }
}

