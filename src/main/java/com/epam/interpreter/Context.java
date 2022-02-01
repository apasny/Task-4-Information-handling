package com.epam.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {

    private final Deque<String> expressionValues = new ArrayDeque<>();

    public String popValue() {
        return expressionValues.pop();
    }

    public void pushValue(String value) {
        expressionValues.push(value);
    }

    public boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
