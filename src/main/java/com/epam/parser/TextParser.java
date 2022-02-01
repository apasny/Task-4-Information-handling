package com.epam.parser;

public class TextParser extends AbstractParser {

    private static final String REGEXP = "\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    public String getRegExp(){
        return REGEXP;
    }

}
