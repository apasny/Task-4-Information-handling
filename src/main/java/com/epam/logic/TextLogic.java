package com.epam.logic;

import com.epam.component.Component;
import com.epam.component.Composite;
import com.epam.parser.Parser;
import com.epam.parser.TextParserBuilder;
import com.epam.restorer.Restorer;
import com.epam.restorer.TextRestorerBuilder;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite parse(String text) {
        TextParserBuilder textParserBuilder = new TextParserBuilder();
        Parser parser = textParserBuilder.build();
        return parser.parse(text);
    }

    public String restore(Composite text){
        TextRestorerBuilder textRestoreBuilder = new TextRestorerBuilder();
        Restorer restorer = textRestoreBuilder.build();
        return restorer.restore(text);
    }

    public Composite sortParagraphs(Composite text) {
        List<Composite> paragraphs = new ArrayList<>();
        for (Component paragraph : text.getChildren()) {
            paragraphs.add((Composite) paragraph);
        }
        paragraphs.sort(new ParagraphComparator());
        return new Composite(paragraphs);
    }

    public Composite sortWordsInSentences(Composite text) {

        List<Composite> paragraphs = new ArrayList<>();
        List<Composite> sentences = new ArrayList<>();

        for (Component paragraph : text.getChildren()) {
            paragraphs.add((Composite) paragraph);
        }

        for (Composite paragraph : paragraphs) {
            for (Component sentence : paragraph.getChildren()) {
                sentences.add((Composite) sentence);
            }
        }

        for (Composite sentence : sentences) {
            List<Component> lexemes = sentence.getChildren();
            lexemes.sort(new LexemesComparator());
        }

        return new Composite(paragraphs);

    }

}



