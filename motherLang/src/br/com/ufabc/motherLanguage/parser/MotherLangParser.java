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
		T__9=10, AP=11, FP=12, SC=13, OP=14, ATTR=15, VIR=16, ACH=17, FCH=18, 
		ASP=19, TEXT=20, OPREL=21, ID=22, NUMBER=23, WS=24, BOOLEAN=25, TRUE=26, 
		FALSE=27, AND=28, OR=29, OPBINARY=30;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdexponenciacao = 10, RULE_expr = 11, RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdexponenciacao", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'elevado'", "'('", "')'", "';'", 
		null, "'='", "','", "'{'", "'}'", "'\"'", null, null, null, null, null, 
		null, "'true'", "'false'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "AP", 
		"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", 
		"ID", "NUMBER", "WS", "BOOLEAN", "TRUE", "FALSE", "AND", "OR", "OPBINARY"
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
		private String _exprPowRes;
		private String _exprPowExp;
		private String _exprPowBase;

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
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			bloco();
			setState(29);
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(37);
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
			setState(38);
			tipo();
			setState(39);
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
			                    
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(41);
				match(VIR);
				setState(42);
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
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__2);
				 _tipo = MotherVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(T__3);
				 _tipo = MotherVariable.TEXT;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
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
			          
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << BOOLEAN))) != 0)) {
				{
				{
				setState(60);
				cmd();
				}
				}
				setState(65);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdleitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdselecao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdexponenciacao();
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
			setState(73);
			match(T__5);
			setState(74);
			match(AP);
			setState(75);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(77);
			match(FP);
			setState(78);
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
			setState(81);
			match(T__6);
			setState(82);
			match(AP);
			setState(83);
			match(ID);
			 verificaID(_input.LT(-1).getText());
				                  _writeID = _input.LT(-1).getText();
				                  verificaInicializacao(_writeID);
			                     
			setState(85);
			match(FP);
			setState(86);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(89);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                   
			setState(91);
			match(ATTR);
			 _exprContent = ""; 
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(93);
				expr();
				}
				break;
			case 2:
				{
				setState(94);
				match(TEXT);
				 verificaText(_exprID);
				                            _exprContent += _input.LT(-1).getText() ;
				                      
				}
				break;
			}
			setState(98);
			match(SC);

			                 MotherVariable var = (MotherVariable)symbolTable.get(_exprID);
			                 var.setInit(true);
			                 var.setValue(_exprContent);
			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
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
		public List<TerminalNode> ID() { return getTokens(MotherLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MotherLangParser.ID, i);
		}
		public List<TerminalNode> OPREL() { return getTokens(MotherLangParser.OPREL); }
		public TerminalNode OPREL(int i) {
			return getToken(MotherLangParser.OPREL, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(MotherLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MotherLangParser.NUMBER, i);
		}
		public List<TerminalNode> OPBINARY() { return getTokens(MotherLangParser.OPBINARY); }
		public TerminalNode OPBINARY(int i) {
			return getToken(MotherLangParser.OPBINARY, i);
		}
		public TerminalNode BOOLEAN() { return getToken(MotherLangParser.BOOLEAN, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(MotherLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(MotherLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(MotherLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(MotherLangParser.FCH, i);
		}
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
			int _alt;
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(T__7);
				setState(102);
				match(AP);
				{
				setState(103);
				match(ID);
				 _exprDecision = _input.LT(-1).getText(); 
				setState(105);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(107);
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
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(109);
						match(ID);
						 _exprDecision = _input.LT(-1).getText(); 
						setState(111);
						match(OPREL);
						 _exprDecision += _input.LT(-1).getText(); 
						setState(113);
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
						setState(115);
						match(OPBINARY);
						 _exprDecision += _input.LT(-1).getText(); 
						setState(117);
						match(ID);
						 _exprDecision = _input.LT(-1).getText(); 
						setState(119);
						match(OPREL);
						 _exprDecision += _input.LT(-1).getText(); 
						setState(121);
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
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(125); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(BOOLEAN);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(129);
				match(FP);
				setState(130);
				match(ACH);
				 curThread = new ArrayList<AbstractCommand>();
				                      stack.push(curThread);
				                    
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					cmd();
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << BOOLEAN))) != 0) );
				setState(137);
				match(FCH);

				                       listaTrue = stack.pop();
				                    
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(139);
					match(T__8);
					setState(140);
					match(ACH);

					                   	 	curThread = new ArrayList<AbstractCommand>();
					                   	 	stack.push(curThread);
					                   	 
					{
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(142);
						cmd();
						}
						}
						setState(145); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << ID) | (1L << BOOLEAN))) != 0) );
					}
					setState(147);
					match(FCH);

					                   		listaFalse = stack.pop();
					                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
					                   		stack.peek().add(cmd);
					                   	
					}
				}

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

	public static class CmdexponenciacaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MotherLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MotherLangParser.NUMBER, i);
		}
		public TerminalNode VIR() { return getToken(MotherLangParser.VIR, 0); }
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
			setState(154);
			match(T__9);
			setState(155);
			match(AP);
			setState(156);
			match(NUMBER);
			_exprPowBase = _input.LT(-1).getText();
			setState(158);
			match(VIR);
			setState(159);
			match(NUMBER);
			_exprPowExp = _input.LT(-1).getText();
			setState(161);
			match(FP);
			setState(162);
			match(SC);

			                     CommandExponenciacao cmd = new CommandExponenciacao(_exprPowBase, _exprPowExp);
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
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			termo();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(166);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(168);
				termo();
				}
				}
				setState(173);
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
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                    verificaInicializacao(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00b9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3$\n\3\f\3"+
		"\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\7\6@\n\6\f\6\16\6C\13\6\3\7"+
		"\3\7\3\7\3\7\3\7\5\7J\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nc\n\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13~\n\13\r\13\16\13\177\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\6\13\u0088\n\13\r\13\16\13\u0089\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\6\13\u0092\n\13\r\13\16\13\u0093\3\13\3\13\3\13\5\13"+
		"\u0099\n\13\5\13\u009b\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\7\r\u00ac\n\r\f\r\16\r\u00af\13\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00b7\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\2\3\3\2\30\31\2\u00be\2\34\3\2\2\2\4%\3\2\2\2\6(\3\2\2\2\b;\3\2\2"+
		"\2\n=\3\2\2\2\fI\3\2\2\2\16K\3\2\2\2\20S\3\2\2\2\22[\3\2\2\2\24\u009a"+
		"\3\2\2\2\26\u009c\3\2\2\2\30\u00a7\3\2\2\2\32\u00b6\3\2\2\2\34\35\7\3"+
		"\2\2\35\36\5\4\3\2\36\37\5\n\6\2\37 \7\4\2\2 !\b\2\1\2!\3\3\2\2\2\"$\5"+
		"\6\4\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2"+
		"()\5\b\5\2)*\7\30\2\2*\60\b\4\1\2+,\7\22\2\2,-\7\30\2\2-/\b\4\1\2.+\3"+
		"\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2"+
		"\2\63\64\7\17\2\2\64\7\3\2\2\2\65\66\7\5\2\2\66<\b\5\1\2\678\7\6\2\28"+
		"<\b\5\1\29:\7\7\2\2:<\b\5\1\2;\65\3\2\2\2;\67\3\2\2\2;9\3\2\2\2<\t\3\2"+
		"\2\2=A\b\6\1\2>@\5\f\7\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\13\3"+
		"\2\2\2CA\3\2\2\2DJ\5\16\b\2EJ\5\20\t\2FJ\5\22\n\2GJ\5\24\13\2HJ\5\26\f"+
		"\2ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\r\3\2\2\2KL\7\b"+
		"\2\2LM\7\r\2\2MN\7\30\2\2NO\b\b\1\2OP\7\16\2\2PQ\7\17\2\2QR\b\b\1\2R\17"+
		"\3\2\2\2ST\7\t\2\2TU\7\r\2\2UV\7\30\2\2VW\b\t\1\2WX\7\16\2\2XY\7\17\2"+
		"\2YZ\b\t\1\2Z\21\3\2\2\2[\\\7\30\2\2\\]\b\n\1\2]^\7\21\2\2^b\b\n\1\2_"+
		"c\5\30\r\2`a\7\26\2\2ac\b\n\1\2b_\3\2\2\2b`\3\2\2\2cd\3\2\2\2de\7\17\2"+
		"\2ef\b\n\1\2f\23\3\2\2\2gh\7\n\2\2hi\7\r\2\2ij\7\30\2\2jk\b\13\1\2kl\7"+
		"\27\2\2lm\b\13\1\2mn\t\2\2\2n\u009b\b\13\1\2op\7\30\2\2pq\b\13\1\2qr\7"+
		"\27\2\2rs\b\13\1\2st\t\2\2\2tu\b\13\1\2uv\7 \2\2vw\b\13\1\2wx\7\30\2\2"+
		"xy\b\13\1\2yz\7\27\2\2z{\b\13\1\2{|\t\2\2\2|~\b\13\1\2}o\3\2\2\2~\177"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u009b\3\2\2\2\u0081\u0082"+
		"\7\33\2\2\u0082\u0083\b\13\1\2\u0083\u0084\7\16\2\2\u0084\u0085\7\23\2"+
		"\2\u0085\u0087\b\13\1\2\u0086\u0088\5\f\7\2\u0087\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008c\7\24\2\2\u008c\u0098\b\13\1\2\u008d\u008e\7\13\2\2\u008e"+
		"\u008f\7\23\2\2\u008f\u0091\b\13\1\2\u0090\u0092\5\f\7\2\u0091\u0090\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0096\7\24\2\2\u0096\u0097\b\13\1\2\u0097\u0099\3"+
		"\2\2\2\u0098\u008d\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"g\3\2\2\2\u009a}\3\2\2\2\u009a\u0081\3\2\2\2\u009b\25\3\2\2\2\u009c\u009d"+
		"\7\f\2\2\u009d\u009e\7\r\2\2\u009e\u009f\7\31\2\2\u009f\u00a0\b\f\1\2"+
		"\u00a0\u00a1\7\22\2\2\u00a1\u00a2\7\31\2\2\u00a2\u00a3\b\f\1\2\u00a3\u00a4"+
		"\7\16\2\2\u00a4\u00a5\7\17\2\2\u00a5\u00a6\b\f\1\2\u00a6\27\3\2\2\2\u00a7"+
		"\u00ad\5\32\16\2\u00a8\u00a9\7\20\2\2\u00a9\u00aa\b\r\1\2\u00aa\u00ac"+
		"\5\32\16\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\31\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1"+
		"\7\30\2\2\u00b1\u00b7\b\16\1\2\u00b2\u00b3\7\31\2\2\u00b3\u00b7\b\16\1"+
		"\2\u00b4\u00b5\7\26\2\2\u00b5\u00b7\b\16\1\2\u00b6\u00b0\3\2\2\2\u00b6"+
		"\u00b2\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\33\3\2\2\2\17%\60;AIb\177\u0089"+
		"\u0093\u0098\u009a\u00ad\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
	
}