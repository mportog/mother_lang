package br.com.ufabc.motherLanguage.ast;

import java.util.ArrayList;

public class CommandEnquanto extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> listaEnquanto;

    public CommandEnquanto(String condition, ArrayList<AbstractCommand> lE) {
        this.condition = condition;
        this.listaEnquanto = lE;
    }
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("while (").append(condition).append(") {\n");
        for (AbstractCommand cmd: listaEnquanto) {
            str.append("            ").append(cmd.generateJavaCode());
        }
        str.append("            ").append("\n}");
        return str.toString();
    }
    @Override
    public String generatePythonCode(){
        return "while phyton";
    }
    @Override
    public String toString() {
        return "CommandEnquanto [condition=" + condition + ", listaEnqaunto=" + listaEnquanto+ "]";
    }



}
