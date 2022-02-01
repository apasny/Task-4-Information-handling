package com.epam.parser;

import com.epam.component.Composite;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public Composite parse(String input) {
        Composite composite = new Composite();
        String[] parts = input.split(getRegExp());
        for (String part: parts) {
            Composite partComponent = getSuccessor().parse(part);
            composite.add(partComponent);
        }
        return composite;
    }

    public abstract String getRegExp();

}
