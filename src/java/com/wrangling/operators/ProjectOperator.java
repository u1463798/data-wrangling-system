package com.wrangling.operators;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wrangling.models.File;
import com.wrangling.models.FromFile;

import java.util.Arrays;
import java.util.List;

public class ProjectOperator extends RelationalOperator {
    private File file;
    private List<String> columnsToProject;

    public ProjectOperator(File file, List<String> columnsToProject) {
        this.file = file;
        this.columnsToProject = columnsToProject;
    }

    public File getFile() {
        return file;
    }

    public List<String> getColumnsToProject() {
        return columnsToProject;
    }

    @Override
    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(id));
        json.add("operator", new JsonPrimitive("project"));
        String alias = file == null ? "" : ((FromFile) file).getAlias();
        json.add("file", new JsonPrimitive(alias));
        JsonArray columnsJson = new JsonArray();
        for (String col : columnsToProject) {
            columnsJson.add(col);
        }
        json.add("columns", columnsJson);
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
        String s = indent + "project(\n";
        s += dependencies.get(0).toString(tabs + 1);
        s += ",\n";
        String list = columnsToProject.get(0);
        for (int i = 1; i < columnsToProject.size(); i++) {
            list += ", " + columnsToProject.get(i);
        }
        String conditions = String.format("<%s>", list);
        s += innerIndent + conditions + "\n";
        s += indent + ')';
        return s;
    }
}
