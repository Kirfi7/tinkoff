package edu.project3;

public sealed interface Expr permits Constant {
    double evaluate();
}
