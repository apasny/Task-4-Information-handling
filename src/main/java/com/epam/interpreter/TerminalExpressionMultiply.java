package com.epam.interpreter;

public class TerminalExpressionMultiply implements Expression{
    @Override
    public void interpret(Context context) {
        Double result = context.popValue()*context.popValue();
        context.pushValue(result);
    }
}
