package edu.hw2;

public sealed interface Task1 {
    double evaluate(); // Объявляем метод для вычисления.

    // Вложенный класс Constant, реализующий интерфейс Task1.
    final class Constant implements Task1 {
        private final double value; // Приватное поле для хранения значения.

        // Конструктор класса Constant.
        public Constant(double value) {
            this.value = value;
        }

        // Реализация метода evaluate для постоянного значения.
        @Override
        public double evaluate() {
            return value;
        }

        // Переопределение метода toString для представления значения в виде строки.
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    // Вложенный класс Negate, реализующий интерфейс Task1.
    final class Negate implements Task1 {
        private final Task1 expr; // Приватное поле для выражения.

        // Конструктор класса Negate.
        public Negate(Task1 expr) {
            this.expr = expr;
        }

        // Реализация метода evaluate для операции отрицания.
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }

        // Переопределение метода toString для представления выражения в виде строки.
        @Override
        public String toString() {
            return "(-" + expr + ")";
        }
    }

    // Вложенный класс Exponent, реализующий интерфейс Task1.
    final class Exponent implements Task1 {
        private final Task1 base; // Приватное поле для базы степени.
        private final int power; // Приватное поле для показателя степени.

        // Конструктор класса Exponent.
        public Exponent(Task1 base, int power) {
            this.base = base;
            this.power = power;
        }

        // Реализация метода evaluate для операции возведения в степень.
        @Override
        public double evaluate() {
            double result = 1;
            for (int i = 0; i < power; i++) {
                result *= base.evaluate();
            }
            return result;
        }

        // Переопределение метода toString для представления выражения в виде строки.
        @Override
        public String toString() {
            return "(" + base + "^" + power + ")";
        }
    }

    // Вложенный класс Addition, реализующий интерфейс Task1.
    final class Addition implements Task1 {
        private final Task1 left; // Приватное поле для левого операнда.
        private final Task1 right; // Приватное поле для правого операнда.

        // Конструктор класса Addition.
        public Addition(Task1 left, Task1 right) {
            this.left = left;
            this.right = right;
        }

        // Реализация метода evaluate для операции сложения.
        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }

        // Переопределение метода toString для представления выражения в виде строки.
        @Override
        public String toString() {
            return "(" + left + " + " + right + ")";
        }
    }

    // Вложенный класс Multiplication, реализующий интерфейс Task1.
    final class Multiplication implements Task1 {
        private final Task1 left; // Приватное поле для левого операнда.
        private final Task1 right; // Приватное поле для правого операнда.

        // Конструктор класса Multiplication.
        public Multiplication(Task1 left, Task1 right) {
            this.left = left;
            this.right = right;
        }

        // Реализация метода evaluate для операции умножения.
        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }

        // Переопределение метода toString для представления выражения в виде строки.
        @Override
        public String toString() {
            return "(" + left + " * " + right + ")";
        }
    }
}
