package com.wrangling.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wrangling.models.Condition;
import com.wrangling.models.Disjunction;
import com.wrangling.models.File;
import com.wrangling.models.FileColumn;
import com.wrangling.models.FromClause;
import com.wrangling.models.FromFile;
import com.wrangling.models.FunctionArgument;
import com.wrangling.models.FunctionArgumentType;
import com.wrangling.models.FunctionCall;
import com.wrangling.models.GroupClause;
import com.wrangling.models.OperandType;
import com.wrangling.models.Query;
import com.wrangling.models.SelectClause;
import com.wrangling.models.ToClause;
import com.wrangling.models.ToFile;
import com.wrangling.models.WhereClause;
import com.wrangling.models.WrangleClause;
import com.wrangling.models.WrangleOperation;
import com.wrangling.models.WrangleOperationType;
import com.wrangling.operators.FileOperatorSequence;
import com.wrangling.operators.GroupOperator;
import com.wrangling.operators.JoinOperator;
import com.wrangling.operators.ProjectOperator;
import com.wrangling.operators.ReadOperator;
import com.wrangling.operators.RelationalExpression;
import com.wrangling.operators.RelationalOperator;
import com.wrangling.operators.SelectOperator;
import com.wrangling.operators.SpatialJoinOperator;
import com.wrangling.operators.UnionOperator;
import com.wrangling.operators.WranglingOperator;
import com.wrangling.operators.WriteOperator;

public class QueryMapper {

    private Map<String, FromFile> aliasesMap;
    private Map<FromFile, FileOperatorSequence> sequenceMap;
    private int initialFileCount;
    private int currentFilesCount;
    private boolean hasSingleRoot;
    private RelationalOperator root;

    private List<Condition> singleFileConditions;
    private List<Condition> multiFileConditions;
    private List<Disjunction> disjunctions;
    private Map<FromFile, List<WrangleOperation>> wrangleOperationsForFile;
    private List<WrangleOperation> multiFileWrangleOperations;
    private Map<FromFile, List<Condition>> conditionsForFile;

    public RelationalExpression mapQuery(Query query) throws  Exception{
        // get the clauses of the query
        SelectClause selectClause = query.getSelectClause();
        FromClause fromClause = query.getFromClause();
        ToClause toClause = query.getToClause();
        WhereClause whereClause = query.getWhereClause();
        WrangleClause wrangleClause = query.getWrangleClause();
        GroupClause groupClause = query.getGroupClause();

        initialFileCount = fromClause.getFiles().size();
        currentFilesCount = initialFileCount;
        hasSingleRoot = false;
        root = null;

        // initialize aliases
        aliasesMap = initializeAliasesMap(fromClause);

        // initialize the condition lists
        singleFileConditions = new ArrayList<>();
        multiFileConditions = new ArrayList<>();
        disjunctions = new ArrayList<>();
        sortConditions(whereClause, singleFileConditions, multiFileConditions, disjunctions);
        // initialize wrangle operations to files
        wrangleOperationsForFile = associateWranglingOperationsWithFiles(wrangleClause);
        // group the remaining operations
        multiFileWrangleOperations = selectRemainingWrangleOperations(wrangleClause);
        // associate single conditions with files
        conditionsForFile = associateSingleConditionsWithFiles(fromClause, singleFileConditions);
        // initialize linked lists
        sequenceMap = initializeSequences(fromClause);
        // create read operators for file
        createReadOperators();
        // create wrangling operators for file
        createSingleFileWranglingOperators(wrangleOperationsForFile);
        // create select operators for file
        createSelectOperators(conditionsForFile);
        // create operators for unions
        createMultiFileWranglingOperators(multiFileWrangleOperations, WrangleOperationType.UNION);
        // create potential joins
        createJoinOperators(multiFileConditions, disjunctions);
        //create operators for spatial joins
        createMultiFileWranglingOperators(multiFileWrangleOperations, WrangleOperationType.SPATIAL_JOIN);
        // create project operators
        createProjectOperators(selectClause);
        // create group operators
        createGroupOperators(groupClause);
        // create write operator
        createWriteOperator(selectClause, toClause);

        // create operators expression
        RelationalExpression expression = new RelationalExpression(root);

        //Debugging only
//        for (Map.Entry<FromFile, FileOperatorSequence> s : sequenceMap.entrySet()) {
//            FileOperatorSequence seq = s.getValue();
//            System.out.println("For file: " + s.getKey());
//            for (RelationalOperator r : seq.getOperators()) {
//                System.out.println(r.getClass().getSimpleName());
//            }
//            System.out.println("===================");
//        }
        //
        //expression.numberNodes(1);
        //expression.output(false);
        performOptimization();
        //expression.numberNodes(1);
        //expression.output(true);
        //expression.outputJson(query.getImports());
        return expression;
    }

    private Map<FromFile, FileOperatorSequence> initializeSequences(FromClause fromClause) {
        List<FromFile> files = fromClause.getFiles();
        Map<FromFile, FileOperatorSequence> sequenceMap = new HashMap<>();
        for (FromFile f : files) {
            FileOperatorSequence seq = new FileOperatorSequence(f);
            sequenceMap.put(f, seq);
        }
        return sequenceMap;
    }

    private Map<String, FromFile> initializeAliasesMap(FromClause fromClause) {
        Map<String, FromFile> aliases = new HashMap<>();
        List<FromFile> files = fromClause.getFiles();
        for (FromFile f : files) {
            aliases.put(f.getAlias(), f);
        }
        return aliases;
    }

    private void createReadOperators() {
        for (FromFile f : sequenceMap.keySet()) {
            FileOperatorSequence seq = sequenceMap.get(f);
            ReadOperator read = new ReadOperator(f);
            seq.addOperator(read);
        }
    }

    private void createSingleFileWranglingOperators(Map<FromFile, List<WrangleOperation>> wrangleOperationsForFile) throws Exception {
        for (FromFile file : sequenceMap.keySet()) {
            FileOperatorSequence seq = sequenceMap.get(file);
            List<WrangleOperation> operations = wrangleOperationsForFile.getOrDefault(file, new ArrayList<>());
            for (WrangleOperation operation : operations) {
                WranglingOperator wo = new WranglingOperator(operation.getFunctionCall());
                wo.addDependency(seq.getLast());
                updateAllDependencySequences(wo);
            }
        }
    }

    private void createSelectOperators(Map<FromFile, List<Condition>> conditionsForFile) {
        for (FromFile f : sequenceMap.keySet()) {
            FileOperatorSequence seq = sequenceMap.get(f);
            List<Condition> conditions = conditionsForFile.get(f);
            if (!conditions.isEmpty()) {
                SelectOperator select = new SelectOperator(f, conditions);
                select.addDependency(seq.getLast());
                //seq.addOperator(select);
                updateAllDependencySequences(select);
            }
        }
    }

    private void createMultiFileWranglingOperators(List<WrangleOperation> multiFileWrangleOperations, WrangleOperationType type) {
        if (type == WrangleOperationType.UNION) {
            createUnions(multiFileWrangleOperations);
        } else if (type == WrangleOperationType.SPATIAL_JOIN) {
            createSpatialJoins(multiFileWrangleOperations);
        }
    }

    private void createUnions(List<WrangleOperation> multiFileWrangleOperations) {
        for (WrangleOperation wo : multiFileWrangleOperations) {
            if (wo.getType() == WrangleOperationType.UNION) {
                List<FromFile> files = new ArrayList<>();
                files.add(aliasesMap.get(wo.getUnionOperation().getFirstFile()));
                files.add(aliasesMap.get(wo.getUnionOperation().getSecondFile()));
                UnionOperator union = new UnionOperator(files.get(0), files.get(1));
                for (FromFile f : files) {
                    FileOperatorSequence seq = sequenceMap.get(f);
                    union.addDependency(seq.getLast());
                    //seq.addOperator(union);
                }
                updateAllDependencySequences(union);
                updateCount();
            }
        }
    }

    private void createSpatialJoins(List<WrangleOperation> multiFileWrangleOperations) {
        for (WrangleOperation wo : multiFileWrangleOperations) {
            if (wo.getType() == WrangleOperationType.SPATIAL_JOIN) {
                List<FromFile> files = new ArrayList<>();
                files.add(aliasesMap.get(wo.getSpatialJoinOperation().getFirstFile()));
                files.add(aliasesMap.get(wo.getSpatialJoinOperation().getSecondFile()));
                SpatialJoinOperator spatialJoin = new SpatialJoinOperator(files.get(0), files.get(1), wo.getSpatialJoinOperation().getConditions(), wo.getSpatialJoinOperation().getResultingFileName());
                for (FromFile f : files) {
                    FileOperatorSequence seq = sequenceMap.get(f);
                    spatialJoin.addDependency(seq.getLast());
                    //seq.addOperator(spatialJoin);
                }
                updateAllDependencySequences(spatialJoin);
                updateCount();
            }
        }
    }

    private void createJoinOperators(List<Condition> multiFileConditions, List<Disjunction> disjunctions) {
        List<FromFile> files = new ArrayList<>();
        JoinOperator join = null;
        if (disjunctions.size() != 0) {
            for (Disjunction d : disjunctions) {
                Set<String> fileStrings = new HashSet<>();
                fileStrings.add(d.getFirstCondition().getLeft().getFileColumn().getFile());
                fileStrings.add(d.getFirstCondition().getRight().getFileColumn().getFile());
                fileStrings.add(d.getSecondCondition().getLeft().getFileColumn().getFile());
                fileStrings.add(d.getSecondCondition().getRight().getFileColumn().getFile());
                for (String fs : fileStrings) {
                    files.add(aliasesMap.get(fs));
                }
            }
            join = new JoinOperator(files, disjunctions.get(0));
        } else if (multiFileConditions.size() != 0) {
            for (Condition c : multiFileConditions) {
                Set<String> fileStrings = new HashSet<>();
                fileStrings.add(c.getLeft().getFileColumn().getFile());
                fileStrings.add(c.getRight().getFileColumn().getFile());
                for (String fs : fileStrings) {
                    files.add(aliasesMap.get(fs));
                }
            }
            join = new JoinOperator(files, multiFileConditions.get(0));
        }
        for (FromFile f : files) {
            FileOperatorSequence seq = sequenceMap.get(f);
            if (!join.getDependencies().contains(seq.getLast())) {
                join.addDependency(seq.getLast());
            }
        }
        updateAllDependencySequences(join);
        updateCount();
    }

    private void createProjectOperators(SelectClause selectClause) {
        List<String> columns = new ArrayList<>();
        getLiteralArgs(selectClause.getFunctionCall(), columns);
        ProjectOperator project = new ProjectOperator(null, columns);
        project.addDependency(root);
        addToAllLists(project);
        root = project;
    }

    private void createGroupOperators(GroupClause groupClause) {
        if (groupClause != null) {
            FunctionCall functionCall = groupClause.getFunctionCall();
            GroupOperator group = new GroupOperator(functionCall);
            group.addDependency(root);
            addToAllLists(group);
            root = group;
        }
    }

    private void createWriteOperator(SelectClause selectClause, ToClause toClause) {
        FunctionCall functionCall = selectClause.getFunctionCall();
        ToFile outputFile = toClause.getToFile();
        WriteOperator write = new WriteOperator(outputFile, functionCall);
        write.addDependency(root);
        addToAllLists(write);
        root = write;
    }

    private void getLiteralArgs(FunctionCall functionCall, List<String> list) {
        List<FunctionArgument> args = functionCall.getFunctionArguments();
        for (FunctionArgument arg : args) {
            if (arg.getType() == FunctionArgumentType.LITERAL) {
                // only unquoted arguments are selected
                if (!arg.getLiteralString().matches("(\".*\")|(\'.*\')")) {
                    list.add(arg.getLiteralString());
                }
            } else if (arg.getType() == FunctionArgumentType.FUNCTION_CALL) {
                getLiteralArgs(arg.getFunctionCall(), list);
            } else if (arg.getType() == FunctionArgumentType.COLUMN) {
                list.add(arg.getFileColumn().getColumn());
            }
        }
    }

    private void updateAllDependencySequences(RelationalOperator newHeadOpeator) {
        List<RelationalOperator> dependencies = newHeadOpeator.getDependencies();
        Set<FromFile> files = sequenceMap.keySet();
        for (RelationalOperator dep : dependencies) {
            for (FromFile ff : files) {
                FileOperatorSequence seq = sequenceMap.get(ff);
                if (seq.getLast() == dep) {
                    seq.addOperator(newHeadOpeator);
                }
            }
        }
    }

    private String getClassName(String name) {
        name = name.toLowerCase();
        char[] nameCharacters = name.toCharArray();
        nameCharacters[0] = (char)(nameCharacters[0] - ('a' - 'A'));
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == '_') {
                nameCharacters[i + 1] = (char)(nameCharacters[i + 1] - ('a' - 'A'));
            }
        }
        name = new String(nameCharacters);
        while (name.indexOf('_') != -1) {
            int index = name.indexOf('_');
            name = name.substring(0, index) + name.substring(index + 1);
        }
        name += "Operator";
        name = "operators." + name;
        return name;
    }

    private Map<FromFile, List<WrangleOperation>> associateWranglingOperationsWithFiles(WrangleClause wrangleClause) {
        Map<FromFile, List<WrangleOperation>> map = new HashMap<>();
        List<WrangleOperation> operations = wrangleClause.getWrangleOperations();
        for (WrangleOperation wo : operations) {
            if (wo.getType() == WrangleOperationType.FUNCTION_CALL) {
                FunctionArgument firstArgument = wo.getFunctionCall().getFunctionArguments().get(0);
                if (firstArgument.getType() == FunctionArgumentType.COLUMN) {
                    String fileAlias = firstArgument.getFileColumn().getFile();
                    FromFile ff = aliasesMap.get(fileAlias);
                    List<WrangleOperation> operationList = map.getOrDefault(ff, new ArrayList<WrangleOperation>());
                    operationList.add(wo);
                    map.put(ff, operationList);
                } else if (firstArgument.getType() == FunctionArgumentType.LITERAL) {
                    String argString = firstArgument.getLiteralString();
                    if (aliasesMap.containsKey(argString)) {
                        FromFile ff = aliasesMap.get(argString);
                        List<WrangleOperation> operationList = map.getOrDefault(ff, new ArrayList<WrangleOperation>());
                        operationList.add(wo);
                        map.put(ff, operationList);
                    }
                }
            }
        }
        return map;
    }

    private Map<FromFile, List<Condition>> associateSingleConditionsWithFiles(FromClause fromClause, List<Condition> conditions) {
        List<FromFile> files = fromClause.getFiles();
        Map<FromFile, List<Condition>> map = new HashMap<>();
        for (FromFile f : files) {
            List<Condition> l = new ArrayList<>();
            map.put(f, l);
        }
        for (Condition c : conditions) {
            String alias = null;
            if (c.getLeft().getType() == OperandType.COLUMN) {
                alias = c.getLeft().getFileColumn().getFile();
            } else if (c.getLeft().getType() == OperandType.FUNCTION_CALL) {
                FunctionCall fc = c.getLeft().getFunctionCall();
                for (FunctionArgument fa : fc.getFunctionArguments()) {
                    alias = determineFileAlias(fa);
                    if (alias != null) {
                        break;
                    }
                }
            }
            FromFile ff = aliasesMap.get(alias);
            List<Condition> l = map.get(ff);
            l.add(c);
        }
        return map;
    }

    private String determineFileAlias(FunctionArgument fa) {
        if (fa.getType() == FunctionArgumentType.COLUMN) {
            return fa.getFileColumn().getFile();
        } else if (fa.getType() == FunctionArgumentType.FUNCTION_CALL) {
            for (FunctionArgument arg : fa.getFunctionCall().getFunctionArguments()) {
                String al = determineFileAlias(arg);
                if (al != null) {
                    return al;
                }
            }
        }
        return null;
    }

    private List<WrangleOperation> selectRemainingWrangleOperations(WrangleClause wrangleClause) {
        List<WrangleOperation> remaining = new ArrayList<>();
        List<WrangleOperation> operations = wrangleClause.getWrangleOperations();
        for (WrangleOperation wo : operations) {
            if (wo.getType() != WrangleOperationType.FUNCTION_CALL) {
                remaining.add(wo);
            }
        }
        return remaining;
    }

    private void sortConditions(WhereClause whereClause,
                                List<Condition> single, List<Condition> multi, List<Disjunction> disjunctions) {
        List<Condition> conditionsToSort = whereClause.getConditions();
        for (Condition c : conditionsToSort) {
            if (isSingleFileCondition(c)) {
                single.add(c);
            } else {
                multi.add(c);
            }
            if (c instanceof Disjunction) {
                disjunctions.add((Disjunction) c);
            }
        };
    }

    private boolean isSingleFileCondition(Condition condition) {
        if (condition instanceof Disjunction) {
            return false;
        }

        return condition.getRight().getType() == OperandType.LITERAL;
    }

    private void updateCount() {
        currentFilesCount--;
        if (currentFilesCount == 1) {
            hasSingleRoot = true;
            root = sequenceMap.get(sequenceMap.keySet().iterator().next()).getLast();
        }
    }

    private void addToAllLists(RelationalOperator op) {
        for (File f : sequenceMap.keySet()) {
            FileOperatorSequence seq = sequenceMap.get(f);
            seq.addOperator(op);
        }
    }

    private void performOptimization() {
        for (FromFile ff : sequenceMap.keySet()) {
            FileOperatorSequence seq = sequenceMap.get(ff);
            LinkedList<RelationalOperator> ll = seq.getOperators();
            if (ll.get(1) instanceof WranglingOperator && ((WranglingOperator) ll.get(1)).getFunctionCall().getFunctionName().equals("ENRICH_TIMESTAMP")) {
                if (ll.get(2) instanceof SelectOperator) {
                    FileColumn columnToEnrich = ((WranglingOperator) ll.get(1)).getFunctionCall().getFunctionArguments().get(0).getFileColumn();
                    //FileColumn columnToEnrich = ll.get(1).getFunctionCall().getArguments().get(0).getFileColumn();
                    List<Integer> independentConditions = getIndependentConditions((SelectOperator) ll.get(2), columnToEnrich);
                    List<Condition> beforeEnrich = new ArrayList<>();
                    List<Condition> afterEnrich = new ArrayList<>();
                    List<Condition> allConditions = ((SelectOperator) ll.get(2)).getConditions();
                    for (int i = 0; i < allConditions.size(); i++) {
                        if (independentConditions.contains(i)) {
                            beforeEnrich.add(allConditions.get(i));
                        } else {
                            afterEnrich.add(allConditions.get(i));
                        }
                    }
                    ((SelectOperator) ll.get(2)).setConditions(afterEnrich);
                    SelectOperator selectBeforeEnrich = new SelectOperator(((SelectOperator) ll.get(2)).getFile(), beforeEnrich);
                    ll.get(1).clearDependencies();
                    ll.get(1).addDependency(selectBeforeEnrich);
                    selectBeforeEnrich.addDependency(ll.get(0));
                    ll.add(1, selectBeforeEnrich);
                }
            }
        }
    }

    private List<Integer> getIndependentConditions(SelectOperator selectOperator, FileColumn column) {
        List<Integer> independent = new ArrayList<>();
        List<Condition> conditions = selectOperator.getConditions();
        for (int i = 0; i < conditions.size(); i++) {
            Condition c = conditions.get(i);
            if (!(c instanceof Disjunction)) {
                if (c.getLeft().getType() == OperandType.COLUMN) {
                    if (!c.getLeft().getFileColumn().getColumn().equals(column)) {
                        independent.add(i);
                    }
                }
            }
        }
        return independent;
    }
}
