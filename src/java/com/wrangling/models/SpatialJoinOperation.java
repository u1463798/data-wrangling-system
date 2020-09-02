package com.wrangling.models;

import java.util.List;

public class SpatialJoinOperation {
    private String firstFile;
    private String secondFile;
    private List<Condition> conditions;
    private String resultingFileName;

    public SpatialJoinOperation(String firstFile, String secondFile, List<Condition> conditions, String resultingFileName) {
        this.firstFile = firstFile;
        this.secondFile = secondFile;
        this.conditions = conditions;
        this.resultingFileName = resultingFileName;
    }

    public String getFirstFile() {
        return firstFile;
    }

    public String getSecondFile() {
        return secondFile;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public String getResultingFileName() {
        return resultingFileName;
    }
}
