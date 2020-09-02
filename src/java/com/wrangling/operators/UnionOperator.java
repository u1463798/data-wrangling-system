package com.wrangling.operators;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.File;
import com.wrangling.models.FromFile;

import java.util.Arrays;

public class UnionOperator extends RelationalOperator {
    private File fileOne;
    private File fileTwo;

    public UnionOperator(File fileOne, File fileTwo) {
        this.fileOne = fileOne;
        this.fileTwo = fileTwo;
    }

    public File getFileOne() {
        return fileOne;
    }

    public File getFileTwo() {
        return fileTwo;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("union"));
        json.add("first", new JsonPrimitive(((FromFile)fileOne).getAlias()));
        json.add("second", new JsonPrimitive(((FromFile)fileTwo).getAlias()));
        json.add("dependencies", getDependenciesJson());
        return json;
    }

    @Override
    public String toString(int tabs) {
        char tab = '\t';
        char[] leadingTabs = new char[tabs];
        Arrays.fill(leadingTabs, tab);
        String indent = new String(leadingTabs);
        String s = indent + "union(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        s += dependencies.get(1).toString(tabs + 1);
        s += '\n' + indent + ')';
        return s;
    }
}
