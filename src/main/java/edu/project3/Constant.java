package edu.project3;

public record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }
}
