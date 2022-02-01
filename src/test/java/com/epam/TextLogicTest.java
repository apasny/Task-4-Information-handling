package com.epam;

import com.epam.component.Component;
import com.epam.component.Composite;
import com.epam.component.Lexeme;
import com.epam.interpreter.ExpressionCalculator;
import com.epam.logic.TextLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextLogicTest {

    @Test
    public void testSortParagraphsShouldSortCorrect() {

        //given
        String text = "lorem. ipsum\n dolor. sit. amet\n [5 2 + y].\n this. is. it. uy.";

        TextLogic textLogic = new TextLogic();
        Composite parsedText = textLogic.sortParagraphs(textLogic.parse(text));

        //when
        Composite result = (Composite) parsedText.getChildren().get(3);

        //then
        Assertions.assertEquals(result.getChildren().size(), 4);

    }

    @Test
    public void testSortWordsInSentencesShouldSortCorrect() {

        //given
        String text = "lopikfmhwnw qwqwrqrq qwqrw qwe bc a. lolik loli lol lo l";

        TextLogic textLogic = new TextLogic();

        Composite result = textLogic.sortWordsInSentences(textLogic.parse(text));

        //when
        List<Component> paragraphs = result.getChildren();
        Composite sentencesObj = (Composite) paragraphs.get(0);

        List<Component> sentences = sentencesObj.getChildren();
        Composite lexemesObj = (Composite) sentences.get(0);

        List<Component> lexemes = lexemesObj.getChildren();
        Lexeme word = (Lexeme) lexemes.get(0);

        //then
        Assertions.assertEquals(word.getValue(), "a");

    }

    @Test
    public void testCalculateShouldReturnCorrectNumber() {

        //given
        String text = "[2 3 * y + 2 -]"; //6.0 + y - 2.0

        ExpressionCalculator expressionCalculator = new ExpressionCalculator();

        //when
        String result = expressionCalculator.calculate(text);

        //then
        Assertions.assertEquals(result, "6.0 + y - 2");

    }

    @Test
    public void testRestoreShouldReturnInitialText() {

        //given
        String text = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, " +
                "remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset " +
                "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        TextLogic textLogic = new TextLogic();

        Composite restorable = textLogic.parse(text);

        //when
        String restored = textLogic.restore(restorable);

        //then
        Assertions.assertEquals(restored, "It has survived - not only (five) centuries, but also the leap into 15.0 electronic typesetting, " +
                "remaining 8.0 essentially 5.0 unchanged. It was popularised in the 5 * x with the release of Letraset " +
                "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

    }
}
