import java.util.Scanner;
import java.lang.Math;

public class MainClass {
    public static void main(String args[]) {
        Scanner _key = new Scanner(System.in);
        double  a;
        double  r;
        Boolean  b;
        double  n1;
        String  c;
        String  casoT2;
        String  resultado;
        Boolean  t;
        double  x;
        String  condicaoT;
        String  casoT1;
        double  zero0;
        condicaoT = "0";
        casoT1 = "1";
        casoT2 = "2";
        b = false;
        n1 = 0;
        t = true;
        a = -1;
        zero0 = 0;
        x = 3+2*20/4;
        System.out.println(x);
        if (t) {
            c = "deu bom";            
} else {
            c = "deu ruim";            
}

        System.out.println(c);
        if (a>=zero0) {
            c = "variavel A maior ou igual que zero";            
} else {
            c = "variavel A menor que zero";            
}

        System.out.println(c);
        r=Math.pow(3.0,2);

        System.out.println(r);
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
        while (b) {
            if (n1==5) {
            b = false;            
} else {
            n1 = n1+1;            
}
            
}
    }
}