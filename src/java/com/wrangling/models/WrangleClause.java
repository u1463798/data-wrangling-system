package com.wrangling.models;

import java.util.List;

public class WrangleClause {
    private List<WrangleOperation> wrangleOperations;

    public WrangleClause(List<WrangleOperation> wrangleOperations) {
        this.wrangleOperations = wrangleOperations;
    }

    public List<WrangleOperation> getWrangleOperations() {
        return wrangleOperations;
    }
}
