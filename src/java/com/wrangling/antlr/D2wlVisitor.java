// Generated from /Users/tsvetanminkov/git/data-wrangling-compiler/src/main/grammar/D2wl.g4 by ANTLR 4.7.2
package com.wrangling.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link D2wlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface D2wlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link D2wlParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(D2wlParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#group_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_clause(D2wlParser.Group_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#wrangle_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrangle_clause(D2wlParser.Wrangle_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#wrangle_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrangle_list(D2wlParser.Wrangle_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#wrangle_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrangle_operation(D2wlParser.Wrangle_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#union_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion_operation(D2wlParser.Union_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#spatial_join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpatial_join(D2wlParser.Spatial_joinContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#atom_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_list(D2wlParser.Atom_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#file_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_name(D2wlParser.File_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(D2wlParser.Where_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#condition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_list(D2wlParser.Condition_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(D2wlParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(D2wlParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(D2wlParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#left_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_operand(D2wlParser.Left_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#right_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_operand(D2wlParser.Right_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(D2wlParser.Literal_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#quoted_numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted_numeric_literal(D2wlParser.Quoted_numeric_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#table_column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_column(D2wlParser.Table_columnContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(D2wlParser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#to_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo_clause(D2wlParser.To_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#to_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo_location(D2wlParser.To_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_clause(D2wlParser.From_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#from_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_list(D2wlParser.From_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#from_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_location(D2wlParser.From_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_clause(D2wlParser.Select_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#select_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_argument(D2wlParser.Select_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(D2wlParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#function_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_argument(D2wlParser.Function_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#literal_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_argument(D2wlParser.Literal_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#import_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_list(D2wlParser.Import_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#imported_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImported_function(D2wlParser.Imported_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(D2wlParser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(D2wlParser.ExtensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#name_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName_alias(D2wlParser.Name_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(D2wlParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(D2wlParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(D2wlParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(D2wlParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(D2wlParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link D2wlParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(D2wlParser.KeywordContext ctx);
}