package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.FunctionArgument;
import com.wrangling.models.FunctionCall;

import java.util.Arrays;

public class WranglingOperator extends RelationalOperator {
    protected FunctionCall functionCall;

    public WranglingOperator(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("wrangling"));
        json.add("type", new JsonPrimitive("function_call"));
        json.add("function_name", new JsonPrimitive(functionCall.getFunctionName()));
        JsonArray argumentsJson = new JsonArray();
        for (FunctionArgument arg : functionCall.getFunctionArguments()) {
            argumentsJson.add(arg.getJson());
        }
        json.add("arguments", argumentsJson);
        json.add("dependencies", getDependenciesJson());
        return json;
    }

    @Override
    public String toString(int tabs) {
        char tab = '\t';
        char[] leadingTabs = new char[tabs];
        Arrays.fill(leadingTabs, tab);
        String indent = new String(leadingTabs);
        String innerIndent = indent + tab;
        String s = indent + functionCall.getFunctionName().toLowerCase() +"(\n";
        s += dependencies.get(0).toString(tabs + 1);
        for (FunctionArgument fa : functionCall.getFunctionArguments()) {
            s += ",\n" + innerIndent + fa.toString();
        }
        s += '\n' + indent + ')';
        return s;
    }
}
