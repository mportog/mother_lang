package br.com.ufabc.motherLanguage.ast;

public class CommandExponenciacao extends AbstractCommand {
    private String base;
    private String exp;
    private String out;

    public CommandExponenciacao(String b, String e, String r) {
        this.base = b;
        this.exp = e;
        this.out = r;
    }

    @Override
    public String generateJavaCode() {
        return out+"=Math.pow("+base+","+exp+");\n";
    }
    @Override
    public String generatePythonCode(){
        return out+"=pow("+base+","+exp+")\n";
    }
    @Override
    public String toString() {
        return "CommandExponenciacao [out = base^exp : base=" + base + ", exp=" + exp + " out="+out+"]";
    }
}
