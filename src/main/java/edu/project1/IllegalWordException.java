package edu.project1;

// Класс исключения для недопустимого слова
public class IllegalWordException extends RuntimeException {
    // Конструктор исключения с сообщением об ошибке
    public IllegalWordException(String word) {
        super(word + "can't be guessed");
    }
}
