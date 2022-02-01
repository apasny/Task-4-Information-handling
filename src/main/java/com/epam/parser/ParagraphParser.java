package com.epam.parser;

public class ParagraphParser extends AbstractParser {

    private static final String REGEXP = "[\\.!?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public String getRegExp(){
        return REGEXP;
    }
}
