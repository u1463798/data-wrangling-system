package com.wrangling.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class FunctionArgument {
    private FunctionArgumentType type;
    private String literalString;
    private FunctionCall functionCall;
    private FileColumn fileColumn;

    public FunctionArgument(FunctionArgumentType type, String literalString, FunctionCall functionCall, FileColumn fileColumn) {
        this.type = type;
        switch (type) {
            case COLUMN:        this.fileColumn = fileColumn;
                                break;
            case LITERAL:       this.literalString = literalString;
                                break;
            case FUNCTION_CALL: this.functionCall = functionCall;
                                break;
            default:            this.literalString = literalString;
        }
    }

    public FunctionArgumentType getType() {
        return type;
    }

    public String getLiteralString() {
        return literalString;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public FileColumn getFileColumn() {
        return fileColumn;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        switch (type) {
            case COLUMN:        json.add("type", new JsonPrimitive("column"));
                                json.add("value", fileColumn.getJson());
                                break;
            case LITERAL:       json.add("type", new JsonPrimitive("literal"));
                                json.add("value", new JsonPrimitive(literalString));
                                break;
            case FUNCTION_CALL: json.add("type", new JsonPrimitive("function"));
                                json.add("value", functionCall.getJson());
                                break;
            default:            json.add("type", new JsonPrimitive("none"));
                                json.add("value", new JsonPrimitive(""));
        }
        return json;
    }

    public String toString() {
        if (type == FunctionArgumentType.LITERAL) {
            return literalString;
        } else if (type == FunctionArgumentType.COLUMN) {
            return fileColumn.toString();
        } else {
            return functionCall.toString();
        }
    }
}
