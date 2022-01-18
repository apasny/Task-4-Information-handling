package com.epam;

public class ParagraphParser extends AbstractParser {

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] sentences = text.split("\\.");
        for (String sentence: sentences) {
            Component sentenceComponent = getSuccessor().parse(sentence);
            composite.add(sentenceComponent);
        }
        return composite;
    }
}
