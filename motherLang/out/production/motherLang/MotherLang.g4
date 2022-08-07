grammar MotherLang;

@header{
    import motherLanguage.datastructures.MotherSymbol;
    import motherLanguage.datastructures.MotherVariable;
    import motherLanguage.datastructures.MotherSymbolTable;
    import motherLanguage.exception.MotherLanguageException;
    import motherLanguage.ast.*;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
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
}

prog	: 'programa' decl bloco  'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	  verificaUsoVars();
           }
		;

decl    :  (declaravar)*
        ;

declaravar :  tipo ID  {
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
              (  VIR
              	 ID {
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
              )*
               SC
           ;

tipo       : 'numero' { _tipo = MotherVariable.NUMBER;  }
           | 'texto'  { _tipo = MotherVariable.TEXT;  }
           | 'booleano'  { _tipo = MotherVariable.BOOLEAN;  }
           ;

bloco	: { curThread = new ArrayList<AbstractCommand>();
	        stack.push(curThread);
          }
          (cmd)*
		;

cmd		:  cmdleitura
 		|  cmdescrita
 		|  cmdattrib
 		|  cmdselecao
 		|  cmdexponenciacao
		;

cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        }
                     FP
                     SC
              { verificaID(_readID);
              	MotherVariable var = symbolTable.get(_readID);
              	var.setInit(true);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }
			;

cmdescrita	: 'escreva'
                 AP
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
	                  verificaInicializacao(_writeID);
                     }
                 FP
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;

cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   }
               ATTR { _exprContent = ""; }
               (expr
               | TEXT { verificaText(_exprID);
                            _exprContent += _input.LT(-1).getText() ;
                      }
               )
               SC
               {
                 MotherVariable var = (MotherVariable)symbolTable.get(_exprID);
                 var.setInit(true);
                 var.setValue(_exprContent);
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;

cmdselecao  :  'se' AP
                    (
                     ID    { _exprDecision = _input.LT(-1).getText(); }
                     OPREL { _exprDecision += _input.LT(-1).getText(); }
                     (ID | NUMBER ) {_exprDecision += _input.LT(-1).getText(); }
                    )
                    |
                    (
                     ID    { _exprDecision = _input.LT(-1).getText(); }
                     OPREL { _exprDecision += _input.LT(-1).getText(); }
                     (ID | NUMBER ) {_exprDecision += _input.LT(-1).getText(); }
                     OPBINARY { _exprDecision += _input.LT(-1).getText(); }
                     ID    { _exprDecision = _input.LT(-1).getText(); }
                     OPREL { _exprDecision += _input.LT(-1).getText(); }
                     (ID | NUMBER ) {_exprDecision += _input.LT(-1).getText(); }
                    )+
                     |
                     BOOLEAN { _exprDecision += _input.LT(-1).getText(); }
                    FP
                    ACH
                    { curThread = new ArrayList<AbstractCommand>();
                      stack.push(curThread);
                    }
                    (cmd)+

                    FCH
                    {
                       listaTrue = stack.pop();
                    }
                   ('senao'
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 }
                   	(cmd+)
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdexponenciacao  : 'elevado'  AP
                    NUMBER {_exprPowBase = _input.LT(-1).getText();}
                    VIR
                    NUMBER {_exprPowExp = _input.LT(-1).getText();}
                    FP
                    SC
                    {
                     CommandExponenciacao cmd = new CommandExponenciacao(_exprPowBase, _exprPowExp);
                     stack.peek().add(cmd);
                    }
                  ;

expr		:  termo (
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo )*
			;

termo		: ID { verificaID(_input.LT(-1).getText());
                    verificaInicializacao(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 }
            |
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
            |
              TEXT
              {
                _exprContent += _input.LT(-1).getText();
              }
			;

AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

OP	: '+' | '-' | '*' | '/'
	;

ATTR : '='
	 ;

VIR  : ','
     ;

ACH  : '{'
     ;

FCH  : '}'
     ;

ASP  : '"'
	 ;

TEXT	: '"' ( '\\"' | . )*? '"'
		;

OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;

BOOLEAN : (TRUE|FALSE)
        ;

TRUE : 'true'
     ;

FALSE : 'false'
      ;

AND : '&&'
    ;

OR  : '||'
    ;

OPBINARY  : AND | OR
          ;