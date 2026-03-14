package practica6;

import java.util.Scanner;

/***
 * Este es la versión 3, hice con string de matrices y con indexOf
 * @author David Xu
 * @version v3 13/03/2026
 */
public class Ejercicio4v3StringMatrices {
    public static Scanner sc = new Scanner(System.in);

    //En vez de usar 2 variables utilicé los matrices fila 0 y letra inicio 0
    // filas 1 letra de inicio 0
    public static String codificar(String frase, String[][] conjuntos) {
        int indice;
        String transformaTexto = "", letraMinus = frase.toLowerCase();
        boolean mayusculas;

        for (int i = 0; i < frase.length(); i++) {
            indice = conjuntos[0][0].indexOf(letraMinus.charAt(i));

            mayusculas = Character.isUpperCase(frase.charAt(i));
            if (indice != -1 && mayusculas) {
                transformaTexto += conjuntos[1][0].toUpperCase().charAt(indice);
            } else if (indice != -1) {
                transformaTexto += conjuntos[1][0].charAt(indice);
            } else {
                transformaTexto += frase.charAt(i);
            }
        }
        return transformaTexto;
    }

    static void main() {
        //Variable
        String[][] conjuntos = {{"eikmpqrstuv"},{"pviumterkqs"}};
        String frase, codificado, codificarOtra;

        System.out.print("Introduzca un texto a codificar: ");
        frase = sc.nextLine();
        do {
            codificado = codificar(frase, conjuntos);

            System.out.println(codificado);

            System.out.print("¿Quieres codificar otro texto?: ");
            codificarOtra = sc.nextLine();

            if (codificarOtra.equalsIgnoreCase("si")) {
                System.out.print("Introduzca un texto a codificar: ");
                frase = sc.nextLine();
            }
        } while (!codificarOtra.equalsIgnoreCase("no"));
    }
}
