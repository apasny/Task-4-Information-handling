package com.epam;

public class SentenceParser extends AbstractParser {

    public SentenceParser() {
        super(null);
    }

    public Composite parse(String text) {

        String[] lexemes = text.split("(?<!\\d)\\s(?![\\dy])");

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

}
