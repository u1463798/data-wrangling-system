// Generated from /Users/tsvetanminkov/git/data-wrangling-compiler/src/main/grammar/D2wl.g4 by ANTLR 4.7.2
package com.wrangling.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link D2wlParser}.
 */
public interface D2wlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link D2wlParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(D2wlParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(D2wlParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#group_clause}.
	 * @param ctx the parse tree
	 */
	void enterGroup_clause(D2wlParser.Group_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#group_clause}.
	 * @param ctx the parse tree
	 */
	void exitGroup_clause(D2wlParser.Group_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#wrangle_clause}.
	 * @param ctx the parse tree
	 */
	void enterWrangle_clause(D2wlParser.Wrangle_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#wrangle_clause}.
	 * @param ctx the parse tree
	 */
	void exitWrangle_clause(D2wlParser.Wrangle_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#wrangle_list}.
	 * @param ctx the parse tree
	 */
	void enterWrangle_list(D2wlParser.Wrangle_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#wrangle_list}.
	 * @param ctx the parse tree
	 */
	void exitWrangle_list(D2wlParser.Wrangle_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#wrangle_operation}.
	 * @param ctx the parse tree
	 */
	void enterWrangle_operation(D2wlParser.Wrangle_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#wrangle_operation}.
	 * @param ctx the parse tree
	 */
	void exitWrangle_operation(D2wlParser.Wrangle_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#union_operation}.
	 * @param ctx the parse tree
	 */
	void enterUnion_operation(D2wlParser.Union_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#union_operation}.
	 * @param ctx the parse tree
	 */
	void exitUnion_operation(D2wlParser.Union_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#spatial_join}.
	 * @param ctx the parse tree
	 */
	void enterSpatial_join(D2wlParser.Spatial_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#spatial_join}.
	 * @param ctx the parse tree
	 */
	void exitSpatial_join(D2wlParser.Spatial_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#atom_list}.
	 * @param ctx the parse tree
	 */
	void enterAtom_list(D2wlParser.Atom_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#atom_list}.
	 * @param ctx the parse tree
	 */
	void exitAtom_list(D2wlParser.Atom_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#file_name}.
	 * @param ctx the parse tree
	 */
	void enterFile_name(D2wlParser.File_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#file_name}.
	 * @param ctx the parse tree
	 */
	void exitFile_name(D2wlParser.File_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(D2wlParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(D2wlParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#condition_list}.
	 * @param ctx the parse tree
	 */
	void enterCondition_list(D2wlParser.Condition_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#condition_list}.
	 * @param ctx the parse tree
	 */
	void exitCondition_list(D2wlParser.Condition_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(D2wlParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(D2wlParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(D2wlParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(D2wlParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(D2wlParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(D2wlParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#left_operand}.
	 * @param ctx the parse tree
	 */
	void enterLeft_operand(D2wlParser.Left_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#left_operand}.
	 * @param ctx the parse tree
	 */
	void exitLeft_operand(D2wlParser.Left_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#right_operand}.
	 * @param ctx the parse tree
	 */
	void enterRight_operand(D2wlParser.Right_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#right_operand}.
	 * @param ctx the parse tree
	 */
	void exitRight_operand(D2wlParser.Right_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(D2wlParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(D2wlParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#quoted_numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterQuoted_numeric_literal(D2wlParser.Quoted_numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#quoted_numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitQuoted_numeric_literal(D2wlParser.Quoted_numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#table_column}.
	 * @param ctx the parse tree
	 */
	void enterTable_column(D2wlParser.Table_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#table_column}.
	 * @param ctx the parse tree
	 */
	void exitTable_column(D2wlParser.Table_columnContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(D2wlParser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(D2wlParser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#to_clause}.
	 * @param ctx the parse tree
	 */
	void enterTo_clause(D2wlParser.To_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#to_clause}.
	 * @param ctx the parse tree
	 */
	void exitTo_clause(D2wlParser.To_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#to_location}.
	 * @param ctx the parse tree
	 */
	void enterTo_location(D2wlParser.To_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#to_location}.
	 * @param ctx the parse tree
	 */
	void exitTo_location(D2wlParser.To_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(D2wlParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(D2wlParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#from_list}.
	 * @param ctx the parse tree
	 */
	void enterFrom_list(D2wlParser.From_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#from_list}.
	 * @param ctx the parse tree
	 */
	void exitFrom_list(D2wlParser.From_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#from_location}.
	 * @param ctx the parse tree
	 */
	void enterFrom_location(D2wlParser.From_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#from_location}.
	 * @param ctx the parse tree
	 */
	void exitFrom_location(D2wlParser.From_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterSelect_clause(D2wlParser.Select_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitSelect_clause(D2wlParser.Select_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#select_argument}.
	 * @param ctx the parse tree
	 */
	void enterSelect_argument(D2wlParser.Select_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#select_argument}.
	 * @param ctx the parse tree
	 */
	void exitSelect_argument(D2wlParser.Select_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(D2wlParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(D2wlParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument(D2wlParser.Function_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument(D2wlParser.Function_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#literal_argument}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_argument(D2wlParser.Literal_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#literal_argument}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_argument(D2wlParser.Literal_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#import_list}.
	 * @param ctx the parse tree
	 */
	void enterImport_list(D2wlParser.Import_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#import_list}.
	 * @param ctx the parse tree
	 */
	void exitImport_list(D2wlParser.Import_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#imported_function}.
	 * @param ctx the parse tree
	 */
	void enterImported_function(D2wlParser.Imported_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#imported_function}.
	 * @param ctx the parse tree
	 */
	void exitImported_function(D2wlParser.Imported_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(D2wlParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(D2wlParser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(D2wlParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(D2wlParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#name_alias}.
	 * @param ctx the parse tree
	 */
	void enterName_alias(D2wlParser.Name_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#name_alias}.
	 * @param ctx the parse tree
	 */
	void exitName_alias(D2wlParser.Name_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(D2wlParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(D2wlParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(D2wlParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(D2wlParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(D2wlParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(D2wlParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(D2wlParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(D2wlParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(D2wlParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(D2wlParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link D2wlParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(D2wlParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link D2wlParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(D2wlParser.KeywordContext ctx);
}