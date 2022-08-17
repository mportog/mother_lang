package br.com.ufabc.motherLanguage.ast;

import br.com.ufabc.motherLanguage.datastructures.MotherVariableTypeEnum;
import br.com.ufabc.motherLanguage.exception.MotherSemanticException;

public class CommandAtribuicao extends AbstractCommand {

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
        if (tipo == MotherVariableTypeEnum.BOOLEAN) {
            if (expr.equals("vdd")) {
                return id + " = true;";
            } else if (expr.equals("falso")) {
                return id + " = false;";
            } else {
                throw new MotherSemanticException("VALUE SET TO VARIABLE \""+id+"\" IS NOT THE SAME TYPE DECLARED");
            }

        } else {
            return id + " = " + expr + ";";
        }
    }

    @Override
    public String generatePythonCode() {
        if (tipo == MotherVariableTypeEnum.BOOLEAN) {
            if (expr.equals("vdd")) {
                return id + " = True";
            } else if (expr.equals("falso")){
                return id + " = False";
            } else {
                throw new MotherSemanticException("VALUE SET TO VARIABLE \""+id+"\" IS NOT THE SAME TYPE DECLARED");
            }
        } else {
            return id + " = " + expr;
        }
    }


    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }


}
