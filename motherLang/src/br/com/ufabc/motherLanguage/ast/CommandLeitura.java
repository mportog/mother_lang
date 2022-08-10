package br.com.ufabc.motherLanguage.ast;

import br.com.ufabc.motherLanguage.datastructures.MotherVariable;

public class CommandLeitura extends AbstractCommand {

    private String id;
    private MotherVariable var;

    public CommandLeitura(String id, MotherVariable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        return id + " = " + parseJavaType();
    }

    private String parseJavaType() {
        String str = "";
        switch (var.getType()) {
            case MotherVariable.NUMBER:
                str = "Double.parseDouble(_key.nextLine());";
                break;
            case MotherVariable.BOOLEAN:
                str = "_key.nextLine().equals(\"vdd\");";
                break;
            case MotherVariable.TEXT:
                str = "_key.nextLine();";
                break;
        }
        return str;
    }
    @Override
    public String generatePythonCode(){
        return id + " = _key.nextLine()";
    }
    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }

}