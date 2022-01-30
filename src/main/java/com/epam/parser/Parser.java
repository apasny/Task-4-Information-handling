package com.epam.parser;

import com.epam.component.Composite;

public interface Parser {

    Composite parse(String text);

}
