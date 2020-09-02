// Generated from /Users/tsvetanminkov/git/data-wrangling-compiler/src/main/grammar/D2wl.g4 by ANTLR 4.7.2
package com.wrangling.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class D2wlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SCOL=2, DOT=3, OPEN_PAR=4, CLOSE_PAR=5, COMMA=6, EQ=7, STAR=8, 
		PLUS=9, MINUS=10, TILDE=11, PIPE2=12, DIV=13, MOD=14, LT2=15, GT2=16, 
		AMP=17, PIPE=18, LT=19, LT_EQ=20, GT=21, GT_EQ=22, NOT_EQ1=23, NOT_EQ2=24, 
		SELECT=25, FROM=26, TO=27, WHERE=28, WRANGLE=29, GROUP=30, BY=31, AS=32, 
		AND=33, OR=34, UNION=35, JOIN=36, ON=37, IMPORT=38, IDENTIFIER=39, TIME_LITERAL=40, 
		COL=41, NUMERIC_LITERAL=42, STRING_LITERAL=43, SPACES=44;
	public static final int
		RULE_query = 0, RULE_group_clause = 1, RULE_wrangle_clause = 2, RULE_wrangle_list = 3, 
		RULE_wrangle_operation = 4, RULE_union_operation = 5, RULE_spatial_join = 6, 
		RULE_atom_list = 7, RULE_file_name = 8, RULE_where_clause = 9, RULE_condition_list = 10, 
		RULE_formula = 11, RULE_atom = 12, RULE_disjunction = 13, RULE_left_operand = 14, 
		RULE_right_operand = 15, RULE_literal_value = 16, RULE_quoted_numeric_literal = 17, 
		RULE_table_column = 18, RULE_comparison_operator = 19, RULE_to_clause = 20, 
		RULE_to_location = 21, RULE_from_clause = 22, RULE_from_list = 23, RULE_from_location = 24, 
		RULE_select_clause = 25, RULE_select_argument = 26, RULE_function_call = 27, 
		RULE_function_argument = 28, RULE_literal_argument = 29, RULE_import_list = 30, 
		RULE_imported_function = 31, RULE_url = 32, RULE_extension = 33, RULE_name_alias = 34, 
		RULE_column_name = 35, RULE_table_name = 36, RULE_name = 37, RULE_function_name = 38, 
		RULE_any_name = 39, RULE_keyword = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "group_clause", "wrangle_clause", "wrangle_list", "wrangle_operation", 
			"union_operation", "spatial_join", "atom_list", "file_name", "where_clause", 
			"condition_list", "formula", "atom", "disjunction", "left_operand", "right_operand", 
			"literal_value", "quoted_numeric_literal", "table_column", "comparison_operator", 
			"to_clause", "to_location", "from_clause", "from_list", "from_location", 
			"select_clause", "select_argument", "function_call", "function_argument", 
			"literal_argument", "import_list", "imported_function", "url", "extension", 
			"name_alias", "column_name", "table_name", "name", "function_name", "any_name", 
			"keyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", 
			"'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", 
			"'<='", "'>'", "'>='", "'!='", "'<>'", null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "EQ", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "NOT_EQ1", "NOT_EQ2", "SELECT", 
			"FROM", "TO", "WHERE", "WRANGLE", "GROUP", "BY", "AS", "AND", "OR", "UNION", 
			"JOIN", "ON", "IMPORT", "IDENTIFIER", "TIME_LITERAL", "COL", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "D2wl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public D2wlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public Select_clauseContext select_clause() {
			return getRuleContext(Select_clauseContext.class,0);
		}
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public To_clauseContext to_clause() {
			return getRuleContext(To_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Wrangle_clauseContext wrangle_clause() {
			return getRuleContext(Wrangle_clauseContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(D2wlParser.SCOL, 0); }
		public Import_listContext import_list() {
			return getRuleContext(Import_listContext.class,0);
		}
		public Group_clauseContext group_clause() {
			return getRuleContext(Group_clauseContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORT) {
				{
				setState(82);
				import_list();
				}
			}

			setState(85);
			select_clause();
			setState(86);
			from_clause();
			setState(87);
			to_clause();
			setState(88);
			where_clause();
			setState(89);
			wrangle_clause();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(90);
				group_clause();
				}
			}

			setState(93);
			match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Group_clauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(D2wlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(D2wlParser.BY, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Group_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterGroup_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitGroup_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitGroup_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Group_clauseContext group_clause() throws RecognitionException {
		Group_clauseContext _localctx = new Group_clauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_group_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(GROUP);
			setState(96);
			match(BY);
			setState(97);
			function_call();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wrangle_clauseContext extends ParserRuleContext {
		public TerminalNode WRANGLE() { return getToken(D2wlParser.WRANGLE, 0); }
		public TerminalNode BY() { return getToken(D2wlParser.BY, 0); }
		public Wrangle_listContext wrangle_list() {
			return getRuleContext(Wrangle_listContext.class,0);
		}
		public Wrangle_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrangle_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterWrangle_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitWrangle_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitWrangle_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wrangle_clauseContext wrangle_clause() throws RecognitionException {
		Wrangle_clauseContext _localctx = new Wrangle_clauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_wrangle_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(WRANGLE);
			setState(100);
			match(BY);
			setState(101);
			wrangle_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wrangle_listContext extends ParserRuleContext {
		public List<Wrangle_operationContext> wrangle_operation() {
			return getRuleContexts(Wrangle_operationContext.class);
		}
		public Wrangle_operationContext wrangle_operation(int i) {
			return getRuleContext(Wrangle_operationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(D2wlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(D2wlParser.COMMA, i);
		}
		public Wrangle_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrangle_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterWrangle_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitWrangle_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitWrangle_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wrangle_listContext wrangle_list() throws RecognitionException {
		Wrangle_listContext _localctx = new Wrangle_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_wrangle_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			wrangle_operation();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(104);
				match(COMMA);
				setState(105);
				wrangle_operation();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wrangle_operationContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Union_operationContext union_operation() {
			return getRuleContext(Union_operationContext.class,0);
		}
		public Spatial_joinContext spatial_join() {
			return getRuleContext(Spatial_joinContext.class,0);
		}
		public Wrangle_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrangle_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterWrangle_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitWrangle_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitWrangle_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wrangle_operationContext wrangle_operation() throws RecognitionException {
		Wrangle_operationContext _localctx = new Wrangle_operationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_wrangle_operation);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				union_operation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				spatial_join();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Union_operationContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(D2wlParser.OPEN_PAR, 0); }
		public List<File_nameContext> file_name() {
			return getRuleContexts(File_nameContext.class);
		}
		public File_nameContext file_name(int i) {
			return getRuleContext(File_nameContext.class,i);
		}
		public TerminalNode UNION() { return getToken(D2wlParser.UNION, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(D2wlParser.CLOSE_PAR, 0); }
		public Union_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterUnion_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitUnion_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitUnion_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Union_operationContext union_operation() throws RecognitionException {
		Union_operationContext _localctx = new Union_operationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_union_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(OPEN_PAR);
			setState(117);
			file_name();
			setState(118);
			match(UNION);
			setState(119);
			file_name();
			setState(120);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Spatial_joinContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_PAR() { return getTokens(D2wlParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(D2wlParser.OPEN_PAR, i);
		}
		public List<File_nameContext> file_name() {
			return getRuleContexts(File_nameContext.class);
		}
		public File_nameContext file_name(int i) {
			return getRuleContext(File_nameContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(D2wlParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(D2wlParser.ON, 0); }
		public Atom_listContext atom_list() {
			return getRuleContext(Atom_listContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(D2wlParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(D2wlParser.CLOSE_PAR, i);
		}
		public TerminalNode AS() { return getToken(D2wlParser.AS, 0); }
		public Spatial_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spatial_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterSpatial_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitSpatial_join(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitSpatial_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Spatial_joinContext spatial_join() throws RecognitionException {
		Spatial_joinContext _localctx = new Spatial_joinContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_spatial_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(OPEN_PAR);
			setState(123);
			file_name();
			setState(124);
			match(JOIN);
			setState(125);
			file_name();
			setState(126);
			match(ON);
			setState(127);
			match(OPEN_PAR);
			setState(128);
			atom_list();
			setState(129);
			match(CLOSE_PAR);
			setState(130);
			match(CLOSE_PAR);
			setState(131);
			match(AS);
			setState(132);
			file_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Atom_listContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(D2wlParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(D2wlParser.AND, i);
		}
		public Atom_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterAtom_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitAtom_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitAtom_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atom_listContext atom_list() throws RecognitionException {
		Atom_listContext _localctx = new Atom_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atom_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			atom();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(135);
				match(AND);
				setState(136);
				atom();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class File_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public File_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFile_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFile_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFile_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_nameContext file_name() throws RecognitionException {
		File_nameContext _localctx = new File_nameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_file_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(D2wlParser.WHERE, 0); }
		public Condition_listContext condition_list() {
			return getRuleContext(Condition_listContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitWhere_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitWhere_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(WHERE);
			setState(145);
			condition_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condition_listContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode AND() { return getToken(D2wlParser.AND, 0); }
		public Condition_listContext condition_list() {
			return getRuleContext(Condition_listContext.class,0);
		}
		public Condition_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterCondition_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitCondition_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitCondition_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_listContext condition_list() throws RecognitionException {
		Condition_listContext _localctx = new Condition_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condition_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			formula();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(148);
				match(AND);
				setState(149);
				condition_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formula);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				disjunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Left_operandContext left_operand() {
			return getRuleContext(Left_operandContext.class,0);
		}
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public Right_operandContext right_operand() {
			return getRuleContext(Right_operandContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			left_operand();
			setState(157);
			comparison_operator();
			setState(158);
			right_operand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(D2wlParser.OPEN_PAR, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode OR() { return getToken(D2wlParser.OR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(D2wlParser.CLOSE_PAR, 0); }
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(OPEN_PAR);
			setState(161);
			atom();
			setState(162);
			match(OR);
			setState(163);
			atom();
			setState(164);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Left_operandContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Table_columnContext table_column() {
			return getRuleContext(Table_columnContext.class,0);
		}
		public Left_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterLeft_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitLeft_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitLeft_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_operandContext left_operand() throws RecognitionException {
		Left_operandContext _localctx = new Left_operandContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_left_operand);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				table_column();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Right_operandContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Table_columnContext table_column() {
			return getRuleContext(Table_columnContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public Right_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterRight_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitRight_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitRight_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Right_operandContext right_operand() throws RecognitionException {
		Right_operandContext _localctx = new Right_operandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_right_operand);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				table_column();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				literal_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public Quoted_numeric_literalContext quoted_numeric_literal() {
			return getRuleContext(Quoted_numeric_literalContext.class,0);
		}
		public TerminalNode TIME_LITERAL() { return getToken(D2wlParser.TIME_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(D2wlParser.STRING_LITERAL, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal_value);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				quoted_numeric_literal();
				}
				break;
			case TIME_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(TIME_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Quoted_numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(D2wlParser.NUMERIC_LITERAL, 0); }
		public Quoted_numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterQuoted_numeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitQuoted_numeric_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitQuoted_numeric_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Quoted_numeric_literalContext quoted_numeric_literal() throws RecognitionException {
		Quoted_numeric_literalContext _localctx = new Quoted_numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_quoted_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__0);
			setState(181);
			match(NUMERIC_LITERAL);
			setState(182);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_columnContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(D2wlParser.DOT, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterTable_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitTable_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitTable_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_columnContext table_column() throws RecognitionException {
		Table_columnContext _localctx = new Table_columnContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_table_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			table_name();
			setState(185);
			match(DOT);
			setState(186);
			column_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comparison_operatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(D2wlParser.EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(D2wlParser.GT_EQ, 0); }
		public TerminalNode LT_EQ() { return getToken(D2wlParser.LT_EQ, 0); }
		public TerminalNode LT() { return getToken(D2wlParser.LT, 0); }
		public TerminalNode GT() { return getToken(D2wlParser.GT, 0); }
		public TerminalNode TILDE() { return getToken(D2wlParser.TILDE, 0); }
		public Comparison_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterComparison_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitComparison_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitComparison_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operatorContext comparison_operator() throws RecognitionException {
		Comparison_operatorContext _localctx = new Comparison_operatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comparison_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << TILDE) | (1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class To_clauseContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(D2wlParser.TO, 0); }
		public To_locationContext to_location() {
			return getRuleContext(To_locationContext.class,0);
		}
		public To_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterTo_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitTo_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitTo_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final To_clauseContext to_clause() throws RecognitionException {
		To_clauseContext _localctx = new To_clauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_to_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(TO);
			setState(191);
			to_location();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class To_locationContext extends ParserRuleContext {
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public To_locationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterTo_location(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitTo_location(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitTo_location(this);
			else return visitor.visitChildren(this);
		}
	}

	public final To_locationContext to_location() throws RecognitionException {
		To_locationContext _localctx = new To_locationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_to_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			url();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_clauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(D2wlParser.FROM, 0); }
		public From_listContext from_list() {
			return getRuleContext(From_listContext.class,0);
		}
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFrom_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFrom_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFrom_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(FROM);
			setState(196);
			from_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_listContext extends ParserRuleContext {
		public List<From_locationContext> from_location() {
			return getRuleContexts(From_locationContext.class);
		}
		public From_locationContext from_location(int i) {
			return getRuleContext(From_locationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(D2wlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(D2wlParser.COMMA, i);
		}
		public From_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFrom_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFrom_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFrom_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_listContext from_list() throws RecognitionException {
		From_listContext _localctx = new From_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_from_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			from_location();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(199);
				match(COMMA);
				setState(200);
				from_location();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_locationContext extends ParserRuleContext {
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode AS() { return getToken(D2wlParser.AS, 0); }
		public Name_aliasContext name_alias() {
			return getRuleContext(Name_aliasContext.class,0);
		}
		public From_locationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFrom_location(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFrom_location(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFrom_location(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_locationContext from_location() throws RecognitionException {
		From_locationContext _localctx = new From_locationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_from_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			url();
			setState(207);
			match(AS);
			setState(208);
			name_alias();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_clauseContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(D2wlParser.SELECT, 0); }
		public Select_argumentContext select_argument() {
			return getRuleContext(Select_argumentContext.class,0);
		}
		public Select_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterSelect_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitSelect_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitSelect_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_clauseContext select_clause() throws RecognitionException {
		Select_clauseContext _localctx = new Select_clauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_select_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(SELECT);
			setState(211);
			select_argument();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_argumentContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Select_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterSelect_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitSelect_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitSelect_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_argumentContext select_argument() throws RecognitionException {
		Select_argumentContext _localctx = new Select_argumentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_select_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			function_call();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_callContext extends ParserRuleContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(D2wlParser.OPEN_PAR, 0); }
		public List<Function_argumentContext> function_argument() {
			return getRuleContexts(Function_argumentContext.class);
		}
		public Function_argumentContext function_argument(int i) {
			return getRuleContext(Function_argumentContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(D2wlParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(D2wlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(D2wlParser.COMMA, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			function_name();
			setState(216);
			match(OPEN_PAR);
			setState(217);
			function_argument();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(218);
				match(COMMA);
				setState(219);
				function_argument();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argumentContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Table_columnContext table_column() {
			return getRuleContext(Table_columnContext.class,0);
		}
		public Literal_argumentContext literal_argument() {
			return getRuleContext(Literal_argumentContext.class,0);
		}
		public Function_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFunction_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFunction_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_function_argument);
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				table_column();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				literal_argument();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_argumentContext extends ParserRuleContext {
		public List<Any_nameContext> any_name() {
			return getRuleContexts(Any_nameContext.class);
		}
		public Any_nameContext any_name(int i) {
			return getRuleContext(Any_nameContext.class,i);
		}
		public TerminalNode OPEN_PAR() { return getToken(D2wlParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(D2wlParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(D2wlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(D2wlParser.COMMA, i);
		}
		public Literal_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterLiteral_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitLiteral_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitLiteral_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_argumentContext literal_argument() throws RecognitionException {
		Literal_argumentContext _localctx = new Literal_argumentContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_literal_argument);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				any_name(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(OPEN_PAR);
				{
				setState(234);
				any_name(0);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(235);
					match(COMMA);
					setState(236);
					any_name(0);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(242);
				match(CLOSE_PAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_listContext extends ParserRuleContext {
		public List<TerminalNode> IMPORT() { return getTokens(D2wlParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(D2wlParser.IMPORT, i);
		}
		public List<Imported_functionContext> imported_function() {
			return getRuleContexts(Imported_functionContext.class);
		}
		public Imported_functionContext imported_function(int i) {
			return getRuleContext(Imported_functionContext.class,i);
		}
		public Import_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterImport_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitImport_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitImport_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_listContext import_list() throws RecognitionException {
		Import_listContext _localctx = new Import_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_import_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(IMPORT);
			setState(247);
			imported_function();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(248);
				match(IMPORT);
				setState(249);
				imported_function();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Imported_functionContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Imported_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imported_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterImported_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitImported_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitImported_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Imported_functionContext imported_function() throws RecognitionException {
		Imported_functionContext _localctx = new Imported_functionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_imported_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrlContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(D2wlParser.DOT, 0); }
		public ExtensionContext extension() {
			return getRuleContext(ExtensionContext.class,0);
		}
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			name();
			setState(258);
			match(DOT);
			setState(259);
			extension();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtensionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitExtension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitExtension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Name_aliasContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Name_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterName_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitName_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitName_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Name_aliasContext name_alias() throws RecognitionException {
		Name_aliasContext _localctx = new Name_aliasContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_name_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			any_name(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(D2wlParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(D2wlParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(D2wlParser.OPEN_PAR, 0); }
		public List<Any_nameContext> any_name() {
			return getRuleContexts(Any_nameContext.class);
		}
		public Any_nameContext any_name(int i) {
			return getRuleContext(Any_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(D2wlParser.CLOSE_PAR, 0); }
		public TerminalNode DOT() { return getToken(D2wlParser.DOT, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		return any_name(0);
	}

	private Any_nameContext any_name(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Any_nameContext _localctx = new Any_nameContext(_ctx, _parentState);
		Any_nameContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_any_name, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(274);
				match(IDENTIFIER);
				}
				break;
			case SELECT:
			case FROM:
			case TO:
			case WHERE:
			case WRANGLE:
			case GROUP:
			case BY:
			case AS:
			case AND:
			case OR:
			case JOIN:
			case ON:
				{
				setState(275);
				keyword();
				}
				break;
			case STRING_LITERAL:
				{
				setState(276);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				{
				setState(277);
				match(OPEN_PAR);
				setState(278);
				any_name(0);
				setState(279);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Any_nameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_any_name);
					setState(283);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(284);
					match(DOT);
					setState(285);
					any_name(2);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(D2wlParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(D2wlParser.FROM, 0); }
		public TerminalNode TO() { return getToken(D2wlParser.TO, 0); }
		public TerminalNode WHERE() { return getToken(D2wlParser.WHERE, 0); }
		public TerminalNode WRANGLE() { return getToken(D2wlParser.WRANGLE, 0); }
		public TerminalNode GROUP() { return getToken(D2wlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(D2wlParser.BY, 0); }
		public TerminalNode AS() { return getToken(D2wlParser.AS, 0); }
		public TerminalNode AND() { return getToken(D2wlParser.AND, 0); }
		public TerminalNode OR() { return getToken(D2wlParser.OR, 0); }
		public TerminalNode JOIN() { return getToken(D2wlParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(D2wlParser.ON, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof D2wlListener ) ((D2wlListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof D2wlVisitor ) return ((D2wlVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << TO) | (1L << WHERE) | (1L << WRANGLE) | (1L << GROUP) | (1L << BY) | (1L << AS) | (1L << AND) | (1L << OR) | (1L << JOIN) | (1L << ON))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 39:
			return any_name_sempred((Any_nameContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean any_name_sempred(Any_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\5\2"+
		"V\n\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2^\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\7\5m\n\5\f\5\16\5p\13\5\3\6\3\6\3\6\5\6u\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f\13\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\5\f\u0099\n\f\3\r\3\r\5\r\u009d\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u00ab\n\20\3\21\3\21\3\21\5\21"+
		"\u00b0\n\21\3\22\3\22\3\22\5\22\u00b5\n\22\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\7\31\u00cc\n\31\f\31\16\31\u00cf\13\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u00df\n\35\f\35"+
		"\16\35\u00e2\13\35\3\35\3\35\3\36\3\36\3\36\5\36\u00e9\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\7\37\u00f0\n\37\f\37\16\37\u00f3\13\37\3\37\3\37\5\37"+
		"\u00f7\n\37\3 \3 \3 \3 \7 \u00fd\n \f \16 \u0100\13 \3!\3!\3\"\3\"\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\5)"+
		"\u011c\n)\3)\3)\3)\7)\u0121\n)\f)\16)\u0124\13)\3*\3*\3*\2\3P+\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2\4"+
		"\5\2\t\t\r\r\25\30\4\2\33$&\'\2\u0116\2U\3\2\2\2\4a\3\2\2\2\6e\3\2\2\2"+
		"\bi\3\2\2\2\nt\3\2\2\2\fv\3\2\2\2\16|\3\2\2\2\20\u0088\3\2\2\2\22\u0090"+
		"\3\2\2\2\24\u0092\3\2\2\2\26\u0095\3\2\2\2\30\u009c\3\2\2\2\32\u009e\3"+
		"\2\2\2\34\u00a2\3\2\2\2\36\u00aa\3\2\2\2 \u00af\3\2\2\2\"\u00b4\3\2\2"+
		"\2$\u00b6\3\2\2\2&\u00ba\3\2\2\2(\u00be\3\2\2\2*\u00c0\3\2\2\2,\u00c3"+
		"\3\2\2\2.\u00c5\3\2\2\2\60\u00c8\3\2\2\2\62\u00d0\3\2\2\2\64\u00d4\3\2"+
		"\2\2\66\u00d7\3\2\2\28\u00d9\3\2\2\2:\u00e8\3\2\2\2<\u00f6\3\2\2\2>\u00f8"+
		"\3\2\2\2@\u0101\3\2\2\2B\u0103\3\2\2\2D\u0107\3\2\2\2F\u0109\3\2\2\2H"+
		"\u010b\3\2\2\2J\u010d\3\2\2\2L\u010f\3\2\2\2N\u0111\3\2\2\2P\u011b\3\2"+
		"\2\2R\u0125\3\2\2\2TV\5> \2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\5\64\33\2"+
		"XY\5.\30\2YZ\5*\26\2Z[\5\24\13\2[]\5\6\4\2\\^\5\4\3\2]\\\3\2\2\2]^\3\2"+
		"\2\2^_\3\2\2\2_`\7\4\2\2`\3\3\2\2\2ab\7 \2\2bc\7!\2\2cd\58\35\2d\5\3\2"+
		"\2\2ef\7\37\2\2fg\7!\2\2gh\5\b\5\2h\7\3\2\2\2in\5\n\6\2jk\7\b\2\2km\5"+
		"\n\6\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\t\3\2\2\2pn\3\2\2\2qu"+
		"\58\35\2ru\5\f\7\2su\5\16\b\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\13\3\2\2"+
		"\2vw\7\6\2\2wx\5\22\n\2xy\7%\2\2yz\5\22\n\2z{\7\7\2\2{\r\3\2\2\2|}\7\6"+
		"\2\2}~\5\22\n\2~\177\7&\2\2\177\u0080\5\22\n\2\u0080\u0081\7\'\2\2\u0081"+
		"\u0082\7\6\2\2\u0082\u0083\5\20\t\2\u0083\u0084\7\7\2\2\u0084\u0085\7"+
		"\7\2\2\u0085\u0086\7\"\2\2\u0086\u0087\5\22\n\2\u0087\17\3\2\2\2\u0088"+
		"\u008d\5\32\16\2\u0089\u008a\7#\2\2\u008a\u008c\5\32\16\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\21\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\5P)\2\u0091\23\3\2\2\2\u0092"+
		"\u0093\7\36\2\2\u0093\u0094\5\26\f\2\u0094\25\3\2\2\2\u0095\u0098\5\30"+
		"\r\2\u0096\u0097\7#\2\2\u0097\u0099\5\26\f\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u009d\5\32\16\2\u009b\u009d\5\34"+
		"\17\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\31\3\2\2\2\u009e\u009f"+
		"\5\36\20\2\u009f\u00a0\5(\25\2\u00a0\u00a1\5 \21\2\u00a1\33\3\2\2\2\u00a2"+
		"\u00a3\7\6\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00a5\7$\2\2\u00a5\u00a6\5"+
		"\32\16\2\u00a6\u00a7\7\7\2\2\u00a7\35\3\2\2\2\u00a8\u00ab\58\35\2\u00a9"+
		"\u00ab\5&\24\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\37\3\2\2"+
		"\2\u00ac\u00b0\58\35\2\u00ad\u00b0\5&\24\2\u00ae\u00b0\5\"\22\2\u00af"+
		"\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0!\3\2\2\2"+
		"\u00b1\u00b5\5$\23\2\u00b2\u00b5\7*\2\2\u00b3\u00b5\7-\2\2\u00b4\u00b1"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5#\3\2\2\2\u00b6"+
		"\u00b7\7\3\2\2\u00b7\u00b8\7,\2\2\u00b8\u00b9\7\3\2\2\u00b9%\3\2\2\2\u00ba"+
		"\u00bb\5J&\2\u00bb\u00bc\7\5\2\2\u00bc\u00bd\5H%\2\u00bd\'\3\2\2\2\u00be"+
		"\u00bf\t\2\2\2\u00bf)\3\2\2\2\u00c0\u00c1\7\35\2\2\u00c1\u00c2\5,\27\2"+
		"\u00c2+\3\2\2\2\u00c3\u00c4\5B\"\2\u00c4-\3\2\2\2\u00c5\u00c6\7\34\2\2"+
		"\u00c6\u00c7\5\60\31\2\u00c7/\3\2\2\2\u00c8\u00cd\5\62\32\2\u00c9\u00ca"+
		"\7\b\2\2\u00ca\u00cc\5\62\32\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2"+
		"\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\61\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00d0\u00d1\5B\"\2\u00d1\u00d2\7\"\2\2\u00d2\u00d3\5F$\2\u00d3"+
		"\63\3\2\2\2\u00d4\u00d5\7\33\2\2\u00d5\u00d6\5\66\34\2\u00d6\65\3\2\2"+
		"\2\u00d7\u00d8\58\35\2\u00d8\67\3\2\2\2\u00d9\u00da\5N(\2\u00da\u00db"+
		"\7\6\2\2\u00db\u00e0\5:\36\2\u00dc\u00dd\7\b\2\2\u00dd\u00df\5:\36\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\7\2\2\u00e4"+
		"9\3\2\2\2\u00e5\u00e9\58\35\2\u00e6\u00e9\5&\24\2\u00e7\u00e9\5<\37\2"+
		"\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9;\3"+
		"\2\2\2\u00ea\u00f7\5P)\2\u00eb\u00ec\7\6\2\2\u00ec\u00f1\5P)\2\u00ed\u00ee"+
		"\7\b\2\2\u00ee\u00f0\5P)\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00f5\7\7\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00ea\3\2\2\2\u00f6"+
		"\u00eb\3\2\2\2\u00f7=\3\2\2\2\u00f8\u00f9\7(\2\2\u00f9\u00fe\5@!\2\u00fa"+
		"\u00fb\7(\2\2\u00fb\u00fd\5@!\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2"+
		"\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff?\3\2\2\2\u0100\u00fe"+
		"\3\2\2\2\u0101\u0102\5P)\2\u0102A\3\2\2\2\u0103\u0104\5L\'\2\u0104\u0105"+
		"\7\5\2\2\u0105\u0106\5D#\2\u0106C\3\2\2\2\u0107\u0108\5L\'\2\u0108E\3"+
		"\2\2\2\u0109\u010a\5L\'\2\u010aG\3\2\2\2\u010b\u010c\5P)\2\u010cI\3\2"+
		"\2\2\u010d\u010e\5P)\2\u010eK\3\2\2\2\u010f\u0110\5P)\2\u0110M\3\2\2\2"+
		"\u0111\u0112\5P)\2\u0112O\3\2\2\2\u0113\u0114\b)\1\2\u0114\u011c\7)\2"+
		"\2\u0115\u011c\5R*\2\u0116\u011c\7-\2\2\u0117\u0118\7\6\2\2\u0118\u0119"+
		"\5P)\2\u0119\u011a\7\7\2\2\u011a\u011c\3\2\2\2\u011b\u0113\3\2\2\2\u011b"+
		"\u0115\3\2\2\2\u011b\u0116\3\2\2\2\u011b\u0117\3\2\2\2\u011c\u0122\3\2"+
		"\2\2\u011d\u011e\f\3\2\2\u011e\u011f\7\5\2\2\u011f\u0121\5P)\4\u0120\u011d"+
		"\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"Q\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\t\3\2\2\u0126S\3\2\2\2\24U]"+
		"nt\u008d\u0098\u009c\u00aa\u00af\u00b4\u00cd\u00e0\u00e8\u00f1\u00f6\u00fe"+
		"\u011b\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}