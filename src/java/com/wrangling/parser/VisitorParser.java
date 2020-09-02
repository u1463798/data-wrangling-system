package com.wrangling.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.wrangling.antlr.D2wlBaseVisitor;
import com.wrangling.antlr.D2wlLexer;
import com.wrangling.antlr.D2wlParser;
import com.wrangling.antlr.D2wlParser.Function_argumentContext;
import com.wrangling.antlr.D2wlParser.Wrangle_operationContext;
import com.wrangling.exceptions.ParsingException;
import com.wrangling.models.Condition;
import com.wrangling.models.ConditionOperand;
import com.wrangling.models.ConditionOperator;
import com.wrangling.models.Disjunction;
import com.wrangling.models.FileColumn;
import com.wrangling.models.FromClause;
import com.wrangling.models.FromFile;
import com.wrangling.models.FunctionArgument;
import com.wrangling.models.FunctionArgumentType;
import com.wrangling.models.FunctionCall;
import com.wrangling.models.GroupClause;
import com.wrangling.models.ImportList;
import com.wrangling.models.OperandType;
import com.wrangling.models.Query;
import com.wrangling.models.SelectClause;
import com.wrangling.models.SpatialJoinOperation;
import com.wrangling.models.ToClause;
import com.wrangling.models.ToFile;
import com.wrangling.models.UnionOperation;
import com.wrangling.models.WhereClause;
import com.wrangling.models.WrangleClause;
import com.wrangling.models.WrangleOperation;
import com.wrangling.models.WrangleOperationType;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class VisitorParser implements Parser {

    @Override
    public Query parse(String d2wlCode) throws ParsingException {
        CharStream charStream = CharStreams.fromString(d2wlCode);
        D2wlLexer lexer = new D2wlLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        D2wlParser parser = new D2wlParser(tokens);

        QueryVisitor queryVisitor = new QueryVisitor();
        Query traverseResult = queryVisitor.visit(parser.query());
        return traverseResult;
    }

    public static class QueryVisitor extends D2wlBaseVisitor<Query> {
        @Override
        public Query visitQuery(D2wlParser.QueryContext ctx) {
            ImportListVisitor importListVisitor = new ImportListVisitor();
            ImportList importList = ctx.import_list() == null ? null : ctx.import_list().accept(importListVisitor);

            SelectClauseVisitor selectClauseVisitor = new SelectClauseVisitor();
            SelectClause selectClause = ctx.select_clause().accept(selectClauseVisitor);

            FromClauseVisitor fromClauseVisitor = new FromClauseVisitor();
            FromClause fromClause = ctx.from_clause().accept(fromClauseVisitor);
            //FromClause fromClause = fromClauseVisitor.visit(ctx.from_clause());

            ToClauseVisitor toClauseVisitor = new ToClauseVisitor();
            ToClause toClause = ctx.to_clause().accept(toClauseVisitor);

            WhereClauseVisitor whereClauseVisitor = new WhereClauseVisitor();
            WhereClause whereClause = ctx.where_clause().accept(whereClauseVisitor);

            WrangleClauseVisitor wrangleClauseVisitor = new WrangleClauseVisitor();
            WrangleClause wrangleClause = ctx.wrangle_clause().accept(wrangleClauseVisitor);

            GroupClauseVisitor groupClauseVisitor = new GroupClauseVisitor();
            GroupClause groupClause = null;
            if (ctx.group_clause() != null) {
                groupClause = ctx.group_clause().accept(groupClauseVisitor);
            }

            return new Query(importList, selectClause, fromClause, toClause, whereClause, wrangleClause, groupClause);
        }
    }

    private static class ImportListVisitor extends D2wlBaseVisitor<ImportList> {
        @Override
        public ImportList visitImport_list(D2wlParser.Import_listContext ctx) {
            if (ctx == null) return null;
            List<D2wlParser.Imported_functionContext> imported = ctx.imported_function();
            List<String> imports = new ArrayList<>();
            for (D2wlParser.Imported_functionContext imp : imported) {
                imports.add(imp.any_name().getText());
            }
            ImportList importList = new ImportList(imports);
            return importList;
        }
    }

    private static class SelectClauseVisitor extends D2wlBaseVisitor<SelectClause> {
        private FunctionCallVisitor functionCallVisitor = new FunctionCallVisitor();

        @Override
        public SelectClause visitSelect_clause(D2wlParser.Select_clauseContext ctx) {
            FunctionCall functionCall = functionCallVisitor.visitFunction_call(ctx.select_argument().function_call());
            return new SelectClause(functionCall);
        }
    }

    private static class FromClauseVisitor extends D2wlBaseVisitor<FromClause> {
        @Override
        public FromClause visitFrom_clause(D2wlParser.From_clauseContext ctx) {
            String fromString = ctx.FROM().getText();
            FromFileVisitor fromFileVisitor = new FromFileVisitor();
            List<FromFile> fromFiles = ctx.from_list().from_location()
                    .stream()
                    .map(fromFile -> fromFile.accept(fromFileVisitor))
                    .collect(toList());
            return new FromClause(fromString, fromFiles);
        }
    }

    private static class ToClauseVisitor extends D2wlBaseVisitor<ToClause> {
        @Override
        public ToClause visitTo_clause(D2wlParser.To_clauseContext ctx) {
            ToFileVisitor toFileVisitor = new ToFileVisitor();
            ToFile toFile = ctx.to_location().accept(toFileVisitor);
            return new ToClause(toFile);
        }
    }

    private static class WhereClauseVisitor extends D2wlBaseVisitor<WhereClause> {
        ConditionListVisitor conditionListVisitor = new ConditionListVisitor();

        @Override
        public WhereClause visitWhere_clause(D2wlParser.Where_clauseContext ctx) {
            List<Condition> conditions = conditionListVisitor.collectConditions(ctx.condition_list());
            return new WhereClause(conditions);
        }
    }

    private static class WrangleClauseVisitor extends D2wlBaseVisitor<WrangleClause> {
        private WrangleOperationVisitor wrangleOperationVisitor = new WrangleOperationVisitor();

        @Override
        public WrangleClause visitWrangle_clause(D2wlParser.Wrangle_clauseContext ctx) {
            List<WrangleOperation> wrangleOperations = new ArrayList<>();
            for (Wrangle_operationContext wo : ctx.wrangle_list().wrangle_operation()) {
                wrangleOperations.add(wrangleOperationVisitor.visitWrangle_operation(wo));
            }
            return new WrangleClause(wrangleOperations);
        }
    }

    private static class GroupClauseVisitor extends D2wlBaseVisitor<GroupClause> {
        private FunctionCallVisitor functionCallVisitor = new FunctionCallVisitor();

        @Override
        public GroupClause visitGroup_clause(D2wlParser.Group_clauseContext ctx) {
            FunctionCall functionCall = functionCallVisitor.visitFunction_call(ctx.function_call());
            return new GroupClause(functionCall);
        }
    }

    private static class WrangleOperationVisitor extends D2wlBaseVisitor<WrangleOperation> {
        private FunctionCallVisitor functionCallVisitor = new FunctionCallVisitor();
        private UnionVisitor unionVisitor = new UnionVisitor();
        private SpatialJoinVisitor spatialJoinVisitor = new SpatialJoinVisitor();

        @Override
        public WrangleOperation visitWrangle_operation(D2wlParser.Wrangle_operationContext ctx) {
            if (ctx.function_call() != null) {
                FunctionCall functionCall = functionCallVisitor.visitFunction_call(ctx.function_call());
                return new WrangleOperation(WrangleOperationType.FUNCTION_CALL, functionCall, null, null);
            } else if (ctx.union_operation() != null) {
                UnionOperation unionOperation = unionVisitor.visitUnion_operation(ctx.union_operation());
                return new WrangleOperation(WrangleOperationType.UNION, null, unionOperation, null);
            } else {
                SpatialJoinOperation spatialJoinOperation = spatialJoinVisitor.visitSpatial_join(ctx.spatial_join());
                return new WrangleOperation(WrangleOperationType.SPATIAL_JOIN, null, null, spatialJoinOperation);
            }
        }
    }

    private static class SpatialJoinVisitor extends D2wlBaseVisitor<SpatialJoinOperation> {
        private AtomVisitor atomVisitor = new AtomVisitor();
        @Override
        public SpatialJoinOperation visitSpatial_join(D2wlParser.Spatial_joinContext ctx) {
            String first  = ctx.file_name(0).getText();
            String second = ctx.file_name(1).getText();
            List<Condition> conditions = new ArrayList<>();
            for (D2wlParser.AtomContext c : ctx.atom_list().atom()) {
                conditions.add(atomVisitor.visitAtom(c));
            }
            String resultingFile = ctx.file_name(2).getText();
            SpatialJoinOperation spatialJoin = new SpatialJoinOperation(first, second, conditions, resultingFile);
            return spatialJoin;
        }
    }

    private static class UnionVisitor extends D2wlBaseVisitor<UnionOperation> {
        @Override
        public UnionOperation visitUnion_operation(D2wlParser.Union_operationContext ctx) {
            String first = ctx.file_name(0).getText();
            String second = ctx.file_name(1).getText();
            return new UnionOperation(first, second);
        }
    }

    private static class FunctionCallVisitor extends D2wlBaseVisitor<FunctionCall> {
        @Override
        public FunctionCall visitFunction_call(D2wlParser.Function_callContext ctx) {
            String functionName = ctx.function_name().getText();
            FunctionArgumentVisitor functionArgumentVisitor = new FunctionArgumentVisitor();
            List<FunctionArgument> functionArguments = ctx.function_argument()
                    .stream()
                    .map(functionArgument -> functionArgument.accept(functionArgumentVisitor))
                    .collect(toList());
            return new FunctionCall(functionName, functionArguments);
        }
    }

    private static class FunctionArgumentVisitor extends D2wlBaseVisitor<FunctionArgument> {
        private FileColumnVisitor fileColumnVisitor = new FileColumnVisitor();
        @Override
        public FunctionArgument visitFunction_argument(D2wlParser.Function_argumentContext ctx) {
            if (ctx.literal_argument() != null) {
                String literal = ctx.literal_argument().getText();
                return new FunctionArgument(FunctionArgumentType.LITERAL, literal, null, null);
            } else if (ctx.table_column() != null) {
                FileColumn fileColumn =fileColumnVisitor.visitTable_column(ctx.table_column());
                return new FunctionArgument(FunctionArgumentType.COLUMN, null, null, fileColumn);
            } else {
                String functionName = ctx.function_call().function_name().getText();
                List<FunctionArgument> args = new ArrayList<>();
                for (Function_argumentContext arg : ctx.function_call().function_argument()) {
                    args.add(visitFunction_argument(arg));
                }
                FunctionCall functionCall = new FunctionCall(functionName, args);
                return new FunctionArgument(FunctionArgumentType.FUNCTION_CALL, null, functionCall, null);
            }
        }
    }

    private static class FromFileVisitor extends D2wlBaseVisitor<FromFile> {
        @Override
        public FromFile visitFrom_location(D2wlParser.From_locationContext ctx) {
            String name = ctx.url().name().getText();
            String extension = ctx.url().extension().getText();
            String alias = ctx.name_alias().getText();
            return new FromFile(name, extension, alias);
        }
    }

    private static class ToFileVisitor extends D2wlBaseVisitor<ToFile> {
        @Override
        public ToFile visitTo_location(D2wlParser.To_locationContext ctx) {
            String name = ctx.url().name().getText();
            String extension = ctx.url().extension().getText();
            return new ToFile(name, extension);
        }
    }

    private static class ConditionListVisitor extends D2wlBaseVisitor<Condition> {
        private FormulaVisitor formulaVisitor = new FormulaVisitor();
        private List<Condition> conditions = new ArrayList<>();

        public List<Condition> collectConditions(D2wlParser.Condition_listContext ctx) {
            while (ctx != null) {
                conditions.add(visitCondition_list(ctx));
                ctx = ctx.condition_list();
            }
            return conditions;
        }

        @Override
        public Condition visitCondition_list(D2wlParser.Condition_listContext ctx) {
            return formulaVisitor.visitFormula(ctx.formula());
        }
    }

    private static class FormulaVisitor extends D2wlBaseVisitor<Condition> {
        private AtomVisitor atomVisitor = new AtomVisitor();
        private DisjunctionVisitor disjunctionVisitor = new DisjunctionVisitor();

        @Override
        public Condition visitFormula(D2wlParser.FormulaContext ctx) {
            if (ctx.atom() != null) {
                return atomVisitor.visitAtom(ctx.atom());
            } else {
                return disjunctionVisitor.visitDisjunction(ctx.disjunction());
            }
        }
    }

    private static class AtomVisitor extends D2wlBaseVisitor<Condition> {
        private FileColumnVisitor fileColumnVisitor = new FileColumnVisitor();
        private FunctionCallVisitor functionCallVisitor = new FunctionCallVisitor();

        @Override
        public Condition visitAtom(D2wlParser.AtomContext ctx) {
            ConditionOperand left, right;
            FunctionCall fc1 = null;
            FileColumn fc2 = null;
            String lit = null;
            if (ctx.left_operand().function_call() != null) {
                fc1 = functionCallVisitor.visitFunction_call(ctx.left_operand().function_call());
            } else {
                fc2 = fileColumnVisitor.visitTable_column(ctx.left_operand().table_column());
            }
            left = new ConditionOperand(fc1 == null ? OperandType.COLUMN : OperandType.FUNCTION_CALL, fc1, fc2, lit);
            fc1 = null;
            fc2 = null;
            if (ctx.right_operand().function_call() != null) {
                fc1 = functionCallVisitor.visitFunction_call(ctx.right_operand().function_call());
            } else if (ctx.right_operand().literal_value() != null) {
                lit = ctx.right_operand().literal_value().getText();
            } else {
                fc2 = fileColumnVisitor.visitTable_column(ctx.right_operand().table_column());
            }
            right = new ConditionOperand(fc1 == null ? (fc2 == null ? OperandType.LITERAL : OperandType.COLUMN) : OperandType.FUNCTION_CALL, fc1, fc2, lit);
            ConditionOperator op = new ConditionOperator(ctx.comparison_operator().getText());
            return new Condition(left, right, op);
        }
    }

    private static class AtomLsitVisitor extends D2wlBaseVisitor<List<Condition>> {

    }

    private static class DisjunctionVisitor extends D2wlBaseVisitor<Disjunction> {
        private AtomVisitor atomVisitor = new AtomVisitor();
        @Override
        public Disjunction visitDisjunction(D2wlParser.DisjunctionContext ctx) {
            Condition first = atomVisitor.visitAtom(ctx.atom(0));
            Condition second = atomVisitor.visitAtom(ctx.atom(1));
            return new Disjunction(first, second);
        }
    }

    private static class FileColumnVisitor extends D2wlBaseVisitor<FileColumn> {
        @Override
        public FileColumn visitTable_column(D2wlParser.Table_columnContext ctx) {
            return new FileColumn(ctx.table_name().getText(), ctx.column_name().getText());
        }
    }

    public static String printFunctionCall(FunctionCall fc) {
        String s = "";
        s += fc.getFunctionName();
        s += '(';
        for (FunctionArgument arg : fc.getFunctionArguments()) {
            if (arg.getType() == FunctionArgumentType.LITERAL) {
                s += arg.getLiteralString();
            } else {
                s += printFunctionCall(arg.getFunctionCall());
            }
            s += ',';
        }
        s = s.substring(0, s.length() - 1);
        s += ')';
        return s;
    }

    private static void printConditions(List<Condition> l) {
        for (Condition condition : l) {
            if (condition instanceof Disjunction) {
                printDisjunction((Disjunction)condition);
            } else {
                printCondition(condition);
            }
            System.out.println("\n======================");
        }
    }

    private static void printDisjunction(Disjunction d) {
        printCondition(d.getFirstCondition());
        System.out.print(" OR ");
        printCondition(d.getSecondCondition());
    }

    private static void printCondition(Condition c) {
        System.out.print(c.getLeft());
        System.out.print(c.getOperator());
        System.out.print(c.getRight());
    }

    private static void printWrangleClause(WrangleClause wrangleClause) {
        for (WrangleOperation wo : wrangleClause.getWrangleOperations()) {
            System.out.println(wo);
        }
    }
}
