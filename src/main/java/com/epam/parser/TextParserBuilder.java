package com.epam.parser;

public class TextParserBuilder {

    public Parser build(){
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }

}
