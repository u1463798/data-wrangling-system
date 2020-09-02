package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.Condition;
import com.wrangling.models.File;
import com.wrangling.models.FromFile;

import java.util.Arrays;
import java.util.List;

public class SpatialJoinOperator extends RelationalOperator{
    private File fileOne;
    private File fileTwo;
    private List<Condition> conditions;
    private String resultingFile;

    public SpatialJoinOperator(File fileOne, File fileTwo, List<Condition> conditions, String resultingFile) {
        this.fileOne = fileOne;
        this.fileTwo = fileTwo;
        this.conditions = conditions;
        this.resultingFile = resultingFile;
    }

    public File getFileOne() {
        return fileOne;
    }

    public File getFileTwo() {
        return fileTwo;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public String getResultingFile() {
        return resultingFile;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("spatial_temporal_join"));
        json.add("first", new JsonPrimitive(((FromFile)fileOne).getAlias()));
        json.add("second", new JsonPrimitive(((FromFile)fileTwo).getAlias()));
        JsonArray conditionsJson = new JsonArray();
        for (Condition c : conditions) {
            conditionsJson.add(c.getJson());
        }
        json.add("conditions", conditionsJson);
        json.add("resulting", new JsonPrimitive(resultingFile));
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
        String s = indent + "spatial_temporal_join(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += dependencies.get(1).toString(tabs + 1);
        for (Condition c : conditions) {
            s += ",\n" + innerIndent + c.toString();
        }
        s += '\n' + indent + ')';
        return s;
    }
}
