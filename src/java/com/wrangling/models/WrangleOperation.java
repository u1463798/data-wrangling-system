package com.wrangling.models;

public class WrangleOperation {
    private WrangleOperationType type;
    private FunctionCall functionCall;
    private UnionOperation unionOperation;
    private SpatialJoinOperation spatialJoinOperation;

    public WrangleOperation(WrangleOperationType type, FunctionCall functionCall, UnionOperation unionOperation, SpatialJoinOperation spatialJoinOperation) {
        this.type = type;
        this.functionCall = functionCall;
        this.unionOperation = unionOperation;
        this.spatialJoinOperation = spatialJoinOperation;
    }

    public WrangleOperationType getType() {
        return type;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public UnionOperation getUnionOperation() {
        return unionOperation;
    }

    public SpatialJoinOperation getSpatialJoinOperation() {
        return spatialJoinOperation;
    }

    public String toString() {
        if (type == WrangleOperationType.FUNCTION_CALL) {
            return functionCall.toString();
        } else if (type == WrangleOperationType.UNION){
            return unionOperation.toString();
        } else {
            return spatialJoinOperation.toString();
        }
    }
}
