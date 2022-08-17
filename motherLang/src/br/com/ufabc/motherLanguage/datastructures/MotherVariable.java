package br.com.ufabc.motherLanguage.datastructures;

public class MotherVariable extends MotherSymbol {
    private MotherVariableTypeEnum type;
    private String value;
    private boolean init = false;

    public MotherVariable(String name, MotherVariableTypeEnum type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public MotherVariableTypeEnum getType() {
        return type;
    }

    public void setType(MotherVariableTypeEnum type) {
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
    public String generatePhytonCode() {
        return "";
    }
}