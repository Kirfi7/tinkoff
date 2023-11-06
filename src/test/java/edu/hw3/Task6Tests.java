package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Tests {

    @Test
    public void testMostValuableStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("ABC", 100.0);
        Task6.Stock stock2 = new Task6.Stock("XYZ", 200.0);
        Task6.Stock stock3 = new Task6.Stock("DEF", 150.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        Task6.Stock mostValuableStock = stockMarket.mostValuableStock();
        assertEquals("XYZ", mostValuableStock.getName());
        assertEquals(200.0, mostValuableStock.getPrice());
    }

    @Test
    public void testRemoveStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("ABC", 100.0);
        Task6.Stock stock2 = new Task6.Stock("XYZ", 200.0);
        Task6.Stock stock3 = new Task6.Stock("DEF", 150.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        stockMarket.remove(stock2);
        Task6.Stock mostValuableStock = stockMarket.mostValuableStock();
        assertEquals("DEF", mostValuableStock.getName());
        assertEquals(150.0, mostValuableStock.getPrice());
    }

    @Test
    public void testAddStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("ABC", 100.0);
        Task6.Stock stock2 = new Task6.Stock("XYZ", 200.0);
        Task6.Stock stock3 = new Task6.Stock("DEF", 150.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        Task6.Stock mostValuableStock = stockMarket.mostValuableStock();
        assertEquals("XYZ", mostValuableStock.getName());
        assertEquals(200.0, mostValuableStock.getPrice());
    }

    @Test
    public void testMostValuableStockEmpty() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock mostValuableStock = stockMarket.mostValuableStock();
        assertNull(mostValuableStock);
    }
}
