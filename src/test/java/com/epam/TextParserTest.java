package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextParserTest {

    @Test
    public void testParseShouldReturnParagraphs() {

        String text = "lorem. ipsum\n dolor. sit. amet\n [5 2 + y] johny\n this. is. it";

        TextLogic textLogic = new TextLogic();

        Composite result = textLogic.parse(text);

        Assertions.assertEquals(result.getChildren().size(), 4);

    }

    @Test
    public void testParseShouldReturnSentences() {

        String paragraphs = "lorem. ipsum. dolor. sit. [5 2 + y].";

        ParagraphParser paragraphParser = new ParagraphParser(new SentenceParser());

        Composite result = paragraphParser.parse(paragraphs);

        Assertions.assertEquals(result.getChildren().size(), 5);

    }

    @Test
    public void testParseShouldReturnLexemes() {

        String sentence = "lorem ipsum dolor sit [5 2 + y]";

        SentenceParser sentenceParser = new SentenceParser();

        Composite result = sentenceParser.parse(sentence);

        Assertions.assertEquals(result.getChildren().size(), 5);

    }

}
