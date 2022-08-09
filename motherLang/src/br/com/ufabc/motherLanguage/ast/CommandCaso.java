package br.com.ufabc.motherLanguage.ast;

import java.util.ArrayList;

public class CommandCaso extends AbstractCommand {

    private String condition;
    private ArrayList<String> listaExpCaso;
    private ArrayList<ArrayList<AbstractCommand>> listaCaso;
    private ArrayList<AbstractCommand> padraoCaso;

    public CommandCaso(
            String condition,
            ArrayList<String> lExpCaso,
            ArrayList<ArrayList<AbstractCommand>> lCaso,
            ArrayList<AbstractCommand> snCaso) {
        this.condition = condition;
        this.listaExpCaso = lExpCaso;
        this.listaCaso = lCaso;
        this.padraoCaso = snCaso;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("switch (").append(condition).append(") {\n");
        for (int i = 0; i < listaExpCaso.size(); i++) {
            str.append("            ").append("case ").append(listaExpCaso.get(i)).append(":\n");
            for (AbstractCommand cmd : listaCaso.get(i)) {
                str.append("            ").append(cmd.generateJavaCode()).append("\n");
            }
            str.append("            ").append("break;\n");
        }
        if (padraoCaso.size() > 0) {
            str.append("            ").append("default:\n");
            for (AbstractCommand cmd : padraoCaso) {
                str.append("            ").append(cmd.generateJavaCode());
            }
        }
        str.append("\n    }\n");
        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandCaso [condition=" + condition + ", listaExpCaso=" + listaExpCaso + ", listaCaso="
                + listaCaso + ", senaoCaso=" + padraoCaso + "]";
    }
}
