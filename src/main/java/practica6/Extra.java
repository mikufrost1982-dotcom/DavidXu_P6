package practica6;

import java.util.Scanner;

public class Extra {
    public static Scanner sc=new Scanner(System.in);

    public static double cpAleatoriaSueloValla(){
        int barraVertical = '|';
        int guionBajo= '_';

        return (Math.random() * (barraVertical-guionBajo)+guionBajo);
    }

    public static String circuitoCarrera(int longitud){
        String circuito="";
        double generaCircuito;
        double barraVertical = '|', guionBajo= '_',
        mitad = (barraVertical - guionBajo)/2+guionBajo;


        for (int i = 0; i < longitud; i++) {
            generaCircuito=cpAleatoriaSueloValla();
            if (generaCircuito>guionBajo&&generaCircuito<mitad){
                circuito+=(char)guionBajo;
            }else if (generaCircuito<barraVertical){
                circuito+=(char)barraVertical;
            }
        }
        return circuito;
    }

    public static void mostrarCircuito(String circuito){
        System.out.println("Circuito: "+circuito);
    }


    static void main() {
        String circuito;
        String[]sueloValla={"run","jump"};
        int longitudCircuito = 0;

        while(longitudCircuito<5){
            System.out.println("Introduce una longitud mínimo 5");
            longitudCircuito= sc.nextInt();
        }

        circuito=circuitoCarrera(longitudCircuito);
        mostrarCircuito(circuito);
    }
}
