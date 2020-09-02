package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RelationalOperator {
    protected int id;

    protected List<RelationalOperator> dependencies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public List<RelationalOperator> getDependencies() {
        return dependencies;
    }

    public void addDependency(RelationalOperator op) {
        dependencies.add(op);
    }

    public void clearDependencies() {
        this.dependencies.clear();
    }

    public abstract String toString(int tabs);

    public int numberNodes(int i) {
        this.id = i;
        int next = i + 1;
        List<RelationalOperator> reversedDependencies = new ArrayList<>(dependencies);
        Collections.reverse(reversedDependencies);
        for (RelationalOperator r : reversedDependencies) {
            next = r.numberNodes(next);
        }
        return next;
    }

    public void normalizeId(int highest) {
        id = highest - id;
        for (RelationalOperator r : dependencies) {
            r.normalizeId(highest);
        }
    }

    public abstract JsonObject getJson();

    public JsonArray getDependenciesJson() {
        JsonArray dependenciesJson = new JsonArray();
        for (RelationalOperator d : dependencies) {
            dependenciesJson.add(new JsonPrimitive(d.id));
        }
        return dependenciesJson;
    }

    public void traverse() {
        System.out.print(this.id + " ");
        for (RelationalOperator o : dependencies) {
            o.traverse();
        }
        if (dependencies.isEmpty()) {
            System.out.print("X ");
        }
    }
}
