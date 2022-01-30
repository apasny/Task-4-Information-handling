package com.epam.parser;

import com.epam.component.Composite;
import com.epam.component.Lexeme;
import com.epam.component.LexemeType;

public class SentenceParser extends AbstractParser {

    private static final String REGEXP = "(?<!\\d)\\s(?![\\d])";

    public SentenceParser() {
        super(null);
    }

    @Override
    public Composite parse(String text) {

        String[] lexemes = text.split(getRegExp());

        Composite composite = new Composite();

        for (String lexeme : lexemes) {
            Lexeme lexemeComponent;
            if (lexeme.contains("[")) {
                lexemeComponent = new Lexeme(lexeme, LexemeType.EXPRESSION);
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
