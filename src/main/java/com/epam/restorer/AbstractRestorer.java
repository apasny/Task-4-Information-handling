package com.epam.restorer;

import com.epam.component.Component;
import com.epam.component.Composite;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractRestorer implements Restorer {

    private final Restorer successor;

    public AbstractRestorer(Restorer successor) {
        this.successor = successor;
    }

    public Restorer getSuccessor() {
        return successor;
    }

    public String restore(Composite text) {
        StringBuilder restoredComponent = new StringBuilder();
        List<Component> textToRestore = new ArrayList<>(text.getChildren());
        for (Component part : textToRestore) {
            if (textToRestore.lastIndexOf(part) != textToRestore.size()){
                restoredComponent.append(getSuccessor().restore((Composite) part));
                restoredComponent.append(getRegExp());
            } else {
                restoredComponent.append(getSuccessor().restore((Composite) part));
            }
        }
        return restoredComponent.toString();
    }

    public abstract String getRegExp();
}
