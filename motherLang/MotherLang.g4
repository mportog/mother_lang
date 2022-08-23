grammar MotherLang;

@header{
    import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
    import br.com.ufabc.motherLanguage.datastructures.MotherVariable;
    import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;
    import br.com.ufabc.motherLanguage.exception.MotherSemanticException;
    import br.com.ufabc.motherLanguage.datastructures.MotherVariableTypeEnum;
    import br.com.ufabc.motherLanguage.ast.*;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
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
//    private String _expressInit;
//    private String _expressInc;
//    private String _expressDecid;
//    private ArrayList<AbstractCommand> listarComando;

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
 		|  cmdselecionacaso
 		|  cmdenquanto
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
                   		}
                   )?
                   		{CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
            ;

cmdexponenciacao  : AP
                    NUMBER {_exprPowBase = _input.LT(-1).getText();}
                    'elevado'
                    NUMBER {_exprPowExp = _input.LT(-1).getText();}
                    VIR
                    'resulta'
                    ID{
                    verificaTipo(_input.LT(-1).getText(),MotherVariableTypeEnum.NUMBER);
                    _exprPowRes = _input.LT(-1).getText();
                    }
                    FP
                    SC
                    {
                     MotherVariable var = (MotherVariable)symbolTable.get(_exprPowRes);
                                     var.setInit(true);
                                     var.setValue(DEFAULT_VALUE);
                     CommandExponenciacao cmd = new CommandExponenciacao(_exprPowBase, _exprPowExp,_exprPowRes);
                     stack.peek().add(cmd);
                    }
                  ;

cmdselecionacaso : 'seleciona'
                    AP
                    ID { _exprSeleciona = _input.LT(-1).getText(); }
                    FP
                    ACH
                    {
                     _listaExpCaso = new ArrayList<String>();
                     _listaCaso = new ArrayList<ArrayList<AbstractCommand>>();
                     _padraoCaso = new ArrayList<AbstractCommand>();
                    }
                    (
                      'caso'
                      termocaso
                      DP
                      { curThread = new ArrayList<AbstractCommand>();
                        stack.push(curThread);
                      }
                      (cmd)+
                      'para'
                      SC
                      {
                       _listaCaso.add(stack.pop());
                      }
                    )+
                    (
                      'nenhum'
                      DP
                       { curThread = new ArrayList<AbstractCommand>();
                         stack.push(curThread);
                       }
                      (cmd)+
                       { _padraoCaso = stack.pop(); }
                    )?
                    FCH
                    {
                      CommandCaso cmd = new CommandCaso(_exprSeleciona, _listaExpCaso, _listaCaso, _padraoCaso);
                      stack.peek().add(cmd);
                    }
                 ;

cmdenquanto    : 'enquanto'
                 AP
                 ID {
                 verificaTipo(_input.LT(-1).getText(),MotherVariableTypeEnum.BOOLEAN);
                 _exprCondEnquanto = _input.LT(-1).getText();
                 }
                 FP
                 ACH {  curThread = new ArrayList<AbstractCommand>();
                    stack.push(curThread);
                 }
                 (cmd)+
                 { _listaEnquanto = stack.pop(); }
                 FCH
                 {
                    CommandEnquanto cmd = new CommandEnquanto(_exprCondEnquanto, _listaEnquanto);
                    stack.peek().add(cmd);
                 }
               ;

//cmdpara : 'para'
//		  AP
//		  ID
//		  {
//					_expressInit = _input.LT(-1).getText();
//					symbolTable.get(_expressInit).setUsed();
//		  }
//		  ATTR
//		  {
//			 		_expressInit += "=";
//		  }
//		  (ID | NUMBER)
//		  {
//                   	_expressInit += _input.LT(-1).getText();
//		  }
//		  'conteate'
//		  ID
//		  {
//					_expressDec = _input.LT(-1).getText();
//		  }
//		  OPREL
//		  {
//			 		_expressDec += _input.LT(-1).getText();
//		  }
//		  (ID | NUMBER)
//		  {
//                   	_expressDec += _input.LT(-1).getText();
//		  }
//		  'operacao'
//		  ID
//		  {
//					_expressInc = _input.LT(-1).getText();
//		  }
// 		  INC
// 		  {
// 		  			_expressInc += "++";
// 		  }
//		  FP
//		  ACH
//		  {
//					curThread = new ArrayList<AbstractCommand>();
//		            stack.push(currentThread);
//		  }
//		  (cmd)+
//		  FCH
//		  {
//					listarComando = stack.pop();
//					CommandPara cmd = new CommandPara(_expressInit, _expressDec, _expressInc,  listarComando);
//					stack.peek().add(cmd);
//		  }
//		;

expr		:  termo (
	             OP  { _exprContent += _input.LT(-1).getText();}
	           termo )*
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
			;

termocaso : ID {
             verificaDeclacracaoExistenteID(_input.LT(-1).getText());
             verificaInicializacao(_input.LT(-1).getText());
             _listaExpCaso.add(_input.LT(-1).getText());
            }
            |
            NUMBER
            {
             _listaExpCaso.add(_input.LT(-1).getText());
            }
            |
            TEXT
            {
             _listaExpCaso.add(_input.LT(-1).getText());
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

DP	: ':'
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

INC : '++'
   ;
