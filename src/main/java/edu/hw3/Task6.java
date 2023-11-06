package edu.hw3;

import java.util.PriorityQueue;

public class Task6 {

    // Интерфейс для рынка акций
    interface StockMarket {
        /** Добавить акцию */
        void add(Stock stock);

        /** Удалить акцию */
        void remove(Stock stock);

        /** Самая дорогая акция */
        Stock mostValuableStock();
    }

    // Класс, представляющий акцию
    static class Stock {
        private String name; // Наименование акции
        private double price; // Цена акции

        Stock(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    // Реализация интерфейса StockMarket с использованием PriorityQueue
    static class StockMarketImpl implements StockMarket {

        private PriorityQueue<Stock> stockPriorityQueue; // Приоритетная очередь акций

        StockMarketImpl() {
            // Инициализация PriorityQueue с компаратором, сортирующим акции по убыванию цены
            stockPriorityQueue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
        }

        @Override
        public void add(Stock stock) {
            stockPriorityQueue.add(stock); // Добавление акции в приоритетную очередь
        }

        @Override
        public void remove(Stock stock) {
            stockPriorityQueue.remove(stock); // Удаление акции из приоритетной очереди
        }

        @Override
        public Stock mostValuableStock() {
            return stockPriorityQueue.peek(); // Получение самой дорогой акции из приоритетной очереди
        }
    }
}
