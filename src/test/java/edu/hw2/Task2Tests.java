package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {

    @Test
    void testRectangleArea() {
        Task2.Shape rectangle = new Task2().new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        assertEquals(200.0, rectangle.area());
    }

    @Test
    void testSquareArea() {
        Task2.Shape square = new Task2().new Square();
        square.setWidth(20);
        assertEquals(400.0, square.area());
    }

    @Test
    void testRectangleWidthAndHeight() {
        Task2.Rectangle rectangle = new Task2().new Rectangle();
        rectangle.setWidth(15);
        rectangle.setHeight(25);
        assertEquals(15, rectangle.getWidth());
        assertEquals(25, rectangle.getHeight());
    }

    @Test
    void testSquareWidthAndHeight() {
        Task2.Square square = new Task2().new Square();
        square.setWidth(30);
        assertEquals(30, square.getWidth());
        assertEquals(30, square.getHeight());
    }

    @Test
    void testSquareWidthHeightEquality() {
        Task2.Square square = new Task2().new Square();
        square.setWidth(20);
        assertEquals(20, square.getWidth());
        assertEquals(20, square.getHeight());
    }

    @Test
    void testSquareSetHeight() {
        Task2.Square square = new Task2().new Square();
        square.setHeight(25);
        assertEquals(25, square.getHeight());
    }
}
