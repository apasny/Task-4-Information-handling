package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Composite;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] sentences = text.split(getRegExp());
        for (String sentence: sentences) {
            Composite sentenceComponent = getSuccessor().parse(sentence);
            composite.add(sentenceComponent);
        }
        return composite;
    }

    public abstract String getRegExp();

}
