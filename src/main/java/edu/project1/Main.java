package edu.project1;

public final class Main {

    // Приватный конструктор
    private Main() {
    }

    public static void main(String[] args) {
        // Создание экземпляра игры с максимальным количеством ошибок, установленным на 1
        Game game = new Game(1);
        // Запуск игры
        game.play();
    }
}
