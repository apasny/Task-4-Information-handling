package com.epam.restorer;

public class ParagraphRestorer extends AbstractRestorer {

    public ParagraphRestorer(Restorer successor) {
        super(successor);
    }

    @Override
    public String getRegExp() {
        return ".";
    }
}
