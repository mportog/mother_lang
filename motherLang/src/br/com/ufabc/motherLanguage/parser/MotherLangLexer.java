// Generated from /Users/matheusporto/Documents/mother_lang/motherLang/MotherLang.g4 by ANTLR 4.7.1
package br.com.ufabc.motherLanguage.parser;

import br.com.ufabc.motherLanguage.ast.AbstractCommand;
import br.com.ufabc.motherLanguage.ast.MotherProgram;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;
import br.com.ufabc.motherLanguage.datastructures.MotherVariable;
import br.com.ufabc.motherLanguage.exception.MotherSemanticException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MotherLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, ASP=18, TEXT=19, 
		OPREL=20, ID=21, NUMBER=22, WS=23, BOOLEAN=24, TRUE=25, FALSE=26, AND=27, 
		OR=28, OPBINARY=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", 
		"ID", "NUMBER", "WS", "BOOLEAN", "TRUE", "FALSE", "AND", "OR", "OPBINARY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'('", "')'", "';'", null, "'='", 
		"','", "'{'", "'}'", "'\"'", null, null, null, null, null, null, "'vdd'", 
		"'falso'", "'e'", "'ou'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", "ID", 
		"NUMBER", "WS", "BOOLEAN", "TRUE", "FALSE", "AND", "OR", "OPBINARY"
	};
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private MotherSymbolTable symbolTable = new MotherSymbolTable();
		private MotherSymbol symbol;
		private MotherVariable variable;
		private MotherProgram program = new MotherProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;

		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new MotherSemanticException("Symbol "+id+" not declared");
			}
		}

		public void verificaInicializacao(String id) {
	        if(!symbolTable.get(id).isInit()) {
	            throw new MotherSemanticException("Variable "+id+" not initialized");
	        }
		}

	    public void verificaText(String id) {
	            verificaID(id);
	            MotherVariable var = symbolTable.get(id);
	            if(var.getType() != MotherVariable.TEXT){
	                throw new MotherSemanticException("variable " + var.getName() +"NOT A TEXT");
	            }
	    }

	    public void verificaNumero(String id) {
	            verificaID(id);
	            MotherVariable var = symbolTable.get(id);
	            if(var.getType() != MotherVariable.NUMBER){
	                throw new MotherSemanticException("variable " + var.getName() +"NOT A NUMBER");
	            }
	    }

	       public void verificaBooleano(String id) {
	                verificaID(id);
	                MotherVariable var = symbolTable.get(id);
	                if(var.getType() != MotherVariable.BOOLEAN){
	                    throw new MotherSemanticException("variable " + var.getName() +"NOT A BOOLEAN");
	                }
	        }

	    public void verificaUsoVars() {
	        for(MotherSymbol symbol : symbolTable.values()) {
	                MotherVariable var = (MotherVariable) symbol;
	            if(var.getValue() == null) {
	                    System.out.println("variable " + var.getName() + " not used");
	            }
	        }
	    }

		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}

		public void generateCode(){
			program.generateTarget();
		}


	public MotherLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MotherLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00d2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0092"+
		"\n\24\f\24\16\24\u0095\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u00a2\n\25\3\26\3\26\7\26\u00a6\n\26\f\26\16\26\u00a9"+
		"\13\26\3\27\6\27\u00ac\n\27\r\27\16\27\u00ad\3\27\3\27\6\27\u00b2\n\27"+
		"\r\27\16\27\u00b3\5\27\u00b6\n\27\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u00be"+
		"\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\5\36\u00d1\n\36\3\u0093\2\37\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\b\5\2,-//\61\61\4"+
		"\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00dd\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3"+
		"\2\2\2\5F\3\2\2\2\7O\3\2\2\2\tV\3\2\2\2\13\\\3\2\2\2\re\3\2\2\2\17j\3"+
		"\2\2\2\21r\3\2\2\2\23u\3\2\2\2\25{\3\2\2\2\27}\3\2\2\2\31\177\3\2\2\2"+
		"\33\u0081\3\2\2\2\35\u0083\3\2\2\2\37\u0085\3\2\2\2!\u0087\3\2\2\2#\u0089"+
		"\3\2\2\2%\u008b\3\2\2\2\'\u008d\3\2\2\2)\u00a1\3\2\2\2+\u00a3\3\2\2\2"+
		"-\u00ab\3\2\2\2/\u00b7\3\2\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\u00c3"+
		"\3\2\2\2\67\u00c9\3\2\2\29\u00cb\3\2\2\2;\u00d0\3\2\2\2=>\7r\2\2>?\7t"+
		"\2\2?@\7q\2\2@A\7i\2\2AB\7t\2\2BC\7c\2\2CD\7o\2\2DE\7c\2\2E\4\3\2\2\2"+
		"FG\7h\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7t\2\2KL\7q\2\2LM\7i\2\2MN\7=\2"+
		"\2N\6\3\2\2\2OP\7p\2\2PQ\7w\2\2QR\7o\2\2RS\7g\2\2ST\7t\2\2TU\7q\2\2U\b"+
		"\3\2\2\2VW\7v\2\2WX\7g\2\2XY\7z\2\2YZ\7v\2\2Z[\7q\2\2[\n\3\2\2\2\\]\7"+
		"d\2\2]^\7q\2\2^_\7q\2\2_`\7n\2\2`a\7g\2\2ab\7c\2\2bc\7p\2\2cd\7q\2\2d"+
		"\f\3\2\2\2ef\7n\2\2fg\7g\2\2gh\7k\2\2hi\7c\2\2i\16\3\2\2\2jk\7g\2\2kl"+
		"\7u\2\2lm\7e\2\2mn\7t\2\2no\7g\2\2op\7x\2\2pq\7c\2\2q\20\3\2\2\2rs\7u"+
		"\2\2st\7g\2\2t\22\3\2\2\2uv\7u\2\2vw\7g\2\2wx\7p\2\2xy\7c\2\2yz\7q\2\2"+
		"z\24\3\2\2\2{|\7*\2\2|\26\3\2\2\2}~\7+\2\2~\30\3\2\2\2\177\u0080\7=\2"+
		"\2\u0080\32\3\2\2\2\u0081\u0082\t\2\2\2\u0082\34\3\2\2\2\u0083\u0084\7"+
		"?\2\2\u0084\36\3\2\2\2\u0085\u0086\7.\2\2\u0086 \3\2\2\2\u0087\u0088\7"+
		"}\2\2\u0088\"\3\2\2\2\u0089\u008a\7\177\2\2\u008a$\3\2\2\2\u008b\u008c"+
		"\7$\2\2\u008c&\3\2\2\2\u008d\u0093\7$\2\2\u008e\u008f\7^\2\2\u008f\u0092"+
		"\7$\2\2\u0090\u0092\13\2\2\2\u0091\u008e\3\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7$\2\2\u0097(\3\2\2\2\u0098\u00a2"+
		"\t\3\2\2\u0099\u009a\7@\2\2\u009a\u00a2\7?\2\2\u009b\u009c\7>\2\2\u009c"+
		"\u00a2\7?\2\2\u009d\u009e\7?\2\2\u009e\u00a2\7?\2\2\u009f\u00a0\7#\2\2"+
		"\u00a0\u00a2\7?\2\2\u00a1\u0098\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u009b"+
		"\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2*\3\2\2\2\u00a3"+
		"\u00a7\t\4\2\2\u00a4\u00a6\t\5\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8,\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00ac\t\6\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b5\3\2\2\2\u00af\u00b1\7\60"+
		"\2\2\u00b0\u00b2\t\6\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00af\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6.\3\2\2\2\u00b7\u00b8\t\7\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\b\30\2\2\u00ba\60\3\2\2\2\u00bb\u00be\5\63\32\2\u00bc"+
		"\u00be\5\65\33\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\62\3\2"+
		"\2\2\u00bf\u00c0\7x\2\2\u00c0\u00c1\7f\2\2\u00c1\u00c2\7f\2\2\u00c2\64"+
		"\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7n\2\2\u00c6"+
		"\u00c7\7u\2\2\u00c7\u00c8\7q\2\2\u00c8\66\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"8\3\2\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7w\2\2\u00cd:\3\2\2\2\u00ce\u00d1"+
		"\5\67\34\2\u00cf\u00d1\59\35\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1<\3\2\2\2\r\2\u0091\u0093\u00a1\u00a5\u00a7\u00ad\u00b3\u00b5\u00bd"+
		"\u00d0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}