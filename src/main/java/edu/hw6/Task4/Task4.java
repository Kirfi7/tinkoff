package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

/**
 * Класс Task4 предоставляет статический метод для записи фразы в файл с использованием композиции OutputStream'ов.
 */
public class Task4 {
    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private Task4() {
    }

    /**
     * Статический метод для записи фразы в файл с использованием композиции OutputStream'ов.
     *
     * @param path Путь к файлу, в который будет записана фраза.
     * @throws IOException если произошла ошибка ввода/вывода при записи в файл.
     */
    public static void printPhraseInFile(Path path) throws IOException {
        // Создаем OutputStream для записи в файл
        try (OutputStream os = Files.newOutputStream(path);
             // Добавляем CheckedOutputStream для проверки записи при помощи контрольной суммы
             CheckedOutputStream checkedOS = new CheckedOutputStream(os, new CRC32());
             // Добавляем BufferedOutputStream для буферизации данных
             BufferedOutputStream bufferedOs = new BufferedOutputStream(checkedOS);
             // Добавляем OutputStreamWriter для работы с символами и поддержки UTF-8
             OutputStreamWriter osWriter = new OutputStreamWriter(bufferedOs, StandardCharsets.UTF_8);
             // Добавляем PrintWriter для удобства записи текста
             PrintWriter writer = new PrintWriter(osWriter);
        ) {
            // Записываем фразу в файл
            writer.print("Programming is learned by writing programs. - Brian Kernighan");
        }
    }
}
