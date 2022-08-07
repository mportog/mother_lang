package br.com.ufabc.motherLanguage.ast;

public class CommandExponenciacao extends AbstractCommand {
    private String base;
    private String exp;

    public CommandExponenciacao(String b, String e) {
        this.base = b;
        this.exp = e;
    }

    @Override
    public String generateJavaCode() {
        return "System.out.println(Math.pow("+base+","+exp+"));\n";
    }

    @Override
    public String toString() {
        return "CommandExponenciacao [base^exp : base=" + base + ", exp=" + exp + "]";
    }
}
