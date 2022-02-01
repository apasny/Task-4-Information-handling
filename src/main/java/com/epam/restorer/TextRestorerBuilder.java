package com.epam.restorer;

public class TextRestorerBuilder {
    public Restorer build(){
        return new TextRestorer(new ParagraphRestorer(new SentenceRestorer()));
    }
}
