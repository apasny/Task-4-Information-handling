package com.epam;

import com.epam.component.Component;
import com.epam.component.Composite;
import com.epam.component.Lexeme;
import com.epam.logic.TextLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextLogicTest {

    @Test
    public void testSortParagraphsShouldSortCorrect() {

        String text = "lorem. ipsum\n dolor. sit. amet\n [5 2 + y].\n this. is. it. uy.";

        TextLogic textLogic = new TextLogic();

        Composite result = textLogic.sortParagraphs(textLogic.parse(text));

        Composite paragraph = (Composite) result.getChildren().get(3);

        Assertions.assertEquals(paragraph.getChildren().size(), 4);

    }

    @Test
    public void testSortWordsInSentencesShouldSortCorrect() {

        String text = "lopikfmhwnw qwqwrqrq qwqrw qwe bc a. lolik loli lol lo l";

        TextLogic textLogic = new TextLogic();

        Composite result = textLogic.sortWordsInSentences(textLogic.parse(text));

        List<Component> paragraphs = result.getChildren();
        Composite sentencesObj = (Composite)paragraphs.get(0);

        List<Component> sentences = sentencesObj.getChildren();
        Composite lexemesObj = (Composite)sentences.get(0);

        List<Component> lexemes = lexemesObj.getChildren();
        Lexeme word = (Lexeme)lexemes.get(0);

        Assertions.assertEquals(word.getValue(), "a");

    }
}
