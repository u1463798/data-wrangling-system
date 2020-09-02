package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.Condition;
import com.wrangling.models.FromFile;

import java.util.Arrays;
import java.util.List;

public class JoinOperator extends RelationalOperator {
    private List<FromFile> filesToJoin;
    private Condition joinCondition;

    public JoinOperator(List<FromFile> filesToJoin, Condition joinCondition) {
        this.filesToJoin = filesToJoin;
        this.joinCondition = joinCondition;
    }

    public List<FromFile> getFilesToJoin() {
        return filesToJoin;
    }

    public Condition getJoinCondition() {
        return joinCondition;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("join"));
        JsonArray filesJson = new JsonArray();
        for (FromFile ff : filesToJoin) {
            filesJson.add(ff.getAlias());
        }
        json.add("files", filesJson);
        json.add("key", joinCondition.getJson());
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
        String s = indent + "join(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += dependencies.get(1).toString(tabs + 1);
        s += ",\n";
        s += innerIndent + joinCondition.toString();
        s += '\n' + indent + ')';
        return s;
    }
}
