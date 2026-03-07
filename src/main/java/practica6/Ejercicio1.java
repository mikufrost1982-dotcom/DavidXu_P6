package practica6;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    public static Scanner sc=new Scanner(System.in);

    public static void inicioPista(char[]palabraSecreta,char[]pista){
        for (int i = 0; i < palabraSecreta.length; i++) {
            pista[i]='-';
        }
    }

    public static void actualizarPista(char letra,char[]palabraSecreta, char[]pistaActual){

        for (int i = 0; i < palabraSecreta.length; i++) {
            if (Character.toLowerCase(palabraSecreta[i])==Character.toLowerCase(letra)){
                pistaActual[i]=palabraSecreta[i];
            }
        }
    }

    public static boolean ganadorPartida (char[]pista, char[]palabraSecreta,char letra){
        boolean gana = false;

        for (char elemento : palabraSecreta) {
            if (Character.toLowerCase(elemento) == Character.toLowerCase(letra)) {
                gana = true;
            }
        }
        return gana;
    }
    static void main() {
        String jugadorA;
        char jugadorB;
        int contador=7;
        boolean ganador = false;
        char[]palabraSecreta, pista;

        System.out.println("\u001B[31m\u001B[1mJugador A.\u001B[0m Escriba una palabra: ");
        jugadorA=sc.nextLine();

        palabraSecreta=jugadorA.toCharArray();
        pista=new char[palabraSecreta.length];
        inicioPista(palabraSecreta,pista);

        while(!Arrays.equals(pista,palabraSecreta)&&contador>0){
            System.out.println(String.valueOf(pista) +" Intentos: "+contador);
            System.out.print("\u001B[34m\u001B[1mJugador B.\u001B[0m Letra: ");
            jugadorB=sc.next().charAt(0);

            actualizarPista(jugadorB,palabraSecreta,pista);

            ganador=ganadorPartida(pista,palabraSecreta,jugadorB);

            if (!ganador){
                contador--;
            }

        }
        if (contador==0){
            System.out.println("Gana el jugador A");
        }else {
            System.out.println("Gana el jugador B");
        }
    }
}
