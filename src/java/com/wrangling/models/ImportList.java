package com.wrangling.models;

import com.google.gson.JsonArray;

import java.util.List;

public class ImportList {
    private List<String> imports;

    public ImportList(List<String> imports) {
        this.imports = imports;
    }

    public List<String> getImportsList() {
        return imports;
    }

    public JsonArray getJson() {
        JsonArray json = new JsonArray();
        for (String singleImport : imports) {
            json.add(singleImport);
        }
        return json;
    }
}
