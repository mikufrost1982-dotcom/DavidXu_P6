package practica6;

import java.util.Scanner;

public class Ejercicio5 {
    public static Scanner sc = new Scanner(System.in);

    public static int contarLetras(String frase, char letra) {
        String minus = frase.toLowerCase();
        int indice, i = 0;
        int contador = 0;

        indice = minus.indexOf(letra);
        while (indice != -1) {
            contador++;
            indice = minus.indexOf(letra, indice + 1);
        }

        return contador;
    }

    static void main() {
        String frase, abecedario = "abcdefghijklmnñopqrstuvwxyz";
        char[] letra = abecedario.toCharArray();
        int repetidas;

        System.out.println("Introduce una frase: ");
        frase = sc.nextLine();


        for (char elemento : letra) {
            repetidas = contarLetras(frase, elemento);
            if (repetidas > 0) {
                System.out.println("La letra " + elemento + " se repite " + repetidas);
            }
        }

    }
}
