package practica6;

import java.util.Scanner;

/***
 * Este programa es contar las letras que se han repetido
 * @author David Xu
 * @version v1 14/03/2026
 */
public class Ejercicio5 {
    public static Scanner sc = new Scanner(System.in);

    /***
     * Nos cuenta las letras que se han repetido usando el indexOf para buscar la letra
     * @param frase Recibe la frase que introduce por el usuario
     * @param letra Recibe la letra del abecedario para saber si está en la frase
     * @return Devuelve las repeticiones de las letras
     */
    public static int contarLetras(String frase, char letra) {
        String minus = frase.toLowerCase();
        int indice;
        int contador = 0;

        indice = minus.indexOf(letra);
        while (indice != -1) {
            contador++;
            indice = minus.indexOf(letra, indice + 1);
        }

        return contador;
    }

    static void main() {
        //Variables
        String frase, abecedario = "abcdefghijklmnñopqrstuvwxyz";
        char[] letra = abecedario.toCharArray();
        int repetidas;

        //Pedimos al usuario que introduzca una frase
        System.out.println("Introduce una frase: ");
        frase = sc.nextLine();

        //Recorremos con un for each de las letras
        for (char elemento : letra) {
            //Llamamos a la función para las repeticiones
            repetidas = contarLetras(frase, elemento);

            //Comprobamos si el contador de la función nos devuelve mayor que 0 es true y lo imprime
            //si no es el caso no nos imprime
            if (repetidas > 0) {
                System.out.println("La letra " + elemento + " se repite " + repetidas);
            }
        }

    }
}
