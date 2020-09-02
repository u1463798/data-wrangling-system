package com.wrangling.models;

public class UnionOperation {
    private String firstFile;
    private String secondFile;

    public UnionOperation(String firstFile, String secondFile) {
        this.firstFile = firstFile;
        this.secondFile = secondFile;
    }

    public String getFirstFile() {
        return firstFile;
    }

    public String getSecondFile() {
        return secondFile;
    }

    public String toString() {
        return firstFile + " UNION " + secondFile;
    }
}
