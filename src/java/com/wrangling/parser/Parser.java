package com.wrangling.parser;

import com.wrangling.exceptions.ParsingException;
import com.wrangling.models.Query;

public interface Parser {
    Query parse(String code) throws ParsingException;
}
