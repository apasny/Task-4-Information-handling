package com.epam.parser;

import com.epam.component.Composite;
import com.epam.component.Lexeme;
import com.epam.component.LexemeType;
import com.epam.interpreter.ExpressionCalculator;

public class SentenceParser extends AbstractParser {

    private static final String REGEXP = "\\s+(?![^\\[\\]]*\\])";

    private static final ExpressionCalculator expressionCalculator = new ExpressionCalculator();

    public SentenceParser() {
        super(null);
    }

    @Override
    public Composite parse(String input) {

        String[] lexemes = input.split(getRegExp());

        Composite composite = new Composite();

        for (String lexeme : lexemes) {
            Lexeme lexemeComponent;
            if (lexeme.contains("[")) {
                String calculatedLexeme = expressionCalculator.calculate(lexeme);
                lexemeComponent = new Lexeme(calculatedLexeme, LexemeType.EXPRESSION);
            } else {
                lexemeComponent = new Lexeme(lexeme, LexemeType.WORD);
            }
            composite.add(lexemeComponent);
        }

        return composite;
    }

    @Override
    public String getRegExp() {
        return REGEXP;
    }

}
