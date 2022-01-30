package com.epam.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {

    private final Deque<Double> expressionValues = new ArrayDeque<>();

    public Double popValue(){
        return expressionValues.pop();
    }

    public void pushValue(Double value){
        expressionValues.push(value);
    }
}
