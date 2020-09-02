package com.wrangling.models;

public class ToClause {
    private ToFile toFile;

    public ToClause(ToFile toFile) {
        this.toFile = toFile;
    }

    public ToFile getToFile() {
        return toFile;
    }
}
