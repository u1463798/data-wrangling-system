package com.wrangling.models;

import java.util.List;

public class WhereClause {
    private List<Condition> conditions;

    public WhereClause(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

}
