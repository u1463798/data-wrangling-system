package com.wrangling.operators;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.FunctionCall;

import java.util.Arrays;

public class GroupOperator extends RelationalOperator{
    private FunctionCall functionCall;

    public GroupOperator(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    @Override
    public String toString(int tabs) {
        char tab = '\t';
        char[] leadingTabs = new char[tabs];
        Arrays.fill(leadingTabs, tab);
        String indent = new String(leadingTabs);
        String innerIndent = indent + tab;
        String s = indent + "group_by(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += innerIndent + functionCall.toString() + ",\n";
        s += indent + ')';
        return s;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("group_by"));
        json.add("function", functionCall.getJson());
        json.add("dependencies", getDependenciesJson());
        return json;
    }
}
