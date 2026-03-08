package practica6;

import java.util.Scanner;

public class Ejercicio2 {
    public static Scanner sc = new Scanner(System.in);

    public static String primeraMayuscula(String cadena) {
        String primeraMay = "";

        primeraMay += Character.toUpperCase(cadena.charAt(0));
        primeraMay += cadena.substring(1);
        return primeraMay;
    }

    public static String estiloCamel(String cadena) {
        String minus = cadena.toLowerCase(), estiloCamel = "";
        String[] frase = minus.split(" ");

        for (int i = 0; i < frase.length; i++) {
            if (i > 0) {
                estiloCamel += primeraMayuscula(frase[i]);
            } else {
                estiloCamel += frase[i];
            }
        }
        return estiloCamel;
    }

    static void main() {
        String frase, estiloCamel;

        System.out.print("Escriba una frase: ");
        frase = sc.nextLine();

        estiloCamel = estiloCamel(frase);
        System.out.println("Variable estilo Camel: " + estiloCamel);
    }
}
