package com.wrangling.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

public class FunctionCall {
    private String functionName;
    private List<FunctionArgument> functionArguments;

    public FunctionCall(String name, List<FunctionArgument> arguments) {
        functionName = name;
        functionArguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<FunctionArgument> getFunctionArguments() {
        return functionArguments;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("name", new JsonPrimitive(functionName));
        JsonArray argumentsJson = new JsonArray();
        for (FunctionArgument fa : functionArguments) {
            argumentsJson.add(fa.getJson());
        }
        json.add("arguments", argumentsJson);
        return json;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(functionName);
        sb.append("(");
        if (functionArguments.size() > 0) {
            sb.append(functionArguments.get(0).toString());
        }
        for (int i = 1; i < functionArguments.size(); i++) {
            sb.append(",");
            sb.append(functionArguments.get(i));
        }
        sb.append(")");
        return sb.toString();
    }
}
