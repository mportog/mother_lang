package br.com.ufabc.motherLanguage.ast;

import br.com.ufabc.motherLanguage.datastructures.MotherVariable;

public class CommandLeitura extends AbstractCommand {

    private String id;
    private MotherVariable var;

    public CommandLeitura (String id, MotherVariable var) {
        this.id = id;
        this.var = var;
    }
    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        return id +"=" + (var.getType()== MotherVariable.NUMBER? "Double.parseDouble(_key.nextLine());" : "_key.nextLine();");
    }
    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }

}