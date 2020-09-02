package com.wrangling.models;

public class GroupClause {
    private FunctionCall functionCall;

    public GroupClause(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }
}
