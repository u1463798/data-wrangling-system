package com.wrangling.tests;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;
import com.wrangling.models.FromFile;

import java.util.ArrayList;
import java.util.List;

public class TestFrom {
    public static void main(String[] args) throws Exception{
        D2wlLexer lexer = new D2wlLexer(CharStreams.fromString("FROM file1.csv as f1, file2.csv as f2, file3.csv as f3"));
        D2wlParser parser = new D2wlParser(new CommonTokenStream(lexer));

        List<D2wlParser.From_locationContext> files = parser.from_clause().from_list().from_location();
        List<FromFile> fromFiles = new ArrayList<>();
        for (D2wlParser.From_locationContext file : files) {
            FromFile f = new FromFile(file.url().name().getText(), file.url().extension().getText(), file.name_alias().getText());
            fromFiles.add(f);
        }
        for (FromFile f : fromFiles) {
            System.out.println("Url: " + f.getUrl() + " Ext: " + f.getExtension() + " Alias: " + f.getAlias());
            System.out.println("=====================");
        }
    }
}
