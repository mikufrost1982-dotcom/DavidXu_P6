package practica6;

import java.util.Scanner;

public class Ejercicio4 {
    public static Scanner sc = new Scanner(System.in);

    public static int buscarLetra(char letra, char[] conjunto1) {
        int i = 0;
        char letraMinus;
        letraMinus = Character.toLowerCase(letra);

        while (i < conjunto1.length && letraMinus != conjunto1[i]) {
            i++;
        }
        return i;
    }

    public static String codificacion(String frase, char[] conjunto1, char[] conjunto2) {
        String transformaTexto = "";
        char[] fraseTransformado = frase.toCharArray();
        int indice;
        boolean mayusculas;

        for (char elemento : fraseTransformado) {
            indice = buscarLetra(elemento, conjunto1);

            mayusculas = Character.isUpperCase(elemento);
            if (indice < conjunto1.length && mayusculas) {
                transformaTexto += Character.toUpperCase(conjunto2[indice]);
            } else if (indice < conjunto1.length) {
                transformaTexto += conjunto2[indice];
            } else {
                transformaTexto += elemento;
            }
        }

        return transformaTexto;
    }

    static void main() {
        char[] conjunto1 = {'e', 'i', 'k', 'm', 'p', 'q', 'r', 's', 't', 'u', 'v'},
                conjunto2 = {'p', 'v', 'i', 'u', 'm', 't', 'e', 'r', 'k', 'q', 's'};
        String frase, codificarOtra, codificado;

        System.out.print("Introduzca un texto a codificar: ");
        frase = sc.nextLine();
        do {
            codificado = codificacion(frase, conjunto1, conjunto2);

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
