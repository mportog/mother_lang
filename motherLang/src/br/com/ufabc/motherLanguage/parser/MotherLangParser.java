// Generated from /Users/matheusporto/Documents/mother_lang/motherLang/MotherLang.g4 by ANTLR 4.10.1
package br.com.ufabc.motherLanguage.parser;

import br.com.ufabc.motherLanguage.ast.*;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;
import br.com.ufabc.motherLanguage.datastructures.MotherVariable;
import br.com.ufabc.motherLanguage.exception.MotherLanguageException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MotherLangParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, AP = 9,
            FP = 10, SC = 11, OP = 12, ATTR = 13, VIR = 14, ACH = 15, FCH = 16, ASP = 17, TEXT = 18,
            OPREL = 19, ID = 20, NUMBER = 21, WS = 22;
    public static final int
            RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4,
            RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8,
            RULE_cmdselecao = 9, RULE_expr = 10, RULE_termo = 11;

    private static String[] makeRuleNames() {
        return new String[]{
                "prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita",
                "cmdattrib", "cmdselecao", "expr", "termo"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'",
                "'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", "'{'", "'}'",
                "'\"'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, "AP", "FP", "SC",
                "OP", "ATTR", "VIR", "ACH", "FCH", "ASP", "TEXT", "OPREL", "ID", "NUMBER",
                "WS"
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
    public String getGrammarFileName() {
        return "MotherLang.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
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

    public void verificaID(String id) {
        if (!symbolTable.exists(id)) {
            throw new MotherLanguageException("Symbol " + id + " not declared");
        }
    }

    public void verificaInicializacao(String id) {
        if (!symbolTable.get(id).isInit()) {
            throw new MotherLanguageException("Variable " + id + " not init");
        }
    }

    public void verificaText(String id) {
        verificaID(id);
        MotherVariable var = symbolTable.get(id);
        if (var.getType() != MotherVariable.TEXT) {
            throw new MotherLanguageException("variable " + var.getName() + "NOT A TEXT");
        }
    }

    public void verificaNumero(String id) {
        verificaID(id);
        MotherVariable var = symbolTable.get(id);
        if (var.getType() != MotherVariable.NUMBER) {
            throw new MotherLanguageException("variable " + var.getName() + "NOT A NUMBER");
        }
    }

    public void verificaUsoVars() {
        for (MotherSymbol symbol : symbolTable.values()) {
            MotherVariable var = (MotherVariable) symbol;
            if (var.getValue() == null) {
                System.out.println("variable " + var.getName() + " not used");
            }
        }
    }

    public void exibeComandos() {
        for (AbstractCommand c : program.getComandos()) {
            System.out.println(c);
        }
    }

    public void generateCode() {
        program.generateTarget();
    }

    public MotherLangParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgContext extends ParserRuleContext {
        public DeclContext decl() {
            return getRuleContext(DeclContext.class, 0);
        }

        public BlocoContext bloco() {
            return getRuleContext(BlocoContext.class, 0);
        }

        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitProg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor) return ((MotherLangVisitor<? extends T>) visitor).visitProg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(24);
                match(T__0);
                setState(25);
                decl();
                setState(26);
                bloco();
                setState(27);
                match(T__1);
                program.setVarTable(symbolTable);
                program.setComandos(stack.pop());
                verificaUsoVars();

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeclContext extends ParserRuleContext {
        public List<DeclaravarContext> declaravar() {
            return getRuleContexts(DeclaravarContext.class);
        }

        public DeclaravarContext declaravar(int i) {
            return getRuleContext(DeclaravarContext.class, i);
        }

        public DeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_decl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterDecl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitDecl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor) return ((MotherLangVisitor<? extends T>) visitor).visitDecl(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeclContext decl() throws RecognitionException {
        DeclContext _localctx = new DeclContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_decl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(30);
                            declaravar();
                        }
                    }
                    setState(33);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__2 || _la == T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeclaravarContext extends ParserRuleContext {
        public TipoContext tipo() {
            return getRuleContext(TipoContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(MotherLangParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(MotherLangParser.ID, i);
        }

        public TerminalNode SC() {
            return getToken(MotherLangParser.SC, 0);
        }

        public List<TerminalNode> VIR() {
            return getTokens(MotherLangParser.VIR);
        }

        public TerminalNode VIR(int i) {
            return getToken(MotherLangParser.VIR, i);
        }

        public DeclaravarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declaravar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterDeclaravar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitDeclaravar(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitDeclaravar(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeclaravarContext declaravar() throws RecognitionException {
        DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_declaravar);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                tipo();
                setState(36);
                match(ID);

                _varName = _input.LT(-1).getText();
                _varValue = null;
                variable = new MotherVariable(_varName, _tipo, _varValue);
                if (!symbolTable.exists(_varName)) {
                    symbolTable.add(variable);
                } else {
                    throw new MotherLanguageException("Symbol " + _varName + " already declared");
                }

                setState(43);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == VIR) {
                    {
                        {
                            setState(38);
                            match(VIR);
                            setState(39);
                            match(ID);

                            _varName = _input.LT(-1).getText();
                            _varValue = null;
                            variable = new MotherVariable(_varName, _tipo, _varValue);
                            if (!symbolTable.exists(_varName)) {
                                symbolTable.add(variable);
                            } else {
                                throw new MotherLanguageException("Symbol " + _varName + " already declared");
                            }

                        }
                    }
                    setState(45);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(46);
                match(SC);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TipoContext extends ParserRuleContext {
        public TipoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tipo;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterTipo(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitTipo(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor) return ((MotherLangVisitor<? extends T>) visitor).visitTipo(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TipoContext tipo() throws RecognitionException {
        TipoContext _localctx = new TipoContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_tipo);
        try {
            setState(52);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__2:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(48);
                    match(T__2);
                    _tipo = MotherVariable.NUMBER;
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(50);
                    match(T__3);
                    _tipo = MotherVariable.TEXT;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BlocoContext extends ParserRuleContext {
        public List<CmdContext> cmd() {
            return getRuleContexts(CmdContext.class);
        }

        public CmdContext cmd(int i) {
            return getRuleContext(CmdContext.class, i);
        }

        public BlocoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bloco;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterBloco(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitBloco(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitBloco(this);
            else return visitor.visitChildren(this);
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

                setState(56);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(55);
                            cmd();
                        }
                    }
                    setState(58);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CmdContext extends ParserRuleContext {
        public CmdleituraContext cmdleitura() {
            return getRuleContext(CmdleituraContext.class, 0);
        }

        public CmdescritaContext cmdescrita() {
            return getRuleContext(CmdescritaContext.class, 0);
        }

        public CmdattribContext cmdattrib() {
            return getRuleContext(CmdattribContext.class, 0);
        }

        public CmdselecaoContext cmdselecao() {
            return getRuleContext(CmdselecaoContext.class, 0);
        }

        public CmdContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cmd;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterCmd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitCmd(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor) return ((MotherLangVisitor<? extends T>) visitor).visitCmd(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CmdContext cmd() throws RecognitionException {
        CmdContext _localctx = new CmdContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_cmd);
        try {
            setState(64);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__4:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(60);
                    cmdleitura();
                }
                break;
                case T__5:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(61);
                    cmdescrita();
                }
                break;
                case ID:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(62);
                    cmdattrib();
                }
                break;
                case T__6:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(63);
                    cmdselecao();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CmdleituraContext extends ParserRuleContext {
        public TerminalNode AP() {
            return getToken(MotherLangParser.AP, 0);
        }

        public TerminalNode ID() {
            return getToken(MotherLangParser.ID, 0);
        }

        public TerminalNode FP() {
            return getToken(MotherLangParser.FP, 0);
        }

        public TerminalNode SC() {
            return getToken(MotherLangParser.SC, 0);
        }

        public CmdleituraContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cmdleitura;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterCmdleitura(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitCmdleitura(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitCmdleitura(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CmdleituraContext cmdleitura() throws RecognitionException {
        CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_cmdleitura);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(66);
                match(T__4);
                setState(67);
                match(AP);
                setState(68);
                match(ID);
                verificaID(_input.LT(-1).getText());
                _readID = _input.LT(-1).getText();

                setState(70);
                match(FP);
                setState(71);
                match(SC);
                verificaID(_readID);
                MotherVariable var = symbolTable.get(_readID);
                var.setInit(true);
                CommandLeitura cmd = new CommandLeitura(_readID, var);
                stack.peek().add(cmd);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CmdescritaContext extends ParserRuleContext {
        public TerminalNode AP() {
            return getToken(MotherLangParser.AP, 0);
        }

        public TerminalNode ID() {
            return getToken(MotherLangParser.ID, 0);
        }

        public TerminalNode FP() {
            return getToken(MotherLangParser.FP, 0);
        }

        public TerminalNode SC() {
            return getToken(MotherLangParser.SC, 0);
        }

        public CmdescritaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cmdescrita;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterCmdescrita(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitCmdescrita(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitCmdescrita(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CmdescritaContext cmdescrita() throws RecognitionException {
        CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_cmdescrita);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                match(T__5);
                setState(75);
                match(AP);
                setState(76);
                match(ID);
                verificaID(_input.LT(-1).getText());
                _writeID = _input.LT(-1).getText();
                verificaInicializacao(_writeID);

                setState(78);
                match(FP);
                setState(79);
                match(SC);

                CommandEscrita cmd = new CommandEscrita(_writeID);
                stack.peek().add(cmd);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CmdattribContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(MotherLangParser.ID, 0);
        }

        public TerminalNode ATTR() {
            return getToken(MotherLangParser.ATTR, 0);
        }

        public TerminalNode SC() {
            return getToken(MotherLangParser.SC, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode TEXT() {
            return getToken(MotherLangParser.TEXT, 0);
        }

        public CmdattribContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cmdattrib;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterCmdattrib(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitCmdattrib(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitCmdattrib(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CmdattribContext cmdattrib() throws RecognitionException {
        CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_cmdattrib);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(82);
                match(ID);
                verificaID(_input.LT(-1).getText());
                _exprID = _input.LT(-1).getText();

                setState(84);
                match(ATTR);
                _exprContent = "";
                setState(89);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                    case 1: {
                        setState(86);
                        expr();
                    }
                    break;
                    case 2: {
                        setState(87);
                        match(TEXT);
                        verificaText(_exprID);
                        _exprContent += _input.LT(-1).getText();

                    }
                    break;
                }
                setState(91);
                match(SC);

                MotherVariable var = (MotherVariable) symbolTable.get(_exprID);
                var.setInit(true);
                var.setValue(_exprContent);
                CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
                stack.peek().add(cmd);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CmdselecaoContext extends ParserRuleContext {
        public TerminalNode AP() {
            return getToken(MotherLangParser.AP, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(MotherLangParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(MotherLangParser.ID, i);
        }

        public TerminalNode OPREL() {
            return getToken(MotherLangParser.OPREL, 0);
        }

        public TerminalNode FP() {
            return getToken(MotherLangParser.FP, 0);
        }

        public List<TerminalNode> ACH() {
            return getTokens(MotherLangParser.ACH);
        }

        public TerminalNode ACH(int i) {
            return getToken(MotherLangParser.ACH, i);
        }

        public List<TerminalNode> FCH() {
            return getTokens(MotherLangParser.FCH);
        }

        public TerminalNode FCH(int i) {
            return getToken(MotherLangParser.FCH, i);
        }

        public TerminalNode NUMBER() {
            return getToken(MotherLangParser.NUMBER, 0);
        }

        public List<CmdContext> cmd() {
            return getRuleContexts(CmdContext.class);
        }

        public CmdContext cmd(int i) {
            return getRuleContext(CmdContext.class, i);
        }

        public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cmdselecao;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterCmdselecao(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitCmdselecao(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitCmdselecao(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CmdselecaoContext cmdselecao() throws RecognitionException {
        CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_cmdselecao);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                match(T__6);
                setState(95);
                match(AP);
                setState(96);
                match(ID);
                _exprDecision = _input.LT(-1).getText();
                setState(98);
                match(OPREL);
                _exprDecision += _input.LT(-1).getText();
                setState(100);
                _la = _input.LA(1);
                if (!(_la == ID || _la == NUMBER)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                _exprDecision += _input.LT(-1).getText();
                setState(102);
                match(FP);
                setState(103);
                match(ACH);
                curThread = new ArrayList<AbstractCommand>();
                stack.push(curThread);

                setState(106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(105);
                            cmd();
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0));
                setState(110);
                match(FCH);

                listaTrue = stack.pop();

                setState(123);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__7) {
                    {
                        setState(112);
                        match(T__7);
                        setState(113);
                        match(ACH);

                        curThread = new ArrayList<AbstractCommand>();
                        stack.push(curThread);

                        {
                            setState(116);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            do {
                                {
                                    {
                                        setState(115);
                                        cmd();
                                    }
                                }
                                setState(118);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0));
                        }
                        setState(120);
                        match(FCH);

                        listaFalse = stack.pop();
                        CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                        stack.peek().add(cmd);

                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public List<TermoContext> termo() {
            return getRuleContexts(TermoContext.class);
        }

        public TermoContext termo(int i) {
            return getRuleContext(TermoContext.class, i);
        }

        public List<TerminalNode> OP() {
            return getTokens(MotherLangParser.OP);
        }

        public TerminalNode OP(int i) {
            return getToken(MotherLangParser.OP, i);
        }

        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor) return ((MotherLangVisitor<? extends T>) visitor).visitExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        ExprContext _localctx = new ExprContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_expr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(125);
                termo();
                setState(131);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP) {
                    {
                        {
                            setState(126);
                            match(OP);
                            _exprContent += _input.LT(-1).getText();
                            setState(128);
                            termo();
                        }
                    }
                    setState(133);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermoContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(MotherLangParser.ID, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(MotherLangParser.NUMBER, 0);
        }

        public TerminalNode TEXT() {
            return getToken(MotherLangParser.TEXT, 0);
        }

        public TermoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_termo;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).enterTermo(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MotherLangListener) ((MotherLangListener) listener).exitTermo(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MotherLangVisitor)
                return ((MotherLangVisitor<? extends T>) visitor).visitTermo(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TermoContext termo() throws RecognitionException {
        TermoContext _localctx = new TermoContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_termo);
        try {
            setState(140);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(134);
                    match(ID);
                    verificaID(_input.LT(-1).getText());
                    verificaInicializacao(_input.LT(-1).getText());
                    _exprContent += _input.LT(-1).getText();

                }
                break;
                case NUMBER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(136);
                    match(NUMBER);

                    _exprContent += _input.LT(-1).getText();

                }
                break;
                case TEXT:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(138);
                    match(TEXT);

                    _exprContent += _input.LT(-1).getText();

                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\u0004\u0001\u0016\u008f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
                    "\u0001\u0001\u0004\u0001 \b\u0001\u000b\u0001\f\u0001!\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002*\b" +
                    "\u0002\n\u0002\f\u0002-\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0003\u00035\b\u0003\u0001\u0004\u0001" +
                    "\u0004\u0004\u00049\b\u0004\u000b\u0004\f\u0004:\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0003\u0005A\b\u0005\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001" +
                    "\b\u0001\b\u0003\bZ\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0004\tk\b\t\u000b\t\f\tl\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0004\tu\b\t\u000b\t\f\tv\u0001\t\u0001\t\u0001\t\u0003\t|\b\t\u0001" +
                    "\n\u0001\n\u0001\n\u0001\n\u0005\n\u0082\b\n\n\n\f\n\u0085\t\n\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b" +
                    "\u008d\b\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f" +
                    "\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0001\u0000\u0014\u0015\u0090" +
                    "\u0000\u0018\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000" +
                    "\u0004#\u0001\u0000\u0000\u0000\u00064\u0001\u0000\u0000\u0000\b6\u0001" +
                    "\u0000\u0000\u0000\n@\u0001\u0000\u0000\u0000\fB\u0001\u0000\u0000\u0000" +
                    "\u000eJ\u0001\u0000\u0000\u0000\u0010R\u0001\u0000\u0000\u0000\u0012^" +
                    "\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u008c\u0001" +
                    "\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019\u001a\u0003" +
                    "\u0002\u0001\u0000\u001a\u001b\u0003\b\u0004\u0000\u001b\u001c\u0005\u0002" +
                    "\u0000\u0000\u001c\u001d\u0006\u0000\uffff\uffff\u0000\u001d\u0001\u0001" +
                    "\u0000\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f\u001e\u0001\u0000" +
                    "\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000" +
                    "!\"\u0001\u0000\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0003\u0006" +
                    "\u0003\u0000$%\u0005\u0014\u0000\u0000%+\u0006\u0002\uffff\uffff\u0000" +
                    "&\'\u0005\u000e\u0000\u0000\'(\u0005\u0014\u0000\u0000(*\u0006\u0002\uffff" +
                    "\uffff\u0000)&\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001" +
                    "\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000" +
                    "-+\u0001\u0000\u0000\u0000./\u0005\u000b\u0000\u0000/\u0005\u0001\u0000" +
                    "\u0000\u000001\u0005\u0003\u0000\u000015\u0006\u0003\uffff\uffff\u0000" +
                    "23\u0005\u0004\u0000\u000035\u0006\u0003\uffff\uffff\u000040\u0001\u0000" +
                    "\u0000\u000042\u0001\u0000\u0000\u00005\u0007\u0001\u0000\u0000\u0000" +
                    "68\u0006\u0004\uffff\uffff\u000079\u0003\n\u0005\u000087\u0001\u0000\u0000" +
                    "\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000" +
                    "\u0000\u0000;\t\u0001\u0000\u0000\u0000<A\u0003\f\u0006\u0000=A\u0003" +
                    "\u000e\u0007\u0000>A\u0003\u0010\b\u0000?A\u0003\u0012\t\u0000@<\u0001" +
                    "\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000" +
                    "@?\u0001\u0000\u0000\u0000A\u000b\u0001\u0000\u0000\u0000BC\u0005\u0005" +
                    "\u0000\u0000CD\u0005\t\u0000\u0000DE\u0005\u0014\u0000\u0000EF\u0006\u0006" +
                    "\uffff\uffff\u0000FG\u0005\n\u0000\u0000GH\u0005\u000b\u0000\u0000HI\u0006" +
                    "\u0006\uffff\uffff\u0000I\r\u0001\u0000\u0000\u0000JK\u0005\u0006\u0000" +
                    "\u0000KL\u0005\t\u0000\u0000LM\u0005\u0014\u0000\u0000MN\u0006\u0007\uffff" +
                    "\uffff\u0000NO\u0005\n\u0000\u0000OP\u0005\u000b\u0000\u0000PQ\u0006\u0007" +
                    "\uffff\uffff\u0000Q\u000f\u0001\u0000\u0000\u0000RS\u0005\u0014\u0000" +
                    "\u0000ST\u0006\b\uffff\uffff\u0000TU\u0005\r\u0000\u0000UY\u0006\b\uffff" +
                    "\uffff\u0000VZ\u0003\u0014\n\u0000WX\u0005\u0012\u0000\u0000XZ\u0006\b" +
                    "\uffff\uffff\u0000YV\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000" +
                    "Z[\u0001\u0000\u0000\u0000[\\\u0005\u000b\u0000\u0000\\]\u0006\b\uffff" +
                    "\uffff\u0000]\u0011\u0001\u0000\u0000\u0000^_\u0005\u0007\u0000\u0000" +
                    "_`\u0005\t\u0000\u0000`a\u0005\u0014\u0000\u0000ab\u0006\t\uffff\uffff" +
                    "\u0000bc\u0005\u0013\u0000\u0000cd\u0006\t\uffff\uffff\u0000de\u0007\u0000" +
                    "\u0000\u0000ef\u0006\t\uffff\uffff\u0000fg\u0005\n\u0000\u0000gh\u0005" +
                    "\u000f\u0000\u0000hj\u0006\t\uffff\uffff\u0000ik\u0003\n\u0005\u0000j" +
                    "i\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000" +
                    "\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\u0010" +
                    "\u0000\u0000o{\u0006\t\uffff\uffff\u0000pq\u0005\b\u0000\u0000qr\u0005" +
                    "\u000f\u0000\u0000rt\u0006\t\uffff\uffff\u0000su\u0003\n\u0005\u0000t" +
                    "s\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000" +
                    "\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0005\u0010" +
                    "\u0000\u0000yz\u0006\t\uffff\uffff\u0000z|\u0001\u0000\u0000\u0000{p\u0001" +
                    "\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0013\u0001\u0000\u0000" +
                    "\u0000}\u0083\u0003\u0016\u000b\u0000~\u007f\u0005\f\u0000\u0000\u007f" +
                    "\u0080\u0006\n\uffff\uffff\u0000\u0080\u0082\u0003\u0016\u000b\u0000\u0081" +
                    "~\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081" +
                    "\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0015" +
                    "\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087" +
                    "\u0005\u0014\u0000\u0000\u0087\u008d\u0006\u000b\uffff\uffff\u0000\u0088" +
                    "\u0089\u0005\u0015\u0000\u0000\u0089\u008d\u0006\u000b\uffff\uffff\u0000" +
                    "\u008a\u008b\u0005\u0012\u0000\u0000\u008b\u008d\u0006\u000b\uffff\uffff" +
                    "\u0000\u008c\u0086\u0001\u0000\u0000\u0000\u008c\u0088\u0001\u0000\u0000" +
                    "\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u0017\u0001\u0000\u0000" +
                    "\u0000\u000b!+4:@Ylv{\u0083\u008c";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}