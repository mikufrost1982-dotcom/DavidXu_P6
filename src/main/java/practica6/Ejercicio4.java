package practica6;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {
    public static Scanner sc=new Scanner(System.in);

    public static char[] transformarArrays(String frase){
        return frase.toCharArray();
    }

    public static String codificacion(String frase, char[]conjunto1, char[]conjunto2){
        String transformaTexto="";
        char[]fraseTransformado=transformarArrays(frase);

        

        return transformaTexto;
    }

    public static void mostrarCodificado(String codificado){
        System.out.println(codificado);
    }

    static void main() {
        char[]conjunto1={'e','i','k','m','p','q','r','s','t','u','v'},
              conjunto2={'p','v','i','u','m','t','e','r','k','q','s'};
        String frase, codificarOtra, codificado;

        do {
            System.out.print("Introduzca un texto a codificar: ");
            frase= sc.nextLine();

            codificado=codificacion(frase,conjunto1,conjunto2);

            mostrarCodificado(codificado);

            System.out.print("¿Quieres codificar otro texto?: ");
            codificarOtra= sc.nextLine();

            if (codificarOtra.equalsIgnoreCase("si")){
                System.out.print("Introduzca un texto a codificar: ");
                frase= sc.nextLine();

                codificado=codificacion(frase,conjunto1,conjunto2);

                mostrarCodificado(codificado);
            }
        }while(!codificarOtra.equalsIgnoreCase("no"));
    }
}
