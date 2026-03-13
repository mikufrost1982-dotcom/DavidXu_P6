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

    public static String[] empiezaElJuego(int longitud){
        String[] eleccionAtleta=new String[longitud];
        sc.nextLine();
        for (int i = 0; i < eleccionAtleta.length; i++) {
            eleccionAtleta[i]=sc.nextLine();
        }
        return eleccionAtleta;
    }

    public static String compruebaSaltosOCorres(String[] sueloValla,String[] atleta,String circuito){
        String meta="";
        char barraVertical = '|', guionBajo= '_';

        for (int i = 0; i < atleta.length; i++) {
            if (!atleta[i].equalsIgnoreCase(sueloValla[0])&&circuito.charAt(i)!=barraVertical){
                meta+='X';
            } else if (!atleta[i].equalsIgnoreCase(sueloValla[1])&&circuito.charAt(i)!=guionBajo) {
                meta+='X';
            }else {
                meta+=circuito.charAt(i);
            }
        }
        return meta;
    }

//    public static boolean llegaMeta(String circuito, int longitud){
//
//    }
    static void main() {
        String circuito, meta;
        String[]sueloValla={"run","jump"},atleta;
        int longitudCircuito = 0;

        while(longitudCircuito<5){
            System.out.println("Introduce una longitud mínimo 5");
            longitudCircuito= sc.nextInt();
        }

        circuito=circuitoCarrera(longitudCircuito);
        mostrarCircuito(circuito);

        System.out.println("Empieza la carrera (jump-salta / run-corre)");

        atleta=empiezaElJuego(longitudCircuito);
        meta=compruebaSaltosOCorres(sueloValla,atleta,circuito);
        System.out.println(meta);
    }
}
