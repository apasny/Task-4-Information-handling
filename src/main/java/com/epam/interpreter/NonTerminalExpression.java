package com.epam.interpreter;

public class NonTerminalExpression implements Expression{

    private final Double number;

    public NonTerminalExpression(Double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
