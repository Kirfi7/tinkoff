package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Tests {

    @Test
    public void testConstant() {
        Task1 constant = new Task1.Constant(5.5);
        assertEquals(5.5, constant.evaluate());
    }

    @Test
    public void testNegate() {
        Task1 constant = new Task1.Constant(5.5);
        Task1 negate = new Task1.Negate(constant);
        assertEquals(-5.5, negate.evaluate());
    }

    @Test
    public void testExponent() {
        Task1 constant = new Task1.Constant(2);
        Task1 exponent = new Task1.Exponent(constant, 3);
        assertEquals(8, exponent.evaluate());
    }

    @Test
    public void testAddition() {
        Task1 constant1 = new Task1.Constant(2.5);
        Task1 constant2 = new Task1.Constant(3.5);
        Task1 addition = new Task1.Addition(constant1, constant2);
        assertEquals(6.0, addition.evaluate());
    }

    @Test
    public void testMultiplication() {
        Task1 constant1 = new Task1.Constant(2.5);
        Task1 constant2 = new Task1.Constant(3.5);
        Task1 multiplication = new Task1.Multiplication(constant1, constant2);
        assertEquals(8.75, multiplication.evaluate());
    }

    @Test
    public void testComplexExpression() {
        Task1 two = new Task1.Constant(2);
        Task1 four = new Task1.Constant(4);
        Task1 negOne = new Task1.Negate(new Task1.Constant(1));
        Task1 sumTwoFour = new Task1.Addition(two, four);
        Task1 mult = new Task1.Multiplication(sumTwoFour, negOne);
        Task1 exp = new Task1.Exponent(mult, 2);
        Task1 res = new Task1.Addition(exp, new Task1.Constant(1));

        assertEquals(37.0, res.evaluate());
    }

    @Test
    public void testConstantToString() {
        Task1 constant = new Task1.Constant(5.5);
        assertEquals("5.5", constant.toString());
    }

    @Test
    public void testNegateToString() {
        Task1 constant = new Task1.Constant(5.5);
        Task1 negate = new Task1.Negate(constant);
        assertEquals("(-5.5)", negate.toString());
    }

    @Test
    public void testExponentToString() {
        Task1 constant = new Task1.Constant(2);
        Task1 exponent = new Task1.Exponent(constant, 3);
        assertEquals("(2.0^3)", exponent.toString());
    }

    @Test
    public void testAdditionToString() {
        Task1 constant1 = new Task1.Constant(2.5);
        Task1 constant2 = new Task1.Constant(3.5);
        Task1 addition = new Task1.Addition(constant1, constant2);
        assertEquals("(2.5 + 3.5)", addition.toString());
    }

    @Test
    public void testMultiplicationToString() {
        Task1 constant1 = new Task1.Constant(2.5);
        Task1 constant2 = new Task1.Constant(3.5);
        Task1 multiplication = new Task1.Multiplication(constant1, constant2);
        assertEquals("(2.5 * 3.5)", multiplication.toString());
    }

}

