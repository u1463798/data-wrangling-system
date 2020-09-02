package com.wrangling.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ConditionOperand {
    private OperandType type;
    private FunctionCall functionCall;
    private FileColumn fileColumn;
    private String literal;

    public ConditionOperand(OperandType type, FunctionCall functionCall, FileColumn fileColumn, String literal) {
        this.type = type;
        switch (type) {
            case COLUMN:            this.fileColumn = fileColumn;
                                    break;
            case FUNCTION_CALL:     this.functionCall = functionCall;
                                    break;
            case LITERAL:           this.literal = literal;
                                    break;
            default:                this.fileColumn = fileColumn;
        }
    }

    public OperandType getType() {
        return type;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public FileColumn getFileColumn() {
        return fileColumn;
    }

    public String getLiteral() {
        return literal;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        switch (type) {
            case COLUMN:        json.add("type", new JsonPrimitive("column"));
                                json.add("value", fileColumn.getJson());
                                break;
            case LITERAL:       json.add("type", new JsonPrimitive("literal"));
                                json.add("value", new JsonPrimitive(literal));
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
        if (type == OperandType.COLUMN) {
            return fileColumn.toString();
        } else if (type == OperandType.LITERAL) {
            return literal;
        } else {
            return functionCall.toString();
        }
    }
}
