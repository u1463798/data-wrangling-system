// Generated from /Users/tsvetanminkov/git/data-wrangling-compiler/src/main/grammar/D2wl.g4 by ANTLR 4.7.2
package com.wrangling.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class D2wlLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "EQ", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "NOT_EQ1", "NOT_EQ2", "SELECT", 
			"FROM", "TO", "WHERE", "WRANGLE", "GROUP", "BY", "AS", "AND", "OR", "UNION", 
			"JOIN", "ON", "IMPORT", "IDENTIFIER", "TIME_LITERAL", "COL", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SPACES", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z"
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


	public D2wlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "D2wl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u01b0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0112\n"+
		"(\f(\16(\u0115\13(\3(\3(\3(\3(\3(\7(\u011c\n(\f(\16(\u011f\13(\3(\3(\3"+
		"(\7(\u0124\n(\f(\16(\u0127\13(\3(\3(\3(\7(\u012c\n(\f(\16(\u012f\13(\5"+
		"(\u0131\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3+\6+\u0141\n+\r+\16"+
		"+\u0142\3+\3+\7+\u0147\n+\f+\16+\u014a\13+\5+\u014c\n+\3+\3+\5+\u0150"+
		"\n+\3+\6+\u0153\n+\r+\16+\u0154\5+\u0157\n+\3+\3+\6+\u015b\n+\r+\16+\u015c"+
		"\3+\3+\5+\u0161\n+\3+\6+\u0164\n+\r+\16+\u0165\5+\u0168\n+\5+\u016a\n"+
		"+\3,\3,\3,\3,\7,\u0170\n,\f,\16,\u0173\13,\3,\3,\3-\3-\3-\3-\3.\3.\3/"+
		"\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3"+
		"\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3"+
		"A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\2\2I\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177"+
		"\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\3\2"+
		"%\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\5\2\13\r\17"+
		"\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2II"+
		"ii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2"+
		"RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4"+
		"\2[[{{\4\2\\\\||\2\u01aa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3\u0091\3\2\2\2"+
		"\5\u0093\3\2\2\2\7\u0095\3\2\2\2\t\u0097\3\2\2\2\13\u0099\3\2\2\2\r\u009b"+
		"\3\2\2\2\17\u009d\3\2\2\2\21\u009f\3\2\2\2\23\u00a1\3\2\2\2\25\u00a3\3"+
		"\2\2\2\27\u00a5\3\2\2\2\31\u00a7\3\2\2\2\33\u00aa\3\2\2\2\35\u00ac\3\2"+
		"\2\2\37\u00ae\3\2\2\2!\u00b1\3\2\2\2#\u00b4\3\2\2\2%\u00b6\3\2\2\2\'\u00b8"+
		"\3\2\2\2)\u00ba\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3\2\2\2/\u00c2\3\2\2\2\61"+
		"\u00c5\3\2\2\2\63\u00c8\3\2\2\2\65\u00cf\3\2\2\2\67\u00d4\3\2\2\29\u00d7"+
		"\3\2\2\2;\u00dd\3\2\2\2=\u00e5\3\2\2\2?\u00eb\3\2\2\2A\u00ee\3\2\2\2C"+
		"\u00f1\3\2\2\2E\u00f5\3\2\2\2G\u00f8\3\2\2\2I\u00fe\3\2\2\2K\u0103\3\2"+
		"\2\2M\u0106\3\2\2\2O\u0130\3\2\2\2Q\u0132\3\2\2\2S\u013d\3\2\2\2U\u0169"+
		"\3\2\2\2W\u016b\3\2\2\2Y\u0176\3\2\2\2[\u017a\3\2\2\2]\u017c\3\2\2\2_"+
		"\u017e\3\2\2\2a\u0180\3\2\2\2c\u0182\3\2\2\2e\u0184\3\2\2\2g\u0186\3\2"+
		"\2\2i\u0188\3\2\2\2k\u018a\3\2\2\2m\u018c\3\2\2\2o\u018e\3\2\2\2q\u0190"+
		"\3\2\2\2s\u0192\3\2\2\2u\u0194\3\2\2\2w\u0196\3\2\2\2y\u0198\3\2\2\2{"+
		"\u019a\3\2\2\2}\u019c\3\2\2\2\177\u019e\3\2\2\2\u0081\u01a0\3\2\2\2\u0083"+
		"\u01a2\3\2\2\2\u0085\u01a4\3\2\2\2\u0087\u01a6\3\2\2\2\u0089\u01a8\3\2"+
		"\2\2\u008b\u01aa\3\2\2\2\u008d\u01ac\3\2\2\2\u008f\u01ae\3\2\2\2\u0091"+
		"\u0092\7)\2\2\u0092\4\3\2\2\2\u0093\u0094\7=\2\2\u0094\6\3\2\2\2\u0095"+
		"\u0096\7\60\2\2\u0096\b\3\2\2\2\u0097\u0098\7*\2\2\u0098\n\3\2\2\2\u0099"+
		"\u009a\7+\2\2\u009a\f\3\2\2\2\u009b\u009c\7.\2\2\u009c\16\3\2\2\2\u009d"+
		"\u009e\7?\2\2\u009e\20\3\2\2\2\u009f\u00a0\7,\2\2\u00a0\22\3\2\2\2\u00a1"+
		"\u00a2\7-\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4\26\3\2\2\2\u00a5"+
		"\u00a6\7\u0080\2\2\u00a6\30\3\2\2\2\u00a7\u00a8\7~\2\2\u00a8\u00a9\7~"+
		"\2\2\u00a9\32\3\2\2\2\u00aa\u00ab\7\61\2\2\u00ab\34\3\2\2\2\u00ac\u00ad"+
		"\7\'\2\2\u00ad\36\3\2\2\2\u00ae\u00af\7>\2\2\u00af\u00b0\7>\2\2\u00b0"+
		" \3\2\2\2\u00b1\u00b2\7@\2\2\u00b2\u00b3\7@\2\2\u00b3\"\3\2\2\2\u00b4"+
		"\u00b5\7(\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7~\2\2\u00b7&\3\2\2\2\u00b8\u00b9"+
		"\7>\2\2\u00b9(\3\2\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bc\7?\2\2\u00bc*\3"+
		"\2\2\2\u00bd\u00be\7@\2\2\u00be,\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0\u00c1"+
		"\7?\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\7?\2\2\u00c4\60"+
		"\3\2\2\2\u00c5\u00c6\7>\2\2\u00c6\u00c7\7@\2\2\u00c7\62\3\2\2\2\u00c8"+
		"\u00c9\5\u0081A\2\u00c9\u00ca\5e\63\2\u00ca\u00cb\5s:\2\u00cb\u00cc\5"+
		"e\63\2\u00cc\u00cd\5a\61\2\u00cd\u00ce\5\u0083B\2\u00ce\64\3\2\2\2\u00cf"+
		"\u00d0\5g\64\2\u00d0\u00d1\5\177@\2\u00d1\u00d2\5y=\2\u00d2\u00d3\5u;"+
		"\2\u00d3\66\3\2\2\2\u00d4\u00d5\5\u0083B\2\u00d5\u00d6\5y=\2\u00d68\3"+
		"\2\2\2\u00d7\u00d8\5\u0089E\2\u00d8\u00d9\5k\66\2\u00d9\u00da\5e\63\2"+
		"\u00da\u00db\5\177@\2\u00db\u00dc\5e\63\2\u00dc:\3\2\2\2\u00dd\u00de\5"+
		"\u0089E\2\u00de\u00df\5\177@\2\u00df\u00e0\5]/\2\u00e0\u00e1\5w<\2\u00e1"+
		"\u00e2\5i\65\2\u00e2\u00e3\5s:\2\u00e3\u00e4\5e\63\2\u00e4<\3\2\2\2\u00e5"+
		"\u00e6\5i\65\2\u00e6\u00e7\5\177@\2\u00e7\u00e8\5y=\2\u00e8\u00e9\5\u0085"+
		"C\2\u00e9\u00ea\5{>\2\u00ea>\3\2\2\2\u00eb\u00ec\5_\60\2\u00ec\u00ed\5"+
		"\u008dG\2\u00ed@\3\2\2\2\u00ee\u00ef\5]/\2\u00ef\u00f0\5\u0081A\2\u00f0"+
		"B\3\2\2\2\u00f1\u00f2\5]/\2\u00f2\u00f3\5w<\2\u00f3\u00f4\5c\62\2\u00f4"+
		"D\3\2\2\2\u00f5\u00f6\5y=\2\u00f6\u00f7\5\177@\2\u00f7F\3\2\2\2\u00f8"+
		"\u00f9\5\u0085C\2\u00f9\u00fa\5w<\2\u00fa\u00fb\5m\67\2\u00fb\u00fc\5"+
		"y=\2\u00fc\u00fd\5w<\2\u00fdH\3\2\2\2\u00fe\u00ff\5o8\2\u00ff\u0100\5"+
		"y=\2\u0100\u0101\5m\67\2\u0101\u0102\5w<\2\u0102J\3\2\2\2\u0103\u0104"+
		"\5y=\2\u0104\u0105\5w<\2\u0105L\3\2\2\2\u0106\u0107\5m\67\2\u0107\u0108"+
		"\5u;\2\u0108\u0109\5{>\2\u0109\u010a\5y=\2\u010a\u010b\5\177@\2\u010b"+
		"\u010c\5\u0083B\2\u010cN\3\2\2\2\u010d\u0113\7$\2\2\u010e\u0112\n\2\2"+
		"\2\u010f\u0110\7$\2\2\u0110\u0112\7$\2\2\u0111\u010e\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0131\7$\2\2\u0117\u011d\7b\2"+
		"\2\u0118\u011c\n\3\2\2\u0119\u011a\7b\2\2\u011a\u011c\7b\2\2\u011b\u0118"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0131\7b"+
		"\2\2\u0121\u0125\7]\2\2\u0122\u0124\n\4\2\2\u0123\u0122\3\2\2\2\u0124"+
		"\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0128\u0131\7_\2\2\u0129\u012d\t\5\2\2\u012a"+
		"\u012c\t\6\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u010d\3\2\2\2\u0130\u0117\3\2\2\2\u0130\u0121\3\2\2\2\u0130\u0129\3\2"+
		"\2\2\u0131P\3\2\2\2\u0132\u0133\7)\2\2\u0133\u0134\5[.\2\u0134\u0135\5"+
		"[.\2\u0135\u0136\5S*\2\u0136\u0137\5[.\2\u0137\u0138\5[.\2\u0138\u0139"+
		"\5S*\2\u0139\u013a\5[.\2\u013a\u013b\5[.\2\u013b\u013c\7)\2\2\u013cR\3"+
		"\2\2\2\u013d\u013e\7<\2\2\u013eT\3\2\2\2\u013f\u0141\5[.\2\u0140\u013f"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u014b\3\2\2\2\u0144\u0148\7\60\2\2\u0145\u0147\5[.\2\u0146\u0145\3\2"+
		"\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u0144\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u0156\3\2\2\2\u014d\u014f\5e\63\2\u014e\u0150\t\7\2\2\u014f"+
		"\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0153\5["+
		".\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u014d\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u016a\3\2\2\2\u0158\u015a\7\60\2\2\u0159\u015b\5[.\2\u015a"+
		"\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\u0167\3\2\2\2\u015e\u0160\5e\63\2\u015f\u0161\t\7\2\2\u0160"+
		"\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0164\5["+
		".\2\u0163\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u015e\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u016a\3\2\2\2\u0169\u0140\3\2\2\2\u0169\u0158\3\2\2\2\u016a"+
		"V\3\2\2\2\u016b\u0171\7)\2\2\u016c\u0170\n\b\2\2\u016d\u016e\7)\2\2\u016e"+
		"\u0170\7)\2\2\u016f\u016c\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0173\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174\u0175\7)\2\2\u0175X\3\2\2\2\u0176\u0177\t\t\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0179\b-\2\2\u0179Z\3\2\2\2\u017a\u017b\t\n\2\2\u017b"+
		"\\\3\2\2\2\u017c\u017d\t\13\2\2\u017d^\3\2\2\2\u017e\u017f\t\f\2\2\u017f"+
		"`\3\2\2\2\u0180\u0181\t\r\2\2\u0181b\3\2\2\2\u0182\u0183\t\16\2\2\u0183"+
		"d\3\2\2\2\u0184\u0185\t\17\2\2\u0185f\3\2\2\2\u0186\u0187\t\20\2\2\u0187"+
		"h\3\2\2\2\u0188\u0189\t\21\2\2\u0189j\3\2\2\2\u018a\u018b\t\22\2\2\u018b"+
		"l\3\2\2\2\u018c\u018d\t\23\2\2\u018dn\3\2\2\2\u018e\u018f\t\24\2\2\u018f"+
		"p\3\2\2\2\u0190\u0191\t\25\2\2\u0191r\3\2\2\2\u0192\u0193\t\26\2\2\u0193"+
		"t\3\2\2\2\u0194\u0195\t\27\2\2\u0195v\3\2\2\2\u0196\u0197\t\30\2\2\u0197"+
		"x\3\2\2\2\u0198\u0199\t\31\2\2\u0199z\3\2\2\2\u019a\u019b\t\32\2\2\u019b"+
		"|\3\2\2\2\u019c\u019d\t\33\2\2\u019d~\3\2\2\2\u019e\u019f\t\34\2\2\u019f"+
		"\u0080\3\2\2\2\u01a0\u01a1\t\35\2\2\u01a1\u0082\3\2\2\2\u01a2\u01a3\t"+
		"\36\2\2\u01a3\u0084\3\2\2\2\u01a4\u01a5\t\37\2\2\u01a5\u0086\3\2\2\2\u01a6"+
		"\u01a7\t \2\2\u01a7\u0088\3\2\2\2\u01a8\u01a9\t!\2\2\u01a9\u008a\3\2\2"+
		"\2\u01aa\u01ab\t\"\2\2\u01ab\u008c\3\2\2\2\u01ac\u01ad\t#\2\2\u01ad\u008e"+
		"\3\2\2\2\u01ae\u01af\t$\2\2\u01af\u0090\3\2\2\2\27\2\u0111\u0113\u011b"+
		"\u011d\u0125\u012d\u0130\u0142\u0148\u014b\u014f\u0154\u0156\u015c\u0160"+
		"\u0165\u0167\u0169\u016f\u0171\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}