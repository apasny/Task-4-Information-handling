package com.epam.logic;

import com.epam.component.Component;
import com.epam.component.Lexeme;

import java.util.Comparator;

public class LexemesComparator implements Comparator<Component> {

    @Override
    public int compare(Component objectOne, Component objectTwo) {

        Lexeme lexemeOne = (Lexeme) objectOne;
        Lexeme lexemeTwo = (Lexeme) objectTwo;

        return lexemeOne.getValue().length()-lexemeTwo.getValue().length();
    }

}
