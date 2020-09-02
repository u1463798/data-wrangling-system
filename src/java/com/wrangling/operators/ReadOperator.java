package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.FromFile;

import java.util.Arrays;

public class ReadOperator extends RelationalOperator {
    private FromFile file;

    public ReadOperator(FromFile file) {
        this.file = file;
    }

    public FromFile getFile() {
        return file;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("read"));
        json.add("file", file.getJson());
        json.add("dependencies", new JsonArray());
        return json;
    }

    @Override
    public String toString(int tabs) {
        char tab = '\t';
        char[] leadingTabs = new char[tabs];
        Arrays.fill(leadingTabs, tab);
        String indent = new String(leadingTabs);
        return String.format(indent + "read(%s)", file.getAlias());
    }
}
