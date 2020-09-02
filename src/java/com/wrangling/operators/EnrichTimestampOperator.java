package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.File;
import com.wrangling.models.FunctionArgument;
import com.wrangling.models.FunctionCall;

import java.util.Arrays;
import java.util.List;

public class EnrichTimestampOperator extends WranglingOperator {
    private File file;
    private List<FunctionArgument> arguments;
    /*
    public EnrichTimestampOperator(File file, List<FunctionArgument> arguments, FunctionCall functionCall) {
        this.file = file;
        this.arguments = arguments;
        this.functionCall = functionCall;
    }
    */

    public EnrichTimestampOperator(FunctionCall functionCall, File file) {
        super(functionCall);
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public List<FunctionArgument> getArguments() {
        return arguments;
    }


    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("enrich_timestamp"));
        JsonArray argumentsJson = new JsonArray();
        for (FunctionArgument arg : arguments) {
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
        String s = indent + "enrich_timestamp(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += innerIndent + arguments.get(0).getFileColumn().getColumn() + ",\n";
        s += innerIndent + arguments.get(1).getLiteralString() + ",\n";
        s += innerIndent + arguments.get(2).getLiteralString() + '\n';
        s += indent + ')';
        return s;
    }
}
