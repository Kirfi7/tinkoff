package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task20 { // Объявление класса Task20

    private Task20() { // Приватный конструктор класса Task20

    }

    // Метод для поиска ошибок в записях животных в удобном для чтения формате
    public static Map<String, String> findErrorsInAnimalRecordsReadable(List<Animal> animals) {
        Map<String, String> errorsMap = new HashMap<>(); // Создание отображения для хранения ошибок
        // в удобном для чтения формате
        // Итерация по каждому животному в списке для поиска ошибок в записи
        for (Animal animal : animals) {
            List<String> errors = new ArrayList<>(); // Создание списка для хранения ошибок для конкретного животного
            if (animal.name() == null || animal.name().isEmpty()) { // Проверка, пустое ли имя у животного
                errors.add("Empty name"); // Добавление ошибки о пустом имени в список ошибок
            }
            if (animal.age() < 0) { // Проверка, отрицательный ли возраст у животного
                errors.add("Invalid age"); // Добавление ошибки о недопустимом возрасте в список ошибок
            }
            if (!errors.isEmpty()) { // Проверка, содержит ли список ошибок какие-либо ошибки
                errorsMap.put(animal.name(), String.join(", ", errors)); // Добавление списка ошибок
                // в отображение ошибок в удобном для чтения формате для данного животного
            }
        }
        return errorsMap; // Возврат отображения ошибок в записях животных в удобном для чтения формате
    }
}

