package edu.hw3;

import java.util.Comparator;

public class Task7 {
    // Внутренний статический класс, реализующий интерфейс Comparator для типа String
    static class NullComparator implements Comparator<String> {

        // Переопределение метода compare для сравнения двух строк
        @Override
        public int compare(String s1, String s2) {
            // Если оба значения строк равны null, возвращаем 0, так как они эквивалентны
            if (s1 == null && s2 == null) {
                return 0;
            }
            // Если первая строка равна null, а вторая нет, возвращаем -1,
            // указывая на то, что первая строка меньше второй
            if (s1 == null) {
                return -1;
            }
            // Если вторая строка равна null, а первая нет, возвращаем 1,
            // указывая на то, что первая строка больше второй
            if (s2 == null) {
                return 1;
            }
            // Если ни одна из строк не равна null, используем стандартное сравнение строк
            return s1.compareTo(s2);
        }
    }
}
