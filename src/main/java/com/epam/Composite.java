package com.epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    public Composite(){
    }

    public Composite(List<? extends Component> children){
        this.children = Collections.unmodifiableList(children);
    }

    public void add(Component child) {
        children.add(child);
    }

    public List<Component> getChildren() {
        return children;
    }



}
