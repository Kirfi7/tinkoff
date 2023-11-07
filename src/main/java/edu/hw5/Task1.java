package edu.hw5;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Task1 {
    private Task1() {
    }

    private final static int MINUTES_IN_HOUR = 60; // Константа, представляющая количество минут в часе

    // Метод вычисления средней продолжительности сеанса в минутах на основе списка строк с временными отрезками
    public static LocalTime calculateAverageSessionDurationInMinutes(List<String> sessions) {
        // Вычисление суммарного времени в минутах для всех сеансов с помощью потоков и reduce
        var timeInMinutes = sessions.stream().reduce(0L, (acc, session) -> {
            var time = session.split(" - ");
            // Получение длительности сеанса в минутах и добавление к общей сумме
            return acc + getDuration(time[1])
                .minus(getDuration(time[0]))
                .toMinutes();
        }, Long::sum) / sessions.size(); // Вычисление среднего времени сеанса в минутах

        // Преобразование времени в формат LocalTime.
        return LocalTime.of((int) (timeInMinutes / MINUTES_IN_HOUR), (int) (timeInMinutes % MINUTES_IN_HOUR));
    }

    // Вспомогательный метод для преобразования строкового представления времени в объект Duration
    private static Duration getDuration(String datetime) {
        var dt = datetime.split(", ");
        var date = dt[0].split("-");
        var time = dt[1].split(":");

        // Создание объекта Duration на основе даты и времени
        return Duration.ofDays(Integer.parseInt(date[2]))
            .plusHours(Integer.parseInt(time[0]))
            .plusMinutes(Integer.parseInt(time[1]));
    }
}

