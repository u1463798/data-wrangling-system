package com.wrangling.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class FromFile extends File {
    private String alias;

    public FromFile(String name, String extension, String alias) {
        super(name, extension);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public String toString() {
        return alias;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("name", new JsonPrimitive(this.getFullName()));
        json.add("alias", new JsonPrimitive(this.alias));
        json.add("type", new JsonPrimitive(this.extension));
        return json;
    }
}
