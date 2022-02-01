package com.epam.interpreter;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {

    private static final String SEPARATOR = "\\p{Blank}+";
    private static final String BRACKETS = "[\\[\\]]";

    public String calculate(String lexeme) {

        Context context = new Context();
        List<Expression> expressionList = decompose(lexeme);

        for (Expression expression : expressionList) {
            expression.interpret(context);
        }

        return context.popValue();
    }

    private List<Expression> decompose(String lexeme) {

        List<Expression> expressionList = new ArrayList<>();
        String expressionValue = lexeme.replaceAll(BRACKETS, "");

        for (String part : expressionValue.split(SEPARATOR)) {
            if (!part.isEmpty()) {
                switch (part) {
                    case "+":
                        expressionList.add(new TerminalExpressionAdd());
                        break;
                    case "-":
                        expressionList.add(new TerminalExpressionSubtract());
                        break;
                    case "/":
                        expressionList.add(new TerminalExpressionDivide());
                        break;
                    case "*":
                        expressionList.add(new TerminalExpressionMultiply());
                        break;
                    default:
                        expressionList.add(new NonTerminalExpression(part));
                }
            }
        }
        return expressionList;
    }

}
