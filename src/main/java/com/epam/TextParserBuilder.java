package com.epam;

public class TextParserBuilder {

    public Parser build(){
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }

}
