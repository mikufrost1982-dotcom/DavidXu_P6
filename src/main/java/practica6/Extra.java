package practica6;

import java.util.Scanner;

/***
 * Este programa es contar las letras que se han repetido
 * @author David Xu
 * @version v1 14/03/2026
 */
public class Extra {
    public static Scanner sc = new Scanner(System.in);

    /***
     * Nos da los números decimales aleatorios (Math.random() * (Máximo - Mínimo) + Mínimo)
     * @return Devuelve número aleatorio entra '-' '|' 95-124
     */
    public static double cpAleatoriaSueloValla() {
        int barraVertical = '|';
        int guionBajo = '_';

        return (Math.random() * (barraVertical - guionBajo) + guionBajo);
    }

    /***
     * Nos genera un circuito con una longitud de mínimo 5
     * @param longitud Recibe la longitud para recorrer el for
     * @return Devuelve el circuito generado
     */
    public static String circuito(int longitud) {
        String generaCircuito = "";
        double numeroAleatorio, barraVertical = '|', guionBajo = '_',
                mitad = (barraVertical - guionBajo) / 2 + guionBajo;

        for (int i = 0; i < longitud; i++) {
            numeroAleatorio = cpAleatoriaSueloValla();
            if (numeroAleatorio > guionBajo && numeroAleatorio < mitad) {
                generaCircuito += (char) guionBajo;
            } else if (numeroAleatorio < barraVertical) {
                generaCircuito += (char) barraVertical;
            }
        }
        return generaCircuito;
    }

    public static void mostrarCircuito(String circuito) {
        System.out.println("Circuito: " + circuito);
    }

    /***
     * El usuario introduce run and jump para el circuito
     * @param longitud Recibe la longitud del circuito
     * @return Devuelve un String[] con run jump
     */
    public static String[] empiezaElJuego(int longitud) {
        String[] eleccionAtleta = new String[longitud];
        sc.nextLine();
        for (int i = 0; i < eleccionAtleta.length; i++) {
            eleccionAtleta[i] = sc.nextLine();
        }
        return eleccionAtleta;
    }

    /***
     * Comprueba si coincide run and jump y el circuito si es distinto '-' '|' se pone X de que ha caído,
     * si no es el caso el circuito se dejará como estaba no lo tocamos
     * @param sueloValla Recibe run jump
     * @param atleta Recibe el usuario que ha introducido run jump de la función empiezaElJuego()
     * @param circuito Recibe el circuito que hemos generado
     * @return Devuelve el circuito con X o sin X
     */
    public static String compruebaSaltosOCorres(String[] sueloValla, String[] atleta, String circuito) {
        String meta = "";
        char barraVertical = '|', guionBajo = '_';

        for (int i = 0; i < atleta.length; i++) {
            if (!atleta[i].equalsIgnoreCase(sueloValla[0]) && circuito.charAt(i) != barraVertical) {
                meta += 'X';
            } else if (!atleta[i].equalsIgnoreCase(sueloValla[1]) && circuito.charAt(i) != guionBajo) {
                meta += 'X';
            } else {
                meta += circuito.charAt(i);
            }
        }
        return meta;
    }

    /***
     * Comprobamos el circuito contiene una X
     * @param circuitoRecorrido Recibe el circuito con la X o sin la X
     * @return Devuelve true si no contiene la X y false contiene
     */
    public static boolean llegaMeta(String circuitoRecorrido) {
        return !circuitoRecorrido.contains("X");
    }

    static void main() {
        //Variable
        String circuito, meta;
        String[] sueloValla = {"run", "jump"}, atleta;
        int longitudCircuito = 0;
        boolean haLlegadoALaMeta;

        //Pedimos una longitud al usuario para poder generar el circuito
        while (longitudCircuito < 5) {
            System.out.println("Introduce una longitud mínimo 5");
            longitudCircuito = sc.nextInt();
        }

        //Generamos el circuito y nos muestra el circuito generado
        circuito = circuito(longitudCircuito);
        mostrarCircuito(circuito);

        //Pedimos al atleta que introduzca run and jump
        System.out.println("Empieza la carrera (jump-salta / run-corre)");
        atleta = empiezaElJuego(longitudCircuito);

        //Comprobamos si el circuito ha superado o no ha superado el atleta
        meta = compruebaSaltosOCorres(sueloValla, atleta, circuito);
        System.out.println(meta);

        //Comprobamos si el atleta ha llegado a la meta del circuito
        haLlegadoALaMeta = llegaMeta(meta);
        if (haLlegadoALaMeta) {
            System.out.println("Has superado la carrera");
        } else {
            System.out.println("Has perdido");
        }
    }
}
