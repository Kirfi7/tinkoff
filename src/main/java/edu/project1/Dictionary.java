package edu.project1;

import java.util.Random;

// Класс для работы с словарем, содержащим набор слов
public class Dictionary {

    // Массив слов для использования в игре
    private static final String[] WORDS = {
        "blue", "word", "keyboard", "gravity", "road", "math", "tetris"
    };

    // Закрытый конструктор, предотвращающий создание экземпляров этого класса
    private Dictionary() {
    }

    // Метод для получения случайного слова из словаря
    public static String getWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);

        return WORDS[index];
    }
}

