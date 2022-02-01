package com.epam.interpreter;

public class TerminalExpressionMultiply implements Expression{
    @Override
    public void interpret(Context context) {
        String result;

        String secondArgument = context.popValue();
        String firstArgument = context.popValue();

        if (context.isNumeric(firstArgument) && context.isNumeric(secondArgument)) {
            result = Double.toString(Double.parseDouble(firstArgument) * Double.parseDouble(secondArgument));
        } else {
            result = firstArgument + " * " + secondArgument;
        }

        context.pushValue(result);
    }
}
