package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class Task8 {

    // Вложенный статический класс BackwardIterator, реализующий интерфейс Iterator<T>
    static class BackwardIterator<T> implements Iterator<T> {

        // Список, по которому осуществляется итерация
        private List<T> list;

        // Текущий индекс итератора
        private int currentIndex;

        // Конструктор класса BackwardIterator, инициализирующий список и текущий индекс
        BackwardIterator(List<T> list) {
            this.list = list;
            this.currentIndex = list.size() - 1;
        }

        // Проверяет, существует ли следующий элемент для итерации
        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        // Возвращает следующий элемент списка, уменьшая текущий индекс
        // Если элементы закончились, возвращает null
        @Override
        public T next() {
            if (hasNext()) {
                return list.get(currentIndex--);
            }
            return null;
        }
    }
}
