package com.epam;

public class TextParser extends AbstractParser {

    public TextParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] paragraphs = text.split("\n");
        for (String paragraph: paragraphs) {
            Component paragraphComponent = getSuccessor().parse(paragraph);
            composite.add(paragraphComponent);
        }
        return composite;
    }

}
