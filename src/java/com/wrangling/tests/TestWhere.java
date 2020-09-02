package com.wrangling.tests;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;
import com.wrangling.antlr.D2wlParser.AtomContext;

import java.util.ArrayList;
import java.util.List;

public class TestWhere {
    public static void main(String[] args) {
        String s  = "WHERE f1.Direction_Name = 'North' AND DAYOFWEEK(DATE(f1.Date)) = '6' AND TIME(f1.Date) >= '17:00:00' AND TIME(f1.Date) < '18:00:00' AND f2.Direction_Name = 'NorthEast' AND DAYOFWEEK(DATE(f2.Date)) = '6' AND TIME(f2.Date) >= '17:00:00' AND TIME(f2.Date) < '18:00:00' AND (f1.Site_ID = f3.StartSite_ID OR f2.Site_ID = f3.EndSite_ID) AND f3.StartSite_ID = '000000001083' AND f3.EndSite_ID = '000000001415'";
        D2wlLexer lexer = new D2wlLexer(CharStreams.fromString(s));
        D2wlParser parser = new D2wlParser(new CommonTokenStream(lexer));

        D2wlParser.Condition_listContext conditionList = parser.where_clause().condition_list();
        List<D2wlParser.AtomContext> atoms = new ArrayList<>();
        List<String> connectors = new ArrayList<>();
        while (conditionList != null) {
            D2wlParser.FormulaContext formula = conditionList.formula();
            if (formula.atom() != null) {
                atoms.add(formula.atom());
            } else {
                atoms.add(formula.disjunction().atom(0));
                atoms.add(formula.disjunction().atom(1));
                connectors.add(formula.disjunction().OR().getText());
            }
            if (conditionList.AND() != null) {
                connectors.add(conditionList.AND().getText());
            }
            conditionList = conditionList.condition_list();
        }
        for (AtomContext atom : atoms) {
            System.out.println(atom.getText());
        }
        for (String con : connectors) {
            System.out.println(con);
        }
    }
}
