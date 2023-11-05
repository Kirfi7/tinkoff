package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 { // Объявление класса Task19

    private Task19() { // Приватный конструктор класса Task19

    }

    // Метод для поиска ошибок в записях животных и формирования отображения ошибок для каждого животного
    public static Map<String, Set<Animal.ValidationError>> findErrorsInAnimalRecords(List<Animal> animals) {
        Map<String, Set<Animal.ValidationError>> errorsMap = new HashMap<>(); // Создание отображения для
        // хранения ошибок в записях животных
        // Итерация по каждому животному в списке для проверки ошибок в записи
        for (Animal animal : animals) {
            Set<Animal.ValidationError> errors = new HashSet<>(); // Создание множества для хранения
            // ошибок для конкретного животного
            if (animal.name() == null || animal.name().isEmpty()) { // Проверка, пустое ли имя у животного
                errors.add(Animal.ValidationError.EMPTY_NAME); // Добавление ошибки о пустом имени в множество ошибок
            }
            if (animal.age() < 0) { // Проверка, отрицательный ли возраст у животного
                errors.add(Animal.ValidationError.INVALID_AGE); // Добавление ошибки о недопустимом
                // возрасте в множество ошибок
            }
            if (!errors.isEmpty()) { // Проверка, содержит ли множество ошибок какие-либо ошибки
                errorsMap.put(animal.name(), errors); // Добавление множества ошибок в отображение
                // ошибок для данного животного
            }
        }
        return errorsMap; // Возврат отображения ошибок в записях животных
    }
}



