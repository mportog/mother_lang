package br.com.ufabc.motherLanguage.datastructures;

public class MotherVariable extends MotherSymbol {

    public static final int NUMBER = 0;
    public static final int TEXT = 1;
    public static final int BOOLEAN = 2;
    public static final int INTEGER = 3;

    private int type;
    private String value;
    private boolean init = false;

    public MotherVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    @Override
    public String toString() {
        return "MotherVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

    public String generateJavaCode() {
        String str = "";
        switch (type) {
            case NUMBER:
                str = "double ";
                break;
            case TEXT:
                str = "String ";
                break;
            case BOOLEAN:
                str = "Boolean ";
                break;
        }
        return str + " " + super.name + ";";
    }
}