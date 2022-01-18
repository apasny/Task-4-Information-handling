package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextLogicTest {

    @Test
    public void testSortParagraphsShouldSortCorrect() {

        String text = "lorem. ipsum\n dolor. sit. amet\n [5 2 + y].\n this. is. it. uy.";

        TextLogic textLogic = new TextLogic();

        Composite result = textLogic.sortParagraphs(textLogic.parse(text));

        Composite paragraph = (Composite) result.getChildren().get(3);

        Assertions.assertEquals(paragraph.getChildren().size(), 4);

    }
}
