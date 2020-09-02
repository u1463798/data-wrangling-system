package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.Condition;
import com.wrangling.models.FromFile;

import java.util.Arrays;
import java.util.List;

public class SelectOperator extends RelationalOperator {
    private FromFile file;
    private List<Condition> conditions;

    public SelectOperator(FromFile file, List<Condition> conditions) {
        this.file = file;
        this.conditions = conditions;
    }

    public FromFile getFile() {
        return file;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("select"));
        json.add("file", new JsonPrimitive(file.getAlias()));
        JsonArray conditionsJson = new JsonArray();
        for (Condition c : conditions) {
            conditionsJson.add(c.getJson());
        }
        json.add("conditions", conditionsJson);
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
        String s = indent + "select(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += innerIndent + '<' + conditions.get(0).toString();
        for (int i = 1; i < conditions.size(); i++) {
            s += " AND\n" + innerIndent + conditions.get(i).toString();
        }
        s += ">\n";
        s += indent + ')';
        return s;
    }
}
