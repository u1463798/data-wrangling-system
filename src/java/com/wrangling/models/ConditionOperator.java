package com.wrangling.models;

import com.google.gson.JsonPrimitive;

public class ConditionOperator {
    private Operator operator;
    private String operatorString;

    public ConditionOperator(String operatorString) {
        Operator op;
        switch (operatorString) {
            case "=": op = Operator.EQ;
                break;
            case ">": op = Operator.GT;
                break;
            case "<": op = Operator.LT;
                break;
            case "<=": op = Operator.LE;
                break;
            case ">=": op = Operator.GE;
                break;
            case "~": op = Operator.TILDE;
                break;
                default: op = Operator.EQ;
        }
        this.operator = op;
        this.operatorString = operatorString;
    }

    public Operator getOperator() {
        return operator;
    }

    public JsonPrimitive getJson() {
        return new JsonPrimitive(operatorString);
    }

    public String toString() {
        return this.operatorString;
    }
}
