package com.epam;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

}
