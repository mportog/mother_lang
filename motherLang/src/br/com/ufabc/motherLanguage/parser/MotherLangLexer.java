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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, BOOL=16, AP=17, 
		FP=18, SC=19, DP=20, OP=21, ATTR=22, VIR=23, ACH=24, FCH=25, ASP=26, TEXT=27, 
		OPREL=28, ID=29, NUMBER=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "BOOL", "AP", "FP", 
		"SC", "DP", "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", 
		"ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'elevado'", "'resulta'", "'seleciona'", 
		"'caso'", "'para'", "'nenhum'", null, "'('", "')'", "';'", "':'", null, 
		"'='", "','", "'{'", "'}'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "BOOL", "AP", "FP", "SC", "DP", "OP", "ATTR", 
		"VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", "ID", "NUMBER", "WS"
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


	private String DEFAULT_VALUE = "0";
		private int _tipo;
		private String _varName, _varValue;
		private MotherSymbolTable symbolTable = new MotherSymbolTable();
		private MotherSymbol symbol;
		private MotherVariable variable;
		private MotherProgram program = new MotherProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID, _exprContent, _exprDecision;
		private ArrayList<AbstractCommand> listaTrue, listaFalse;
		private String _exprPowExp, _exprPowBase, _exprPowRes;
	    private String _exprSeleciona;
	    private ArrayList<String> _listaExpCaso;
	    private ArrayList<ArrayList<AbstractCommand>> _listaCaso;
	    private ArrayList<AbstractCommand> _padraoCaso;


		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new MotherSemanticException("Symbol "+id+" not declared");
			}
		}

		public int getTipoId(String id){
		 return symbolTable.get(id).getType();
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
	                throw new MotherSemanticException("Variable " + var.getName() +" not a text type - types mismatch");
	            }
	    }

	    public void verificaNumero(String id) {
	            verificaID(id);
	            MotherVariable var = symbolTable.get(id);
	            if(var.getType() != MotherVariable.NUMBER){
	                throw new MotherSemanticException("variable " + var.getName() +" not a number type - types mismatch");
	            }
	    }

	       public void verificaBooleano(String id) {
	                verificaID(id);
	                MotherVariable var = symbolTable.get(id);
	                if(var.getType() != MotherVariable.BOOLEAN){
	                    throw new MotherSemanticException("variable " + var.getName() +" not a boolean type - types mismatch");
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00f9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b3"+
		"\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u00cd\n\34"+
		"\f\34\16\34\u00d0\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\5\35\u00dd\n\35\3\36\3\36\7\36\u00e1\n\36\f\36\16\36\u00e4\13"+
		"\36\3\37\5\37\u00e7\n\37\3\37\6\37\u00ea\n\37\r\37\16\37\u00eb\3\37\3"+
		"\37\6\37\u00f0\n\37\r\37\16\37\u00f1\5\37\u00f4\n\37\3 \3 \3 \3 \3\u00ce"+
		"\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13"+
		"\f\17\17\"\"\2\u0104\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5J\3\2\2\2"+
		"\7S\3\2\2\2\tZ\3\2\2\2\13`\3\2\2\2\ri\3\2\2\2\17n\3\2\2\2\21v\3\2\2\2"+
		"\23y\3\2\2\2\25\177\3\2\2\2\27\u0087\3\2\2\2\31\u008f\3\2\2\2\33\u0099"+
		"\3\2\2\2\35\u009e\3\2\2\2\37\u00a3\3\2\2\2!\u00b2\3\2\2\2#\u00b4\3\2\2"+
		"\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00ba\3\2\2\2+\u00bc\3\2\2\2-\u00be"+
		"\3\2\2\2/\u00c0\3\2\2\2\61\u00c2\3\2\2\2\63\u00c4\3\2\2\2\65\u00c6\3\2"+
		"\2\2\67\u00c8\3\2\2\29\u00dc\3\2\2\2;\u00de\3\2\2\2=\u00e6\3\2\2\2?\u00f5"+
		"\3\2\2\2AB\7r\2\2BC\7t\2\2CD\7q\2\2DE\7i\2\2EF\7t\2\2FG\7c\2\2GH\7o\2"+
		"\2HI\7c\2\2I\4\3\2\2\2JK\7h\2\2KL\7k\2\2LM\7o\2\2MN\7r\2\2NO\7t\2\2OP"+
		"\7q\2\2PQ\7i\2\2QR\7=\2\2R\6\3\2\2\2ST\7p\2\2TU\7w\2\2UV\7o\2\2VW\7g\2"+
		"\2WX\7t\2\2XY\7q\2\2Y\b\3\2\2\2Z[\7v\2\2[\\\7g\2\2\\]\7z\2\2]^\7v\2\2"+
		"^_\7q\2\2_\n\3\2\2\2`a\7d\2\2ab\7q\2\2bc\7q\2\2cd\7n\2\2de\7g\2\2ef\7"+
		"c\2\2fg\7p\2\2gh\7q\2\2h\f\3\2\2\2ij\7n\2\2jk\7g\2\2kl\7k\2\2lm\7c\2\2"+
		"m\16\3\2\2\2no\7g\2\2op\7u\2\2pq\7e\2\2qr\7t\2\2rs\7g\2\2st\7x\2\2tu\7"+
		"c\2\2u\20\3\2\2\2vw\7u\2\2wx\7g\2\2x\22\3\2\2\2yz\7u\2\2z{\7g\2\2{|\7"+
		"p\2\2|}\7c\2\2}~\7q\2\2~\24\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2"+
		"\2\u0081\u0082\7g\2\2\u0082\u0083\7x\2\2\u0083\u0084\7c\2\2\u0084\u0085"+
		"\7f\2\2\u0085\u0086\7q\2\2\u0086\26\3\2\2\2\u0087\u0088\7t\2\2\u0088\u0089"+
		"\7g\2\2\u0089\u008a\7u\2\2\u008a\u008b\7w\2\2\u008b\u008c\7n\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u008e\7c\2\2\u008e\30\3\2\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093\u0094\7e\2\2"+
		"\u0094\u0095\7k\2\2\u0095\u0096\7q\2\2\u0096\u0097\7p\2\2\u0097\u0098"+
		"\7c\2\2\u0098\32\3\2\2\2\u0099\u009a\7e\2\2\u009a\u009b\7c\2\2\u009b\u009c"+
		"\7u\2\2\u009c\u009d\7q\2\2\u009d\34\3\2\2\2\u009e\u009f\7r\2\2\u009f\u00a0"+
		"\7c\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7c\2\2\u00a2\36\3\2\2\2\u00a3\u00a4"+
		"\7p\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7j\2\2\u00a7"+
		"\u00a8\7w\2\2\u00a8\u00a9\7o\2\2\u00a9 \3\2\2\2\u00aa\u00ab\7x\2\2\u00ab"+
		"\u00ac\7f\2\2\u00ac\u00b3\7f\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7c\2\2"+
		"\u00af\u00b0\7n\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b3\7q\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b3\"\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5"+
		"$\3\2\2\2\u00b6\u00b7\7+\2\2\u00b7&\3\2\2\2\u00b8\u00b9\7=\2\2\u00b9("+
		"\3\2\2\2\u00ba\u00bb\7<\2\2\u00bb*\3\2\2\2\u00bc\u00bd\t\2\2\2\u00bd,"+
		"\3\2\2\2\u00be\u00bf\7?\2\2\u00bf.\3\2\2\2\u00c0\u00c1\7.\2\2\u00c1\60"+
		"\3\2\2\2\u00c2\u00c3\7}\2\2\u00c3\62\3\2\2\2\u00c4\u00c5\7\177\2\2\u00c5"+
		"\64\3\2\2\2\u00c6\u00c7\7$\2\2\u00c7\66\3\2\2\2\u00c8\u00ce\7$\2\2\u00c9"+
		"\u00ca\7^\2\2\u00ca\u00cd\7$\2\2\u00cb\u00cd\13\2\2\2\u00cc\u00c9\3\2"+
		"\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7$"+
		"\2\2\u00d28\3\2\2\2\u00d3\u00dd\t\3\2\2\u00d4\u00d5\7@\2\2\u00d5\u00dd"+
		"\7?\2\2\u00d6\u00d7\7>\2\2\u00d7\u00dd\7?\2\2\u00d8\u00d9\7?\2\2\u00d9"+
		"\u00dd\7?\2\2\u00da\u00db\7#\2\2\u00db\u00dd\7?\2\2\u00dc\u00d3\3\2\2"+
		"\2\u00dc\u00d4\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dd:\3\2\2\2\u00de\u00e2\t\4\2\2\u00df\u00e1\t\5\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3<\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\7/\2\2\u00e6\u00e5"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00ea\t\6\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00f3\3\2\2\2\u00ed\u00ef\7\60\2\2\u00ee\u00f0\t\6\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		">\3\2\2\2\u00f5\u00f6\t\7\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b \2\2\u00f8"+
		"@\3\2\2\2\r\2\u00b2\u00cc\u00ce\u00dc\u00e0\u00e2\u00e6\u00eb\u00f1\u00f3"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}