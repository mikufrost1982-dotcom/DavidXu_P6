package practica6;

import java.util.Scanner;

/***
 * Estilo camel es una regla de variables como ejemplo meGustaMerendarGalletas
 * @author David Xu
 * @version v1 13/03/2026
 */
public class Ejercicio2 {
    public static Scanner sc = new Scanner(System.in);

    /***
     * La segunda palabra me pone la primera letra en mayúsculas y el resto en minúsculas
     * @param cadena Recibe la palabra de la función split que le invocó estiloCamel()
     * @return Devuelve la primera letra en mayúsculas y el resto en minúsculas
     */
    public static String primeraMayuscula(String cadena) {
        String primeraMay = "";

        primeraMay += Character.toUpperCase(cadena.charAt(0));
        primeraMay += cadena.substring(1);
        return primeraMay;
    }

    /***
     * Recorre toda la frase hago un split para convertir en un String[] donde los espacios me conviertas en una
     * coma y si la variable i es mayor que cero llamo a la función primeraMayúsculas() y si no se queda normal, en este caso
     * es la primera que no se queda en mayúsculas
     * @param cadena Recibe la frase que introduce el usuario
     * @return Devuelve un variable en estilo camel
     */
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
        //Variables
        String frase, estiloCamel;

        //Pido al usuario que introduzca una frase para convertir la frase en estilo camel
        System.out.print("Escriba una frase: ");
        frase = sc.nextLine();

        //Llamó a la función y que convierta el estilo camel y lo muestro
        estiloCamel = estiloCamel(frase);
        System.out.println("Variable estilo Camel: " + estiloCamel);
    }
}
