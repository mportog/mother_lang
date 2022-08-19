package br.com.ufabc.motherLanguage.ast;

import java.util.ArrayList;

public class CommandPara extends AbstractCommand{

    private String valor;
    private String condicao;
    private String incremento;
    private ArrayList<AbstractCommand> listaComando;

    public CommandPara(String valor, String condicao, String incremento, ArrayList<AbstractCommand> lc) {
        this.valor = valor;
        this.condicao = condicao;
        this.incremento = incremento;
        this.listaComando = lc;
    }

    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        StringBuilder string = new StringBuilder();
        string.append("for (" + valor + ";" + condicao + ";" + incremento + ") {\n");
        for (AbstractCommand cmd: listaComando) {
            string.append(cmd.generateJavaCode()+"\n");
        }
        string.append("}");
        return string.toString();
    }
    
    @Override
    public String generatePythonCode() {
        // TODO Auto-generated method stub
        StringBuilder string = new StringBuilder();
        string.append("for " + valor + "in" + "(" + condicao + ")" + ":" + incremento + "\n");
        for (AbstractCommand cmd: listaComando) {
            string.append(cmd.generatePythonCode()+"\n");
        }
        string.append("}");
        return string.toString();
    }

    @Override
    public String toString() {
        return "CommandPara [valor=[" + valor + "],condicao=[" + condicao + "], incremento=[" + incremento + "], listarComando=" + listaComando + "]";
    }
}
