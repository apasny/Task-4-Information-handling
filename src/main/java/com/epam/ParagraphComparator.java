package com.epam;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Composite> {

    @Override
    public int compare(Composite objectOne, Composite objectTwo) {
        return objectOne.getChildren().size()-objectTwo.getChildren().size();
    }
}
