package br.com.ufabc.motherLanguage.ast;

import br.com.ufabc.motherLanguage.datastructures.MotherSymbol;
import br.com.ufabc.motherLanguage.datastructures.MotherSymbolTable;

import java.io.FileWriter;
import java.util.ArrayList;

public class MotherProgram {
    private MotherSymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("import java.lang.Math;\n\n");
        str.append("public class MainClass {\n");
        str.append("    public static void main(String args[]) {\n");
        str.append("        Scanner _key = new Scanner(System.in);\n");

        for (MotherSymbol symbol : varTable.getAll()) {
            str.append("        " + symbol.generateJavaCode() + "\n");
        }
        for (AbstractCommand command : comandos) {
            str.append("        " + command.generateJavaCode()).append("\n");
        }
        str.append("    }\n");
        str.append("}");

        try {
            FileWriter fr = new FileWriter("src/MainClass.java");
            fr.write(str.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public MotherSymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(MotherSymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}