package com.wrangling.tests;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;

public class TestTo {
    public static void main(String[] args) {
        D2wlLexer lexer = new D2wlLexer(CharStreams.fromString("TO to_file1.csv"));
        D2wlParser parser = new D2wlParser(new CommonTokenStream(lexer));

        D2wlParser.To_locationContext toFile = parser.to_clause().to_location();
        D2wlParser.UrlContext url = toFile.url();
        System.out.println("The url of the to-file: " + url.getText());
    }
}
