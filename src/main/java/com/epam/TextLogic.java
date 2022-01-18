package com.epam;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite parse(String text) {
        TextParserBuilder textParserBuilder = new TextParserBuilder();
        Parser parser = textParserBuilder.build();
        return parser.parse(text);
    }

    public Composite sortParagraphs(Composite text) {
        List<Composite> paragraphs = new ArrayList<>();
        for (Component component: text.getChildren()) {
            paragraphs.add((Composite) component);
        }
        paragraphs.sort(new ParagraphComparator());
        return new Composite(paragraphs);
    }

}
