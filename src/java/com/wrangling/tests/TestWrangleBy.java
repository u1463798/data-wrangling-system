package com.wrangling.tests;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;
import com.wrangling.antlr.D2wlParser.Function_argumentContext;
import com.wrangling.antlr.D2wlParser.Wrangle_operationContext;

import static com.wrangling.antlr.D2wlParser.*;

import java.util.List;

public class TestWrangleBy {
    public static void main(String[] args) {
        String s = "WRANGLE BY ENRICH_TIMESTAMP(f1.Date, '%d/%c/%Y %H:%i:%s', \"01/02/2018\"), ENRICH_TIMESTAMP(f2.Date, '%d/%c/%Y %H:%i:%s', \"01/02/2018\"), (f1 UNION f2)";
        D2wlLexer lexer = new D2wlLexer(CharStreams.fromString(s));
        D2wlParser parser = new D2wlParser(new CommonTokenStream(lexer));

        Wrangle_clauseContext wrangleClause = parser.wrangle_clause();
        List<Wrangle_operationContext> wrangleOperations = wrangleClause.wrangle_list().wrangle_operation();
        for (Wrangle_operationContext wo : wrangleOperations) {
            if (wo.function_call() != null) {
                System.out.println("Function name: " + wo.function_call().function_name().getText());
                for (Function_argumentContext l : wo.function_call().function_argument()) {
                    System.out.println("Literal argument: " + l.getText());
                }
            } else {
                System.out.println("Union operation: " + "file 1: " + wo.union_operation().file_name(0).getText() + " file 2: " + wo.union_operation().file_name(1).getText());
            }
        }
    }
}
