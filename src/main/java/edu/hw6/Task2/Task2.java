package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс Task2 предоставляет статический метод для клонирования файла с добавлением суффикса " - копия" к имени.
 */
public class Task2 {
    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private Task2() {
    }

    /**
     * Статический метод для клонирования файла с добавлением суффикса " - копия" к имени.
     *
     * @param path Путь к файлу, который нужно клонировать.
     * @throws IllegalArgumentException если файл не существует.
     * @throws RuntimeException         если произошла ошибка ввода/вывода при клонировании файла.
     */
    public static void cloneFile(Path path) {
        // Проверяем, существует ли файл
        if (Files.notExists(path)) {
            throw new IllegalArgumentException();
        }

        // Получаем имя файла и расширение файла
        String fileName = path.getFileName().toString();
        String fileExtension = "";

        int extensionIndex = fileName.lastIndexOf(".");
        if (extensionIndex > 0) {
            fileExtension = fileName.substring(extensionIndex);
            fileName = fileName.substring(0, extensionIndex);
        }

        // Подготавливаем путь для копии файла
        Path copyPath = path;
        int copyNumber = 0;

        // Пока существует файл с таким же именем, увеличиваем номер копии
        while (Files.exists(copyPath)) {
            copyNumber++;
            String copyName = fileName + " - копия";

            // Добавляем номер копии, если он больше 1
            if (copyNumber > 1) {
                copyName += " (" + copyNumber + ")";
            }
            copyName += fileExtension;

            copyPath = path.resolveSibling(copyName);
        }

        // Копируем файл
        try {
            Files.copy(path, copyPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
