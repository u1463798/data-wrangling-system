package com.wrangling.tests;

import static com.wrangling.antlr.D2wlParser.*;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;

public class TestSelect {
    public static void main(String[] args) {
        D2wlLexer lexer = new D2wlLexer(CharStreams.fromString("SELECT JT(LinkLength, AVG(Speed_in_MPH))"));
        D2wlParser parser = new D2wlParser(new CommonTokenStream(lexer));

        Select_clauseContext selectClause = parser.select_clause();
        System.out.println("The select statement: " + selectClause.getText());
        Function_callContext outerFunctionCall = selectClause.select_argument().function_call();
        System.out.println("The outer function call: " + outerFunctionCall.getText());
        Function_nameContext outerFunctionName = outerFunctionCall.function_name();
        System.out.println("The outer function name: " + outerFunctionName.getText());
        Literal_argumentContext outerFunctionLiteralArgument = outerFunctionCall.function_argument(0).literal_argument();
        System.out.println("The outer function literal argument: " + outerFunctionLiteralArgument.getText());
        Function_callContext innerFunctionCall = outerFunctionCall.function_argument(1).function_call();
        System.out.println("The inner function call: " + innerFunctionCall.getText());
        Function_nameContext innerFucntionName = innerFunctionCall.function_name();
        System.out.println("The inner function name: " + innerFucntionName.getText());
        Literal_argumentContext innerFunctionLiteralArgument = innerFunctionCall.function_argument(0).literal_argument();
        System.out.println("The inner function literal argument: " + innerFunctionLiteralArgument.getText());
    }
}
