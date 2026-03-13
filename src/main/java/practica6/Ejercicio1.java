package practica6;

import java.util.Arrays;
import java.util.Scanner;

/***
 * Este programa es el juego que todas las personas ha jugado y es el ahorcado. El juego consiste en adivinar
 * la palabra secreta que empieza por '-', tienes que introducir una letra si aciertas se sigue, si no tienes 7
 * intentos que se sustituye por la persona en palitos
 * @author David Xu
 * @version v1 13/03/2026
 */
public class Ejercicio1 {
    //Función Scanner que es global o mejor dicho que se puede usar en cualquier lado
    public static Scanner sc = new Scanner(System.in);

    //Estos son las secuencias de Escape ANSI que se hacen en codepoint de hexadecimal generado por Internet
    public static final String ROJO_NEGRITA="\u001B[31m\u001B[1m";
    public static final String AZUL_NEGRITA="\u001B[34m\u001B[1m";
    public static final String RESET="\u001B[0m";

    /***
     * El juego ahorcado la palabra secreta empieza en guiones, es el inicio del juego cuando empiezas a adivinar las letras
     * @param palabraSecreta Recibe la palabra secreta en un array de tipo char
     * @param inicio Recibe una variable vacía rellena los '-' por la longitud de la palabra secreta
     */
    public static void inicioJuego(char[] palabraSecreta, char[] inicio) {
        for (int i = 0; i < palabraSecreta.length; i++) {
            inicio[i] = '-';
        }
    }

    /***
     * Este juego no es en pedir la pista, si no es en adivinar la letra de la palabra secreta y que te lo muestre la letra
     * y los guiones las dejo y no lo voy a tocar
     * @param letra Recibe una letra que ha sido introducido por el jugador que está adivinando
     * @param palabraSecreta Recibe la palabra secreta en un array de tipo char
     * @param letraAcertada Recibe los '-' de tipo char[] y guarda las letras que esté acertando o dejas en '-'
     */
    public static void ahorcado(char letra, char[] palabraSecreta, char[] letraAcertada) {
        char letraMinus = Character.toLowerCase(letra);
        for (int i = 0; i < palabraSecreta.length; i++) {
            if (Character.toLowerCase(palabraSecreta[i]) == letraMinus) {
                letraAcertada[i] = palabraSecreta[i];
            }
        }
    }

    /***
     * Este comprueba si el jugador que está adivinando y adivina la palabra secreta gana
     * @param palabraSecreta Recibe la palabra secreta de tipo char[]
     * @param letra Recibe la letra que introduce el jugador que esté adivinando
     * @return Devuelve true si el elemento o la palabraSecreta de las letras es igual a la letra
     * que introduce el jugador que esté adivinando, si no false
     */
    public static boolean ganadorPartida(char[] palabraSecreta, char letra) {
        boolean gana = false;

        for (char elemento : palabraSecreta) {
            if (Character.toLowerCase(elemento) == Character.toLowerCase(letra)) {
                gana = true;
            }
        }
        return gana;
    }

    static void main() {
        //Variables
        String jugadorA;
        char jugadorB;
        int contador = 7;
        boolean ganador;
        char[] palabraSecreta, letraAcertada;

        //El jugador A es el que introduce la palabra secreta y mostrara la longitud que empezara los guiones
        System.out.println(ROJO_NEGRITA+"Jugador A."+RESET+" Escriba una palabra: ");
        jugadorA = sc.nextLine();

        //La palabra secreta lo convierto en un array para recorrer en un bucle
        palabraSecreta = jugadorA.toCharArray();
        //Creo para guardar las letras acertadas o el inicio del juego en '-' o las dejo
        letraAcertada = new char[palabraSecreta.length];
        //Llamo a la función para empezar el juego con '-'
        inicioJuego(palabraSecreta, letraAcertada);

        //Aquí estoy diciendo que si el contador es mayor que 0 y si el variable array que está guardando la letra
        //no es igual a la palabra secreta se sigue
        while (!Arrays.equals(letraAcertada, palabraSecreta) && contador > 0) {
            //Uso String.valueOf para que me pase el array en un String y muestra los intentos y las letras acertadas
            System.out.println(String.valueOf(letraAcertada) + " Intentos: " + contador);
            //El jugador B introduce una letra para adivinar la palabra secreta
            System.out.print(AZUL_NEGRITA+"Jugador B."+RESET+" Letra: ");
            jugadorB = sc.next().charAt(0);

            //Llamo a la función para que me muestre la letra acertada
            ahorcado(jugadorB, palabraSecreta, letraAcertada);

            //Guardo la función en un variable
            ganador = ganadorPartida(palabraSecreta, jugadorB);

            //Si la letra no coincide hago un -1 los intentos
            if (!ganador) {
                contador--;
            }
        }

        //Para saber quien gana utilizamos el contador porque son los intentos o las oportunidades para adivinarlo
        //la palabra secreta
        if (contador == 0) {
            System.out.println("Gana el jugador A");
        } else {
            System.out.println("Gana el jugador B");
        }
    }
}
