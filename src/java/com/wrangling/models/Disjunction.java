package com.wrangling.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Disjunction extends Condition {
    private ConditionOperand secondLeft;
    private ConditionOperand secondRight;
    private ConditionOperator secondOperator;
    private Condition firstCondition;
    private Condition secondCondition;

    public Disjunction(ConditionOperand left, ConditionOperand right, ConditionOperator operator, ConditionOperand secondLeft, ConditionOperand secondRight, ConditionOperator secondOperator) {
        super(left, right, operator);
        this.secondLeft = secondLeft;
        this.secondRight = secondRight;
        this.secondOperator = secondOperator;
        firstCondition = new Condition(left, right, operator);
        secondCondition = new Condition(secondLeft, secondRight, secondOperator);
    }

    public Disjunction(Condition first, Condition second) {
        super(first.getLeft(), first.getRight(), first.getOperator());
        this.secondLeft = second.getLeft();
        this.secondRight = second.getRight();
        this.secondOperator = second.getOperator();
        this.firstCondition = first;
        this.secondCondition = second;
    }

    public ConditionOperand getSecondLeft() {
        return secondLeft;
    }

    public ConditionOperand getSecondRight() {
        return secondRight;
    }

    public ConditionOperator getSecondOperator() {
        return secondOperator;
    }

    public Condition getFirstCondition() {
        return firstCondition;
    }

    public Condition getSecondCondition() {
        return secondCondition;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("type", new JsonPrimitive("disjunction"));
        JsonArray atomsArray = new JsonArray();
        atomsArray.add(firstCondition.getJson());
        atomsArray.add(secondCondition.getJson());
        json.add("conditions", atomsArray);
        return json;
    }

    @Override
    public boolean equals(Object a) {
        if (!(a instanceof Disjunction)) {
            return false;
        }
        return this.firstCondition.equals(((Disjunction) a).getFirstCondition()) && this.secondCondition.equals(((Disjunction) a).getSecondCondition());
    }

    public String toString() {
        return String.format("%s OR %s", firstCondition.toString(), secondCondition.toString());
    }
}
