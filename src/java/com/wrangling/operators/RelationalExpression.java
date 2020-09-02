package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.ImportList;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class RelationalExpression {
    private RelationalOperator root;

    public RelationalExpression(RelationalOperator root) {
        this.root = root;
    }

    public RelationalOperator getRoot() {
        return root;
    }

    public void numberNodes(int start) {
        int total = root.numberNodes(start);
        root.normalizeId(total);
    }

    public void traverse() {
        root.traverse();
    }

    public void output(boolean optimized) throws Exception {
        String res = this.toString();
        //String fileName = ((WriteOperator) root).getOutputFile().getUrl() + ".dwl";
        String fileName = "query1.dwl";
        if (optimized) {
            String[] parts = fileName.split("\\.");
            fileName = "query1_optimised.dwl";
        }
        PrintWriter out = new PrintWriter(fileName);
        out.println(res);
        out.close();
    }

    public void outputJson(ImportList imports) throws Exception {
        JsonObject json = getJson(imports);
        String name = json.get("query").getAsString();
        PrintWriter out = new PrintWriter(name);
        out.println(json.toString());
        out.close();
    }

    public JsonObject getJson(ImportList imports) {
        List<RelationalOperator> operators = collectOperators();
        JsonObject json = new JsonObject();
        JsonArray operatorsArray = new JsonArray();
        for (RelationalOperator op : operators) {
            operatorsArray.add(op.getJson());
        }
        json.add("query", new JsonPrimitive("query2.json"));
        List<Integer> seq = buildSequence();
        JsonArray sequenceJson = new JsonArray();
        for (int i = seq.size() - 1; i >= 0; i--) {
            sequenceJson.add(seq.get(i));
        }
        json.add("imports", imports == null ? new JsonArray() : imports.getJson());
        json.add("sequence", sequenceJson);
        json.add("operators", operatorsArray);
        return json;
    }

    private List<Integer> buildSequence() {
        List<Integer> seq = new ArrayList<>();
        Deque<RelationalOperator> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            RelationalOperator current = stack.pop();
            seq.add(current.id);
            List<RelationalOperator> dependencies = current.getDependencies();
            for (int i = dependencies.size() - 1; i >= 0; i--) {
                stack.push(dependencies.get(i));
            }
        }
        return seq;
    }

    public List<RelationalOperator> collectOperators() {
        List<RelationalOperator> operators = new ArrayList<>();
        Deque<RelationalOperator> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            RelationalOperator top = q.poll();
            operators.add(top);
            q.addAll(top.getDependencies());
        }
        Collections.reverse(operators);
        return operators;
    }

    @Override
    public String toString() {
        return root.toString(0);
    }
}
