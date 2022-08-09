// Generated from /Users/matheusporto/Documents/mother_lang/motherLang/MotherLang.g4 by ANTLR 4.7.1
package br.com.ufabc.motherLanguage.parser;

import br.com.ufabc.motherLanguage.ast.*;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;
import br.com.ufabc.motherLanguage.datastructures.MotherVariable;
import br.com.ufabc.motherLanguage.exception.MotherSemanticException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MotherLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, BOOL=16, AP=17, 
		FP=18, SC=19, DP=20, OP=21, ATTR=22, VIR=23, ACH=24, FCH=25, ASP=26, TEXT=27, 
		OPREL=28, ID=29, NUMBER=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdexponenciacao = 10, RULE_cmdselecionacaso = 11, 
		RULE_expr = 12, RULE_termo = 13, RULE_termocaso = 14;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdexponenciacao", "cmdselecionacaso", "expr", 
		"termo", "termocaso"
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

	@Override
	public String getGrammarFileName() { return "MotherLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public MotherLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			decl();
			setState(32);
			bloco();
			setState(33);
			match(T__1);
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	  verificaUsoVars();
			           
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				{
				setState(36);
				declaravar();
				}
				}
				setState(41);
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MotherLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MotherLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(MotherLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(MotherLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(MotherLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			tipo();
			setState(43);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  variable = new MotherVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(variable);
				                  }
				                  else{
				                  	 throw new MotherSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(45);
				match(VIR);
				setState(46);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  variable = new MotherVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(variable);
					                  }
					                  else{
					                  	 throw new MotherSemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__2);
				 _tipo = MotherVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__3);
				 _tipo = MotherVariable.TEXT;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__4);
				 _tipo = MotherVariable.BOOLEAN;  
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
				        stack.push(curThread);
			          
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << AP) | (1L << ID))) != 0)) {
				{
				{
				setState(64);
				cmd();
				}
				}
				setState(69);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdexponenciacaoContext cmdexponenciacao() {
			return getRuleContext(CmdexponenciacaoContext.class,0);
		}
		public CmdselecionacasoContext cmdselecionacaso() {
			return getRuleContext(CmdselecionacasoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				cmdselecao();
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				cmdexponenciacao();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				cmdselecionacaso();
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(MotherLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__5);
			setState(79);
			match(AP);
			setState(80);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(82);
			match(FP);
			setState(83);
			match(SC);
			 verificaID(_readID);
			              	MotherVariable var = symbolTable.get(_readID);
			              	var.setInit(true);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(MotherLangParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__6);
			setState(87);
			match(AP);
			setState(88);
			match(ID);
			 verificaID(_input.LT(-1).getText());
				                  _writeID = _input.LT(-1).getText();
				                  verificaInicializacao(_writeID);
			                     
			setState(90);
			match(FP);
			setState(91);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(MotherLangParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(MotherLangParser.SC, 0); }
		public CmdexponenciacaoContext cmdexponenciacao() {
			return getRuleContext(CmdexponenciacaoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(MotherLangParser.BOOL, 0); }
		public TerminalNode TEXT() { return getToken(MotherLangParser.TEXT, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                   
			setState(96);
			match(ATTR);
			 _exprContent = ""; 
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(98);
				cmdexponenciacao();
				}
				break;
			case 2:
				{
				setState(99);
				expr();
				}
				break;
			case 3:
				{
				setState(100);
				match(BOOL);
				 verificaBooleano(_exprID);
				                        _exprContent += _input.LT(-1).getText() ;
				                      
				}
				break;
			case 4:
				{
				setState(102);
				match(TEXT);
				 verificaText(_exprID);
				                        _exprContent += _input.LT(-1).getText() ;
				                      
				}
				break;
			}
			setState(106);
			match(SC);

			                 MotherVariable var = (MotherVariable)symbolTable.get(_exprID);
			                 var.setInit(true);
			                 var.setValue(_exprContent);
			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent,  getTipoId(_exprID));
			               	 stack.peek().add(cmd);
			               
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

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(MotherLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(MotherLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(MotherLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(MotherLangParser.FCH, i);
		}
		public List<TerminalNode> ID() { return getTokens(MotherLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MotherLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(MotherLangParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(MotherLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__7);
			setState(110);
			match(AP);
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(111);
				match(ID);
				 _exprDecision = _input.LT(-1).getText(); 
				}
				break;
			case 2:
				{
				setState(113);
				match(ID);
				 _exprDecision = _input.LT(-1).getText(); 
				setState(115);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				_exprDecision += _input.LT(-1).getText(); 
				}
				break;
			}
			setState(121);
			match(FP);
			setState(122);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>();
			                      stack.push(curThread);
			                    
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				cmd();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << AP) | (1L << ID))) != 0) );
			setState(129);
			match(FCH);

			                       listaTrue = stack.pop();
			                    
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(131);
				match(T__8);
				setState(132);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					cmd();
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << AP) | (1L << ID))) != 0) );
				}
				setState(139);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
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

	public static class CmdexponenciacaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MotherLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MotherLangParser.NUMBER, i);
		}
		public TerminalNode VIR() { return getToken(MotherLangParser.VIR, 0); }
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(MotherLangParser.SC, 0); }
		public CmdexponenciacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexponenciacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdexponenciacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdexponenciacao(this);
		}
	}

	public final CmdexponenciacaoContext cmdexponenciacao() throws RecognitionException {
		CmdexponenciacaoContext _localctx = new CmdexponenciacaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdexponenciacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(AP);
			setState(145);
			match(NUMBER);
			_exprPowBase = _input.LT(-1).getText();
			setState(147);
			match(T__9);
			setState(148);
			match(NUMBER);
			_exprPowExp = _input.LT(-1).getText();
			setState(150);
			match(VIR);
			setState(151);
			match(T__10);
			setState(152);
			match(ID);

			                    verificaNumero(_input.LT(-1).getText());
			                    _exprPowRes = _input.LT(-1).getText();
			                    
			setState(154);
			match(FP);
			setState(155);
			match(SC);

			                     MotherVariable var = (MotherVariable)symbolTable.get(_exprPowRes);
			                                     var.setInit(true);
			                                     var.setValue(DEFAULT_VALUE);
			                     CommandExponenciacao cmd = new CommandExponenciacao(_exprPowBase, _exprPowExp,_exprPowRes);
			                     stack.peek().add(cmd);
			                    
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

	public static class CmdselecionacasoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MotherLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MotherLangParser.FCH, 0); }
		public List<TermocasoContext> termocaso() {
			return getRuleContexts(TermocasoContext.class);
		}
		public TermocasoContext termocaso(int i) {
			return getRuleContext(TermocasoContext.class,i);
		}
		public List<TerminalNode> DP() { return getTokens(MotherLangParser.DP); }
		public TerminalNode DP(int i) {
			return getToken(MotherLangParser.DP, i);
		}
		public List<TerminalNode> SC() { return getTokens(MotherLangParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(MotherLangParser.SC, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecionacasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecionacaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterCmdselecionacaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitCmdselecionacaso(this);
		}
	}

	public final CmdselecionacasoContext cmdselecionacaso() throws RecognitionException {
		CmdselecionacasoContext _localctx = new CmdselecionacasoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdselecionacaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__11);
			setState(159);
			match(AP);
			setState(160);
			match(ID);
			 _exprSeleciona = _input.LT(-1).getText(); 
			setState(162);
			match(FP);
			setState(163);
			match(ACH);

			                     _listaExpCaso = new ArrayList<String>();
			                     _listaCaso = new ArrayList<ArrayList<AbstractCommand>>();
			                     _padraoCaso = new ArrayList<AbstractCommand>();
			                    
			setState(178); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				match(T__12);
				setState(166);
				termocaso();
				setState(167);
				match(DP);
				 curThread = new ArrayList<AbstractCommand>();
				                        stack.push(curThread);
				                      
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(169);
					cmd();
					}
					}
					setState(172); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << AP) | (1L << ID))) != 0) );
				setState(174);
				match(T__13);
				setState(175);
				match(SC);

				                       _listaCaso.add(stack.pop());
				                      
				}
				}
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(182);
				match(T__14);
				setState(183);
				match(DP);
				 curThread = new ArrayList<AbstractCommand>();
				                         stack.push(curThread);
				                       
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(185);
					cmd();
					}
					}
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << AP) | (1L << ID))) != 0) );
				 _padraoCaso = stack.pop(); 
				}
			}

			setState(194);
			match(FCH);

			                      CommandCaso cmd = new CommandCaso(_exprSeleciona, _listaExpCaso, _listaCaso, _padraoCaso);
			                      stack.peek().add(cmd);
			                    
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(MotherLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(MotherLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			termo();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(198);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(200);
				termo();
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(MotherLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(MotherLangParser.TEXT, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    verificaInicializacao(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(TEXT);

				                _exprContent += _input.LT(-1).getText();
				              
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

	public static class TermocasoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(MotherLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(MotherLangParser.TEXT, 0); }
		public TermocasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termocaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).enterTermocaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MotherLangListener ) ((MotherLangListener)listener).exitTermocaso(this);
		}
	}

	public final TermocasoContext termocaso() throws RecognitionException {
		TermocasoContext _localctx = new TermocasoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termocaso);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(ID);

				             verificaID(_input.LT(-1).getText());
				             verificaInicializacao(_input.LT(-1).getText());
				             _listaExpCaso.add(_input.LT(-1).getText());
				            
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(NUMBER);

				             _listaExpCaso.add(_input.LT(-1).getText());
				            
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(TEXT);

				             _listaExpCaso.add(_input.LT(-1).getText());
				            
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4\f"+
		"\4\16\4\66\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\7\6D"+
		"\n\6\f\6\16\6G\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\nk\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13z\n\13\3\13\3\13\3\13\3\13\6\13\u0080\n\13\r\13"+
		"\16\13\u0081\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u008a\n\13\r\13\16\13"+
		"\u008b\3\13\3\13\3\13\5\13\u0091\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\6\r\u00ad\n\r\r\r\16\r\u00ae\3\r\3\r\3\r\3\r\6\r\u00b5\n\r\r\r\16\r"+
		"\u00b6\3\r\3\r\3\r\3\r\6\r\u00bd\n\r\r\r\16\r\u00be\3\r\3\r\5\r\u00c3"+
		"\n\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00cc\n\16\f\16\16\16\u00cf"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d7\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00df\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36\2\3\3\2\37 \2\u00eb\2 \3\2\2\2\4)\3\2\2\2\6,\3\2\2\2\b?\3\2"+
		"\2\2\nA\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2\22`\3\2\2\2\24o\3\2"+
		"\2\2\26\u0092\3\2\2\2\30\u00a0\3\2\2\2\32\u00c7\3\2\2\2\34\u00d6\3\2\2"+
		"\2\36\u00de\3\2\2\2 !\7\3\2\2!\"\5\4\3\2\"#\5\n\6\2#$\7\4\2\2$%\b\2\1"+
		"\2%\3\3\2\2\2&(\5\6\4\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3"+
		"\2\2\2+)\3\2\2\2,-\5\b\5\2-.\7\37\2\2.\64\b\4\1\2/\60\7\31\2\2\60\61\7"+
		"\37\2\2\61\63\b\4\1\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3"+
		"\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\25\2\28\7\3\2\2\29:\7\5\2\2:"+
		"@\b\5\1\2;<\7\6\2\2<@\b\5\1\2=>\7\7\2\2>@\b\5\1\2?9\3\2\2\2?;\3\2\2\2"+
		"?=\3\2\2\2@\t\3\2\2\2AE\b\6\1\2BD\5\f\7\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2"+
		"\2EF\3\2\2\2F\13\3\2\2\2GE\3\2\2\2HO\5\16\b\2IO\5\20\t\2JO\5\22\n\2KO"+
		"\5\24\13\2LO\5\26\f\2MO\5\30\r\2NH\3\2\2\2NI\3\2\2\2NJ\3\2\2\2NK\3\2\2"+
		"\2NL\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PQ\7\b\2\2QR\7\23\2\2RS\7\37\2\2ST\b"+
		"\b\1\2TU\7\24\2\2UV\7\25\2\2VW\b\b\1\2W\17\3\2\2\2XY\7\t\2\2YZ\7\23\2"+
		"\2Z[\7\37\2\2[\\\b\t\1\2\\]\7\24\2\2]^\7\25\2\2^_\b\t\1\2_\21\3\2\2\2"+
		"`a\7\37\2\2ab\b\n\1\2bc\7\30\2\2cj\b\n\1\2dk\5\26\f\2ek\5\32\16\2fg\7"+
		"\22\2\2gk\b\n\1\2hi\7\35\2\2ik\b\n\1\2jd\3\2\2\2je\3\2\2\2jf\3\2\2\2j"+
		"h\3\2\2\2kl\3\2\2\2lm\7\25\2\2mn\b\n\1\2n\23\3\2\2\2op\7\n\2\2py\7\23"+
		"\2\2qr\7\37\2\2rz\b\13\1\2st\7\37\2\2tu\b\13\1\2uv\7\36\2\2vw\b\13\1\2"+
		"wx\t\2\2\2xz\b\13\1\2yq\3\2\2\2ys\3\2\2\2z{\3\2\2\2{|\7\24\2\2|}\7\32"+
		"\2\2}\177\b\13\1\2~\u0080\5\f\7\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\33"+
		"\2\2\u0084\u0090\b\13\1\2\u0085\u0086\7\13\2\2\u0086\u0087\7\32\2\2\u0087"+
		"\u0089\b\13\1\2\u0088\u008a\5\f\7\2\u0089\u0088\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\7\33\2\2\u008e\u008f\b\13\1\2\u008f\u0091\3\2\2\2\u0090\u0085\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\25\3\2\2\2\u0092\u0093\7\23\2\2\u0093"+
		"\u0094\7 \2\2\u0094\u0095\b\f\1\2\u0095\u0096\7\f\2\2\u0096\u0097\7 \2"+
		"\2\u0097\u0098\b\f\1\2\u0098\u0099\7\31\2\2\u0099\u009a\7\r\2\2\u009a"+
		"\u009b\7\37\2\2\u009b\u009c\b\f\1\2\u009c\u009d\7\24\2\2\u009d\u009e\7"+
		"\25\2\2\u009e\u009f\b\f\1\2\u009f\27\3\2\2\2\u00a0\u00a1\7\16\2\2\u00a1"+
		"\u00a2\7\23\2\2\u00a2\u00a3\7\37\2\2\u00a3\u00a4\b\r\1\2\u00a4\u00a5\7"+
		"\24\2\2\u00a5\u00a6\7\32\2\2\u00a6\u00b4\b\r\1\2\u00a7\u00a8\7\17\2\2"+
		"\u00a8\u00a9\5\36\20\2\u00a9\u00aa\7\26\2\2\u00aa\u00ac\b\r\1\2\u00ab"+
		"\u00ad\5\f\7\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\20\2\2\u00b1"+
		"\u00b2\7\25\2\2\u00b2\u00b3\b\r\1\2\u00b3\u00b5\3\2\2\2\u00b4\u00a7\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00c2\3\2\2\2\u00b8\u00b9\7\21\2\2\u00b9\u00ba\7\26\2\2\u00ba\u00bc\b"+
		"\r\1\2\u00bb\u00bd\5\f\7\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\r"+
		"\1\2\u00c1\u00c3\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\7\33\2\2\u00c5\u00c6\b\r\1\2\u00c6\31\3\2\2"+
		"\2\u00c7\u00cd\5\34\17\2\u00c8\u00c9\7\27\2\2\u00c9\u00ca\b\16\1\2\u00ca"+
		"\u00cc\5\34\17\2\u00cb\u00c8\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\33\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\7\37\2\2\u00d1\u00d7\b\17\1\2\u00d2\u00d3\7 \2\2\u00d3\u00d7\b"+
		"\17\1\2\u00d4\u00d5\7\35\2\2\u00d5\u00d7\b\17\1\2\u00d6\u00d0\3\2\2\2"+
		"\u00d6\u00d2\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\35\3\2\2\2\u00d8\u00d9"+
		"\7\37\2\2\u00d9\u00df\b\20\1\2\u00da\u00db\7 \2\2\u00db\u00df\b\20\1\2"+
		"\u00dc\u00dd\7\35\2\2\u00dd\u00df\b\20\1\2\u00de\u00d8\3\2\2\2\u00de\u00da"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\37\3\2\2\2\23)\64?ENjy\u0081\u008b"+
		"\u0090\u00ae\u00b6\u00be\u00c2\u00cd\u00d6\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}