package com.epam.restorer;

import com.epam.component.Component;
import com.epam.component.Composite;
import com.epam.component.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class SentenceRestorer extends AbstractRestorer {

    public SentenceRestorer() {
        super(null);
    }

    @Override
    public String restore(Composite text) {
        StringBuilder restoredComponent = new StringBuilder();
        List<Component> textToRestore = new ArrayList<>(text.getChildren());

        for (Component part : textToRestore) {
            if (textToRestore.lastIndexOf(part) != textToRestore.size()){
                Lexeme word = (Lexeme) part;
                restoredComponent.append(word.getValue());
                restoredComponent.append(getRegExp());
            } else {
                Lexeme word = (Lexeme) part;
                restoredComponent.append(word.getValue());
            }
        }
        return restoredComponent.toString();
    }

    @Override
    public String getRegExp() {
        return " ";
    }
}
