package com.epam.interpreter;

public class TerminalExpressionSubtract implements Expression{
    @Override
    public void interpret(Context context) {
        Double result = context.popValue()-context.popValue();
        context.pushValue(result);
    }
}
