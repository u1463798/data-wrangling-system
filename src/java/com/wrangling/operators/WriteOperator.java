package com.wrangling.operators;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.FunctionCall;
import com.wrangling.models.ToFile;

import java.util.Arrays;

public class WriteOperator extends RelationalOperator{
    private ToFile outputFile;
    private FunctionCall functionCallToWrite;

    public WriteOperator(ToFile outputFile, FunctionCall functionCall) {
        this.outputFile = outputFile;
        this.functionCallToWrite = functionCall;
    }

    public ToFile getOutputFile() {
        return outputFile;
    }

    public FunctionCall getFunctionCallToWrite() {
        return functionCallToWrite;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("write"));
        json.add("function", functionCallToWrite.getJson());
        json.add("file", new JsonPrimitive(outputFile.getFullName()));
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
        String s = indent + "write(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += innerIndent + functionCallToWrite.toString() + ",\n";
        s += innerIndent + outputFile.getFullName() + '\n';
        s += indent + ')';
        return s;
    }
}
