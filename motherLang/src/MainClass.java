import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        Scanner _key = new Scanner(System.in);
        String  casoT2;
        String  resultado;
        String  condicaoT;
        String  casoT1;
        condicaoT = "0";
        casoT1 = "1";
        casoT2 = "2";
        switch (condicaoT) {
            case "1":
            resultado = "igual a T1";
            break;
            case "2":
            resultado = "igual a T2";
            break;
            default:
            resultado = "nem T1 nem T2";
    }

        System.out.println(resultado);
    }
}