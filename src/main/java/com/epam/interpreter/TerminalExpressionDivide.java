package com.epam.interpreter;

public class TerminalExpressionDivide implements Expression {
    @Override
    public void interpret(Context context) {

        String result;

        String secondArgument = context.popValue();
        String firstArgument = context.popValue();

        if (context.isNumeric(firstArgument) && context.isNumeric(secondArgument)) {
            if (Double.parseDouble(secondArgument) != 0) {
                result = Double.toString(Double.parseDouble(firstArgument) / Double.parseDouble(secondArgument));
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            result = firstArgument + " / " + secondArgument;
        }

        context.pushValue(result);

    }
}
