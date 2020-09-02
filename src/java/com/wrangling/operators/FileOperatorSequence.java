package com.wrangling.operators;


import java.util.LinkedList;

import com.wrangling.models.File;

public class FileOperatorSequence {
    private File file;
    private LinkedList<RelationalOperator> operators;

    public FileOperatorSequence(File file) {
        this.file = file;
        operators = new LinkedList<>();
    }

    public File getFile() {
        return file;
    }

    public boolean addOperator(RelationalOperator operator) {
        operators.add(operator);
        return true;
    }

    public RelationalOperator getLast() {
        return operators.getLast();
    }

    public RelationalOperator getFirst() {
        return operators.getFirst();
    }

    public LinkedList<RelationalOperator> getOperators() {
        return operators;
    }

    public String toString(int index) {
        return operators.get(index - 1).toString();
    }
}
