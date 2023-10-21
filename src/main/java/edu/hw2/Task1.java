package edu.hw2;

public sealed interface Task1 {
    double evaluate();

    final class Constant implements Task1 {
        private final double value;

        public Constant(double value) {
            this.value = value;
        }

        @Override
        public double evaluate() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    final class Negate implements Task1 {
        private final Task1 expr;

        public Negate(Task1 expr) {
            this.expr = expr;
        }

        @Override
        public double evaluate() {
            return -expr.evaluate();
        }

        @Override
        public String toString() {
            return "(-" + expr + ")";
        }
    }

    final class Exponent implements Task1 {
        private final Task1 base;
        private final int power;

        public Exponent(Task1 base, int power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public double evaluate() {
            double result = 1;
            for (int i = 0; i < power; i++) {
                result *= base.evaluate();
            }
            return result;
        }

        @Override
        public String toString() {
            return "(" + base + "^" + power + ")";
        }
    }

    final class Addition implements Task1 {
        private final Task1 left;
        private final Task1 right;

        public Addition(Task1 left, Task1 right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }

        @Override
        public String toString() {
            return "(" + left + " + " + right + ")";
        }
    }

    final class Multiplication implements Task1 {
        private final Task1 left;
        private final Task1 right;

        public Multiplication(Task1 left, Task1 right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }

        @Override
        public String toString() {
            return "(" + left + " * " + right + ")";
        }
    }
}


