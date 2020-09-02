package com.wrangling.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class FileColumn {
    private String file;
    private String column;

    public FileColumn(String file, String column) {
        this.file = file;
        this.column = column;
    }

    public String getFile() {
        return file;
    }

    public String getColumn() {
        return column;
    }

    public JsonObject getJson() {
        JsonObject json = new JsonObject();
        json.add("file", new JsonPrimitive(file));
        json.add("column", new JsonPrimitive(column));
        return json;
    }

    @Override
    public boolean equals(Object a) {
        if (!(a instanceof FileColumn)) {
            return false;
        }
        return this.file.equals(((FileColumn) a).getFile()) && this.column.equals(((FileColumn) a).getColumn());
    }

    public String toString() {
        return file + "." + column;
    }
}
