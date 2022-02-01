package com.epam.interpreter;

public class NonTerminalExpression implements Expression {

    private final String value;

    public NonTerminalExpression(String value) {
        this.value = value;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(value);
    }
}
