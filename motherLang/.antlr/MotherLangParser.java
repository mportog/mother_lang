// Generated from c:\Users\Samuel\Desktop\Compiladores - UFABC\mother_lang\motherLang\MotherLang.g4 by ANTLR 4.9.2

    import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
    import br.com.ufabc.motherLanguage.datastructures.MotherVariable;
    import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;
    import br.com.ufabc.motherLanguage.exception.MotherSemanticException;
    import br.com.ufabc.motherLanguage.datastructures.MotherVariableTypeEnum;
    import br.com.ufabc.motherLanguage.ast.*;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MotherLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, BOOL=19, AP=20, FP=21, SC=22, DP=23, OP=24, ATTR=25, VIR=26, 
		ACH=27, FCH=28, ASP=29, TEXT=30, OPREL=31, ID=32, NUMBER=33, WS=34, IC=35;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_var = 3, RULE_tipo = 4, 
		RULE_bloco = 5, RULE_cmd = 6, RULE_cmdleitura = 7, RULE_cmdescrita = 8, 
		RULE_cmdattrib = 9, RULE_cmdselecao = 10, RULE_cmdexponenciacao = 11, 
		RULE_cmdselecionacaso = 12, RULE_cmdenquanto = 13, RULE_cmdpara = 14, 
		RULE_expr = 15, RULE_termo = 16, RULE_termocaso = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "var", "tipo", "bloco", "cmd", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdselecao", "cmdexponenciacao", "cmdselecionacaso", 
			"cmdenquanto", "cmdpara", "expr", "termo", "termocaso"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
			"'leia'", "'escreva'", "'se'", "'senao'", "'elevado'", "'resulta'", "'seleciona'", 
			"'caso'", "'para'", "'nenhum'", "'enquanto'", "'conteate'", "'operacao'", 
			null, "'('", "')'", "';'", "':'", null, "'='", "','", "'{'", "'}'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "BOOL", "AP", "FP", "SC", "DP", 
			"OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", "ID", "NUMBER", 
			"WS", "IC"
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
	public String getGrammarFileName() { return "MotherLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private String DEFAULT_VALUE = "0";
		private MotherVariableTypeEnum _tipo;
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
	    private String _exprCondEnquanto;
	    private ArrayList<String> _listaExpCaso;
	    private ArrayList<ArrayList<AbstractCommand>> _listaCaso;
	    private ArrayList<AbstractCommand> _padraoCaso;
	    private ArrayList<AbstractCommand> _listaEnquanto;
	    private String _expressInit;
	    private String _expressInc;
	    private String _expressDecid;
	    private ArrayList<AbstractCommand> listarComando;

		public void verificaDeclacracaoExistenteID(String id) {
			if (!symbolTable.exists(id)){
				throw new MotherSemanticException("SYMBOL \""+id+"\" HAS NOT BEEN DECLARED");
			}
		}

		public void verificaDeclaracaoDuplaID(String id) {
		    if (!symbolTable.exists(_varName)){
	            symbolTable.add(variable);
	        }
	        else{
	            throw new MotherSemanticException("SYMBOL \""+_varName+"\" WAS ALREADY DECLARED");
	        }
	    }

		public MotherVariableTypeEnum getTipoId(String id){
		 return symbolTable.get(id).getType();
		}

		public void verificaInicializacao(String id)  {
	        if(!symbolTable.get(id).isInit()) {
	            throw new MotherSemanticException("VARIABLE \""+id+"\" WAS NOT INITIALIZED");
	        }
		}

		   public void verificaTipo(String id,MotherVariableTypeEnum tipoRecebido) {
		   	            MotherVariable var = symbolTable.get(id);
		   	            if(var.getType() != tipoRecebido){
		   				    throw new MotherSemanticException("VALUE SET TO VARIABLE \""+ var.getName() +"\" IS NOT THE SAME TYPE DECLARED.\nWanted: "+var.getType()+", got \""+tipoRecebido+"\" instead");
		   	            }
		   	    }

	    public void verificaUsoVars() {
		   	if(symbolTable.values().stream().anyMatch(variable -> variable.getValue() == null)) {
	   			for(MotherVariable variable : symbolTable.values()) {
	   				if(variable.getValue() == null) {
	   					System.out.println("WARNING: VARIABLE \"" + variable.getName() + "\" IS NEVER USED");
	   	    		}
	   		   	}
	   	   }
	   	}

		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}

		public void generateJavaCode(){
			program.generateJavaTarget();
		}

			public void generatePhytonCode(){
	    		program.generatePhytonTarget();
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
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			decl();
			setState(38);
			bloco();
			setState(39);
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
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				{
				setState(42);
				declaravar();
				}
				}
				setState(47);
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
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
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
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			tipo();
			setState(49);
			var();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(50);
				match(VIR);
				setState(51);
				var();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);

			      	      _varName = _input.LT(-1).getText();
			      	      _varValue = null;
			      	      variable = new MotherVariable(_varName, _tipo, _varValue);
			      	      verificaDeclaracaoDuplaID(_varName);
			           
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
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__2);
				 _tipo =MotherVariableTypeEnum.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__3);
				 _tipo = MotherVariableTypeEnum.TEXT;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(T__4);
				 _tipo = MotherVariableTypeEnum.BOOLEAN;  
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
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
				        stack.push(curThread);
			          
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0)) {
				{
				{
				setState(71);
				cmd();
				}
				}
				setState(76);
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
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				cmdselecao();
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				cmdexponenciacao();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				cmdselecionacaso();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				cmdenquanto();
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
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__5);
			setState(87);
			match(AP);
			setState(88);
			match(ID);
			 verificaDeclacracaoExistenteID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(90);
			match(FP);
			setState(91);
			match(SC);

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
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__6);
			setState(95);
			match(AP);
			setState(96);
			match(ID);
			 verificaDeclacracaoExistenteID(_input.LT(-1).getText());
				                  _writeID = _input.LT(-1).getText();
				                  verificaInicializacao(_writeID);
			                     
			setState(98);
			match(FP);
			setState(99);
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
		public TerminalNode BOOL() { return getToken(MotherLangParser.BOOL, 0); }
		public TerminalNode TEXT() { return getToken(MotherLangParser.TEXT, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(ID);
			 verificaDeclacracaoExistenteID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                   
			setState(104);
			match(ATTR);
			 _exprContent = ""; 
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
				{
				setState(106);
				expr();
				}
				break;
			case BOOL:
				{
				setState(107);
				match(BOOL);
				 verificaTipo(_exprID,MotherVariableTypeEnum.BOOLEAN);
				                        _exprContent += _input.LT(-1).getText() ;
				                      
				}
				break;
			case TEXT:
				{
				setState(109);
				match(TEXT);
				 verificaTipo(_exprID,MotherVariableTypeEnum.TEXT);
				                        _exprContent += _input.LT(-1).getText() ;
				                      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
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
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__7);
			setState(117);
			match(AP);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(118);
				match(ID);
				 _exprDecision = _input.LT(-1).getText(); 
				}
				break;
			case 2:
				{
				setState(120);
				match(ID);
				 _exprDecision = _input.LT(-1).getText(); 
				setState(122);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(124);
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
			setState(128);
			match(FP);
			setState(129);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>();
			                      stack.push(curThread);
			                    
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				cmd();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
			setState(136);
			match(FCH);

			                       listaTrue = stack.pop();
			                    
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(138);
				match(T__8);
				setState(139);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					cmd();
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
				}
				setState(146);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		
				}
			}

			CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
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
	}

	public final CmdexponenciacaoContext cmdexponenciacao() throws RecognitionException {
		CmdexponenciacaoContext _localctx = new CmdexponenciacaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdexponenciacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(AP);
			setState(154);
			match(NUMBER);
			_exprPowBase = _input.LT(-1).getText();
			setState(156);
			match(T__9);
			setState(157);
			match(NUMBER);
			_exprPowExp = _input.LT(-1).getText();
			setState(159);
			match(VIR);
			setState(160);
			match(T__10);
			setState(161);
			match(ID);

			                    verificaTipo(_input.LT(-1).getText(),MotherVariableTypeEnum.NUMBER);
			                    _exprPowRes = _input.LT(-1).getText();
			                    
			setState(163);
			match(FP);
			setState(164);
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
	}

	public final CmdselecionacasoContext cmdselecionacaso() throws RecognitionException {
		CmdselecionacasoContext _localctx = new CmdselecionacasoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdselecionacaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__11);
			setState(168);
			match(AP);
			setState(169);
			match(ID);
			 _exprSeleciona = _input.LT(-1).getText(); 
			setState(171);
			match(FP);
			setState(172);
			match(ACH);

			                     _listaExpCaso = new ArrayList<String>();
			                     _listaCaso = new ArrayList<ArrayList<AbstractCommand>>();
			                     _padraoCaso = new ArrayList<AbstractCommand>();
			                    
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				match(T__12);
				setState(175);
				termocaso();
				setState(176);
				match(DP);
				 curThread = new ArrayList<AbstractCommand>();
				                        stack.push(curThread);
				                      
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					cmd();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
				setState(183);
				match(T__13);
				setState(184);
				match(SC);

				                       _listaCaso.add(stack.pop());
				                      
				}
				}
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(191);
				match(T__14);
				setState(192);
				match(DP);
				 curThread = new ArrayList<AbstractCommand>();
				                         stack.push(curThread);
				                       
				setState(195); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(194);
					cmd();
					}
					}
					setState(197); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
				 _padraoCaso = stack.pop(); 
				}
			}

			setState(203);
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

	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MotherLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MotherLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MotherLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__15);
			setState(207);
			match(AP);
			setState(208);
			match(ID);

			                 verificaTipo(_input.LT(-1).getText(),MotherVariableTypeEnum.BOOLEAN);
			                 _exprCondEnquanto = _input.LT(-1).getText();
			                 
			setState(210);
			match(FP);
			setState(211);
			match(ACH);
			  curThread = new ArrayList<AbstractCommand>();
			                    stack.push(curThread);
			                 
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				cmd();
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
			 _listaEnquanto = stack.pop(); 
			setState(219);
			match(FCH);

			                    CommandEnquanto cmd = new CommandEnquanto(_exprCondEnquanto, _listaEnquanto);
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

	public static class CmdparaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MotherLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(MotherLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MotherLangParser.ID, i);
		}
		public TerminalNode ATTR() { return getToken(MotherLangParser.ATTR, 0); }
		public TerminalNode OPREL() { return getToken(MotherLangParser.OPREL, 0); }
		public TerminalNode IC() { return getToken(MotherLangParser.IC, 0); }
		public TerminalNode FP() { return getToken(MotherLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MotherLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MotherLangParser.FCH, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MotherLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MotherLangParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdparaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdpara; }
	}

	public final CmdparaContext cmdpara() throws RecognitionException {
		CmdparaContext _localctx = new CmdparaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdpara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__13);
			setState(223);
			match(AP);
			setState(224);
			match(ID);

								_expressInit = _input.LT(-1).getText();
								symbolTable.get(_expressInit).setUsed();
					  
			setState(226);
			match(ATTR);

						 		_expressInit += "=";
					  
			setState(228);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			                   	_expressInit += _input.LT(-1).getText();
					  
			setState(230);
			match(T__16);
			setState(231);
			match(ID);

								_expressInit = _input.LT(-1).getText();
					  
			setState(233);
			match(OPREL);

						 		_expressInit += _input.LT(-1).getText();
					  
			setState(235);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			                   	_expressInit += _input.LT(-1).getText();
					  
			setState(237);
			match(T__17);
			setState(238);
			match(ID);

								_expressInc = _input.LT(-1).getText();
					  
			setState(240);
			match(IC);

			 		  			_expressInc += "++";
			 		  
			setState(242);
			match(FP);
			setState(243);
			match(ACH);

								curThread; = new ArrayList<AbstractCommand>();
					            stack.push(currentThread);
					  
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(245);
				cmd();
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__11) | (1L << T__15) | (1L << AP) | (1L << ID))) != 0) );
			setState(250);
			match(FCH);

								listarComando = stack.pop();
								CommandPara cmd = new CommandPara(_exprForStart, _exprForDecision, _exprForIncrement,  listaComando);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			termo();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(254);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(256);
				termo();
				}
				}
				setState(261);
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
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_termo);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(ID);
				 verificaTipo(_exprID,MotherVariableTypeEnum.NUMBER);
				                    verificaInicializacao(_exprID);
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(NUMBER);
				  verificaTipo(_exprID,MotherVariableTypeEnum.NUMBER);
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
	}

	public final TermocasoContext termocaso() throws RecognitionException {
		TermocasoContext _localctx = new TermocasoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termocaso);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(ID);

				             verificaDeclacracaoExistenteID(_input.LT(-1).getText());
				             verificaInicializacao(_input.LT(-1).getText());
				             _listaExpCaso.add(_input.LT(-1).getText());
				            
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(NUMBER);

				             _listaExpCaso.add(_input.LT(-1).getText());
				            
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3"+
		"\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6G\n\6\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\bW\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13r\n\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0081\n\f"+
		"\3\f\3\f\3\f\3\f\6\f\u0087\n\f\r\f\16\f\u0088\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\6\f\u0091\n\f\r\f\16\f\u0092\3\f\3\f\3\f\5\f\u0098\n\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00b6\n\16\r\16\16\16\u00b7"+
		"\3\16\3\16\3\16\3\16\6\16\u00be\n\16\r\16\16\16\u00bf\3\16\3\16\3\16\3"+
		"\16\6\16\u00c6\n\16\r\16\16\16\u00c7\3\16\3\16\5\16\u00cc\n\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00d9\n\17\r\17"+
		"\16\17\u00da\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\6\20\u00f9\n\20\r\20\16\20\u00fa\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\7\21\u0104\n\21\f\21\16\21\u0107\13\21\3\22\3\22\3\22\3\22"+
		"\5\22\u010d\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0115\n\23\3\23\2"+
		"\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\"#\2\u011f\2"+
		"&\3\2\2\2\4/\3\2\2\2\6\62\3\2\2\2\b=\3\2\2\2\nF\3\2\2\2\fH\3\2\2\2\16"+
		"V\3\2\2\2\20X\3\2\2\2\22`\3\2\2\2\24h\3\2\2\2\26v\3\2\2\2\30\u009b\3\2"+
		"\2\2\32\u00a9\3\2\2\2\34\u00d0\3\2\2\2\36\u00e0\3\2\2\2 \u00ff\3\2\2\2"+
		"\"\u010c\3\2\2\2$\u0114\3\2\2\2&\'\7\3\2\2\'(\5\4\3\2()\5\f\7\2)*\7\4"+
		"\2\2*+\b\2\1\2+\3\3\2\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\5\n\6\2\638\5\b\5\2\64\65\7\34"+
		"\2\2\65\67\5\b\5\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3"+
		"\2\2\2:8\3\2\2\2;<\7\30\2\2<\7\3\2\2\2=>\7\"\2\2>?\b\5\1\2?\t\3\2\2\2"+
		"@A\7\5\2\2AG\b\6\1\2BC\7\6\2\2CG\b\6\1\2DE\7\7\2\2EG\b\6\1\2F@\3\2\2\2"+
		"FB\3\2\2\2FD\3\2\2\2G\13\3\2\2\2HL\b\7\1\2IK\5\16\b\2JI\3\2\2\2KN\3\2"+
		"\2\2LJ\3\2\2\2LM\3\2\2\2M\r\3\2\2\2NL\3\2\2\2OW\5\20\t\2PW\5\22\n\2QW"+
		"\5\24\13\2RW\5\26\f\2SW\5\30\r\2TW\5\32\16\2UW\5\34\17\2VO\3\2\2\2VP\3"+
		"\2\2\2VQ\3\2\2\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\17\3\2\2\2X"+
		"Y\7\b\2\2YZ\7\26\2\2Z[\7\"\2\2[\\\b\t\1\2\\]\7\27\2\2]^\7\30\2\2^_\b\t"+
		"\1\2_\21\3\2\2\2`a\7\t\2\2ab\7\26\2\2bc\7\"\2\2cd\b\n\1\2de\7\27\2\2e"+
		"f\7\30\2\2fg\b\n\1\2g\23\3\2\2\2hi\7\"\2\2ij\b\13\1\2jk\7\33\2\2kq\b\13"+
		"\1\2lr\5 \21\2mn\7\25\2\2nr\b\13\1\2op\7 \2\2pr\b\13\1\2ql\3\2\2\2qm\3"+
		"\2\2\2qo\3\2\2\2rs\3\2\2\2st\7\30\2\2tu\b\13\1\2u\25\3\2\2\2vw\7\n\2\2"+
		"w\u0080\7\26\2\2xy\7\"\2\2y\u0081\b\f\1\2z{\7\"\2\2{|\b\f\1\2|}\7!\2\2"+
		"}~\b\f\1\2~\177\t\2\2\2\177\u0081\b\f\1\2\u0080x\3\2\2\2\u0080z\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0083\7\27\2\2\u0083\u0084\7\35\2\2\u0084"+
		"\u0086\b\f\1\2\u0085\u0087\5\16\b\2\u0086\u0085\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7\36\2\2\u008b\u0097\b\f\1\2\u008c\u008d\7\13\2\2\u008d\u008e\7"+
		"\35\2\2\u008e\u0090\b\f\1\2\u008f\u0091\5\16\b\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\7\36\2\2\u0095\u0096\b\f\1\2\u0096\u0098\3\2\2\2\u0097"+
		"\u008c\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\f"+
		"\1\2\u009a\27\3\2\2\2\u009b\u009c\7\26\2\2\u009c\u009d\7#\2\2\u009d\u009e"+
		"\b\r\1\2\u009e\u009f\7\f\2\2\u009f\u00a0\7#\2\2\u00a0\u00a1\b\r\1\2\u00a1"+
		"\u00a2\7\34\2\2\u00a2\u00a3\7\r\2\2\u00a3\u00a4\7\"\2\2\u00a4\u00a5\b"+
		"\r\1\2\u00a5\u00a6\7\27\2\2\u00a6\u00a7\7\30\2\2\u00a7\u00a8\b\r\1\2\u00a8"+
		"\31\3\2\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\7\26\2\2\u00ab\u00ac\7\""+
		"\2\2\u00ac\u00ad\b\16\1\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\7\35\2\2\u00af"+
		"\u00bd\b\16\1\2\u00b0\u00b1\7\17\2\2\u00b1\u00b2\5$\23\2\u00b2\u00b3\7"+
		"\31\2\2\u00b3\u00b5\b\16\1\2\u00b4\u00b6\5\16\b\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\7\20\2\2\u00ba\u00bb\7\30\2\2\u00bb\u00bc\b\16\1"+
		"\2\u00bc\u00be\3\2\2\2\u00bd\u00b0\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00cb\3\2\2\2\u00c1\u00c2\7\21\2\2"+
		"\u00c2\u00c3\7\31\2\2\u00c3\u00c5\b\16\1\2\u00c4\u00c6\5\16\b\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\16\1\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c1\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\36"+
		"\2\2\u00ce\u00cf\b\16\1\2\u00cf\33\3\2\2\2\u00d0\u00d1\7\22\2\2\u00d1"+
		"\u00d2\7\26\2\2\u00d2\u00d3\7\"\2\2\u00d3\u00d4\b\17\1\2\u00d4\u00d5\7"+
		"\27\2\2\u00d5\u00d6\7\35\2\2\u00d6\u00d8\b\17\1\2\u00d7\u00d9\5\16\b\2"+
		"\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b\17\1\2\u00dd\u00de\7\36\2\2"+
		"\u00de\u00df\b\17\1\2\u00df\35\3\2\2\2\u00e0\u00e1\7\20\2\2\u00e1\u00e2"+
		"\7\26\2\2\u00e2\u00e3\7\"\2\2\u00e3\u00e4\b\20\1\2\u00e4\u00e5\7\33\2"+
		"\2\u00e5\u00e6\b\20\1\2\u00e6\u00e7\t\2\2\2\u00e7\u00e8\b\20\1\2\u00e8"+
		"\u00e9\7\23\2\2\u00e9\u00ea\7\"\2\2\u00ea\u00eb\b\20\1\2\u00eb\u00ec\7"+
		"!\2\2\u00ec\u00ed\b\20\1\2\u00ed\u00ee\t\2\2\2\u00ee\u00ef\b\20\1\2\u00ef"+
		"\u00f0\7\24\2\2\u00f0\u00f1\7\"\2\2\u00f1\u00f2\b\20\1\2\u00f2\u00f3\7"+
		"%\2\2\u00f3\u00f4\b\20\1\2\u00f4\u00f5\7\27\2\2\u00f5\u00f6\7\35\2\2\u00f6"+
		"\u00f8\b\20\1\2\u00f7\u00f9\5\16\b\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\7\36\2\2\u00fd\u00fe\b\20\1\2\u00fe\37\3\2\2\2\u00ff\u0105\5\""+
		"\22\2\u0100\u0101\7\32\2\2\u0101\u0102\b\21\1\2\u0102\u0104\5\"\22\2\u0103"+
		"\u0100\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106!\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\"\2\2\u0109\u010d"+
		"\b\22\1\2\u010a\u010b\7#\2\2\u010b\u010d\b\22\1\2\u010c\u0108\3\2\2\2"+
		"\u010c\u010a\3\2\2\2\u010d#\3\2\2\2\u010e\u010f\7\"\2\2\u010f\u0115\b"+
		"\23\1\2\u0110\u0111\7#\2\2\u0111\u0115\b\23\1\2\u0112\u0113\7 \2\2\u0113"+
		"\u0115\b\23\1\2\u0114\u010e\3\2\2\2\u0114\u0110\3\2\2\2\u0114\u0112\3"+
		"\2\2\2\u0115%\3\2\2\2\25/8FLVq\u0080\u0088\u0092\u0097\u00b7\u00bf\u00c7"+
		"\u00cb\u00da\u00fa\u0105\u010c\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}