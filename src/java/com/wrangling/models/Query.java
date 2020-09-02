package com.wrangling.models;

public class Query {
    private ImportList imports;
    private SelectClause selectClause;
    private FromClause fromClause;
    private ToClause toClause;
    private WhereClause whereClause;
    private WrangleClause wrangleClause;
    private GroupClause groupClause;

    public Query(ImportList importList, SelectClause selectClause, FromClause fromClause, ToClause toClause, WhereClause whereClause, WrangleClause wrangleClause, GroupClause groupClause) {
        this.imports = importList;
        this.selectClause = selectClause;
        this.fromClause = fromClause;
        this.toClause = toClause;
        this.whereClause = whereClause;
        this.wrangleClause = wrangleClause;
        this.groupClause = groupClause;
    }

    public ImportList getImports() {
        return imports;
    }

    public SelectClause getSelectClause() {
        return selectClause;
    }

    public FromClause getFromClause() {
        return fromClause;
    }

    public ToClause getToClause() {
        return toClause;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public WrangleClause getWrangleClause() {
        return wrangleClause;
    }

    public GroupClause getGroupClause() {
        return groupClause;
    }
}
