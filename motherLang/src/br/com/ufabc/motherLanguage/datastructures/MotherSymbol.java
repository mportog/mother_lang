package br.com.ufabc.motherLanguage.datastructures;

public abstract class MotherSymbol {
    protected String name;

    public abstract String generateJavaCode();
    public MotherSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MotherSymbol [name=" + name + "]";
    }
}