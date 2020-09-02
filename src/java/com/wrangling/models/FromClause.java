package com.wrangling.models;

import java.util.List;

public class FromClause {
    private String fromString;
    private List<FromFile> files;

    public FromClause(String fromString, List<FromFile> files) {
        this.fromString = fromString;
        this.files = files;
    }

    public String getFromString() {
        return fromString;
    }

    public List<FromFile> getFiles() {
        return files;
    }
}
