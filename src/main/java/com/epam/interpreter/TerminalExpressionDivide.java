package com.epam.interpreter;

public class TerminalExpressionDivide implements Expression {
    @Override
    public void interpret(Context context) {
        Double secondNumber = context.popValue();
        Double firstNumber = context.popValue();

        if (secondNumber == 0) {
            throw new IllegalArgumentException();
        }

        context.pushValue(firstNumber / secondNumber);
    }
}
