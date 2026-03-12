package practica6;

import java.util.Scanner;

public class Ejercicio4v2 {
    public static Scanner sc = new Scanner(System.in);

    public static String codificar(String frase, String conjunto1, String conjunto2) {
        int indice;
        String transformaTexto = "", letraMinus = frase.toLowerCase();
        boolean mayusculas;

        for (int i = 0; i < frase.length(); i++) {
            indice = conjunto1.indexOf(letraMinus.charAt(i));

            mayusculas = Character.isUpperCase(frase.charAt(i));
            if (indice != -1 && mayusculas) {
                transformaTexto += Character.toUpperCase(conjunto2.charAt(indice));
            } else if (indice != -1) {
                transformaTexto += conjunto2.charAt(indice);
            } else {
                transformaTexto += frase.charAt(i);
            }
        }
        return transformaTexto;
    }

    static void main() {
        String conjunto1 = "eikmpqrstuv", conjunto2 = "pviumterkqs", frase, codificado, codificarOtra;

        System.out.print("Introduzca un texto a codificar: ");
        frase = sc.nextLine();
        do {
            codificado = codificar(frase, conjunto1, conjunto2);

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
