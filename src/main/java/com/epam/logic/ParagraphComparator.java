package com.epam.logic;

import com.epam.component.Composite;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Composite> {

    @Override
    public int compare(Composite objectOne, Composite objectTwo) {
        return objectOne.getChildren().size()-objectTwo.getChildren().size();
    }
}
