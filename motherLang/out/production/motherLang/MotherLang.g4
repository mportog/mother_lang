grammar MotherLang;

@header{
    import motherLanguage.datastructures.MotherSymbol;
    import motherLanguage.datastructures.MotherVariable;
    import motherLanguage.datastructures.MotherSymbolTable;
    import motherLanguage.exception.MotherLanguageException;
    import br.com.ufabc.motherLanguage.datastructures.MotherVariableTypeEnum;
    import motherLanguage.ast.*;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
	private MotherVariableTypeEnum _tipo;
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

declaravar :  tipo
              var
               (
                VIR
              	var
               )*
               SC
           ;

var :  ID  {
      	      _varName = _input.LT(-1).getText();
      	      _varValue = null;
      	      variable = new MotherVariable(_varName, _tipo, _varValue);
      	      verificaDeclaracaoDuplaID(_varName);
           }
    ;

tipo       : 'numero' { _tipo =MotherVariableTypeEnum.NUMBER;  }
           | 'texto'  { _tipo = MotherVariableTypeEnum.TEXT;  }
           | 'booleano'  { _tipo = MotherVariableTypeEnum.BOOLEAN;  }
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
                     ID { verificaDeclacracaoExistenteID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        }
                     FP
                     SC
              {
              	MotherVariable var = symbolTable.get(_readID);
              	var.setInit(true);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }
			;

cmdescrita	: 'escreva'
                 AP
                 ID { verificaDeclacracaoExistenteID(_input.LT(-1).getText());
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

cmdattrib	:  ID { verificaDeclacracaoExistenteID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   }
               ATTR { _exprContent = ""; }
               (
               expr
               | BOOL { verificaTipo(_exprID,MotherVariableTypeEnum.BOOLEAN);
                        _exprContent += _input.LT(-1).getText() ;
                      }
               | TEXT { verificaTipo(_exprID,MotherVariableTypeEnum.TEXT);
                        _exprContent += _input.LT(-1).getText() ;
                      }
               )
               SC
               {
                 MotherVariable var = (MotherVariable)symbolTable.get(_exprID);
                 var.setInit(true);
                 var.setValue(_exprContent);
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent,  getTipoId(_exprID));
               	 stack.peek().add(cmd);
               }
			;

cmdselecao  :  'se' AP
                    (
                      ID { _exprDecision = _input.LT(-1).getText(); }
                    |
                       ID { _exprDecision = _input.LT(-1).getText(); }
                       OPREL { _exprDecision += _input.LT(-1).getText(); }
                       (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    )
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

expr		:  termo
                (
	            OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;

termo		: ID { verificaTipo(_exprID,MotherVariableTypeEnum.NUMBER);
                    verificaInicializacao(_exprID);
	               _exprContent += _input.LT(-1).getText();
                 }
            |
              NUMBER
              {  verificaTipo(_exprID,MotherVariableTypeEnum.NUMBER);
              	_exprContent += _input.LT(-1).getText();
              }
            |
              TEXT
              {
                _exprContent += _input.LT(-1).getText();
              }
			;

BOOL : 'vdd' | 'falso'
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

NUMBER	: '-'? [0-9]+ ('.' [0-9]+)?
		;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;
