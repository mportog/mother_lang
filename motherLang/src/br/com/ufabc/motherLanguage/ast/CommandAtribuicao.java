package br.com.ufabc.motherLanguage.ast;

import br.com.ufabc.motherLanguage.datastructures.MotherVariableTypeEnum;

public class CommandAtribuicao extends AbstractCommand{

    private String id;
    private String expr;
    private MotherVariableTypeEnum tipo;

    public CommandAtribuicao(String id, String expr, MotherVariableTypeEnum tipo) {
        this.id = id;
        this.expr = expr;
        this.tipo = tipo;
    }
    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        if(tipo == MotherVariableTypeEnum.BOOLEAN)
            return id + " = "+expr.equals("vdd")+";";
        else
        return id + " = "+expr+";";
    }

    @Override
    public String generatePythonCode(){
        return "atribuicao em phyton";
    }
    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }



}
