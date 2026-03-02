package practica6;

import java.util.Scanner;

public class Ejercicio1 {
    public static Scanner sc=new Scanner(System.in);

    public static void ahorcado(String jugadorA, char jugadorB){
        String adivinar="";
        char minusJugadorB=Character.toLowerCase(jugadorB);
        String minusJugadorA=jugadorA.toLowerCase();

        for (int i=0;i<jugadorA.length();i++){
            if(minusJugadorA.charAt(i)==minusJugadorB){
                adivinar+=jugadorA.charAt(i);
            }else {
                adivinar+="-";
            }
        }
        System.out.print(adivinar);
    }

    //public static String guardaPista(String jugadorA, String pista){

    //}

    public static boolean ganador(String jugadorA, String pista){

        return jugadorA.equalsIgnoreCase(pista);
    }
    static void main() {
        String jugadorA, ahorcado, pista = "";
        char jugadorB = ' ';
        int contador=7;
        boolean ganador;

        System.out.println("\u001B[31m\u001B[1mJugador A.\u001B[0m Escriba una palabra: ");
        jugadorA=sc.nextLine();

        while(contador>0){
            ahorcado(jugadorA,jugadorB);
            System.out.println(" Intentos: "+contador);
            System.out.print("\u001B[34m\u001B[1mJugador B.\u001B[0m Letra: ");
            jugadorB=sc.next().charAt(0);


            ganador=ganador(jugadorA,jugadorB);
            if (!ganador){
                System.out.println("Gana el jugador A");
                contador--;
            }
            if (ganador){
                System.out.println("Gana el jugador B");
            }


        }
    }
}
