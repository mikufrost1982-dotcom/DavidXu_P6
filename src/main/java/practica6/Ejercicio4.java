package practica6;

import java.util.Scanner;

/***
 * Este programa tiene 2 conjuntos que el primer conjunto es la letra para codificar y
 * la segunda es para traducir el primer conjunto, es decir, el primer conjunto contiene
 * una longitud de letras y el segundo traduce las letras del primer conjunto uno a uno si
 * lo encuentra el primer conjunto cambia la letra a segundo conjunto en la misma posición
 * @author David Xu
 * @version v1 13/03/2026
 */
public class Ejercicio4 {
    public static Scanner sc = new Scanner(System.in);

    /***
     * Nos busca la letra del conjunto 1 para que nos devuelva la posición y podemos traducirlo
     * @param letra Recibe las letras de la frase
     * @param conjunto1 Recibe el conjunto 1 la codificación de las letras
     * @return Devuelve una posición si encuentra la letra
     */
    public static int buscarLetra(char letra, char[] conjunto1) {
        int i = 0;
        char letraMinus;
        letraMinus = Character.toLowerCase(letra);

        while (i < conjunto1.length && letraMinus != conjunto1[i]) {
            i++;
        }
        return i;
    }

    /***
     * El usuario introduce una frase y tenemos que traducir la frase en conjunto 2, para eso
     * usamos el conjunto 1 y así podemos traducirlo al conjunto 2
     * @param frase Recibe la frase que introduce el usuario
     * @param conjunto1 Recibe las letras de la codificación
     * @param conjunto2 Recibe las letras para traducirlo del conjunto1
     * @return Devuelve la traducción de la frase
     */
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
        //Variables
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
