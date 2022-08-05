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
        return id + "=" + parseType();
    }

    private String parseType() {
        String str = "_key.nextLine();";
        if (var.getType() == MotherVariable.NUMBER) {
            str = "Double.parseDouble(_key.nextLine());";
        } else if (var.getType() == MotherVariable.BOOLEAN) {
            str = "_key.nextLine().equals(\"vdd\") ? true : false;";
        }
        return str;
    }

    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }

}