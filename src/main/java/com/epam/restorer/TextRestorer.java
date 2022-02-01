package com.epam.restorer;

public class TextRestorer extends AbstractRestorer{

    public TextRestorer(Restorer successor) {
        super(successor);
    }

    @Override
    public String getRegExp() {
        return "\n";
    }
}
