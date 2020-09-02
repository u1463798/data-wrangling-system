package com.wrangling.models;

public class SelectClause {
    private FunctionCall functionCall;

    public SelectClause(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }
}
