package com.wrangling.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Condition {
    private ConditionOperand left;
    private ConditionOperand right;
    private ConditionOperator operator;


    public Condition(ConditionOperand left, ConditionOperand right, ConditionOperator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public ConditionOperand getLeft() {
        return left;
    }

    public ConditionOperand getRight() {
        return right;
    }

    public ConditionOperator getOperator() {
        return operator;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("type", new JsonPrimitive("simple"));
        json.add("left", left.getJson());
        json.add("right", right.getJson());
        json.add("comparison", operator.getJson());
        return json;
    }

    public String toString() {
        return String.format("%s %s %s", left.toString(), operator.toString(), right.toString());
    }
}
