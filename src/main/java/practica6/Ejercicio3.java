package practica6;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    public static Scanner sc=new Scanner(System.in);

    public static void menu(){
        System.out.println("1. Nuevo contacto.");
        System.out.println("2. Buscar contacto.");
        System.out.println("3. Ver todo.\n");
        System.out.println("4. Borrar contacto.\n");
        System.out.println("5. Salir.");
    }

    public static String[]nuevoContacto(String[]agenda, String nombre){
        agenda=Arrays.copyOf(agenda,agenda.length+1);
        Arrays.fill(agenda, nombre);
        return agenda;
    }

    static void main() {
        String[]nombre=new String[0],telefono=new String[0];
        String nombrePersona, telefonoContacto;
        int opcion;

        do {
            menu();
            System.out.print("Elige una opción: ");
            opcion= sc.nextInt();

            switch (opcion){
                case 1->{
                    System.out.print("Nombre: ");
                    nombrePersona= sc.nextLine();
                    System.out.print("Teléfono: ");
                    telefonoContacto= sc.nextLine();

                    nombre=nuevoContacto(nombre,nombrePersona);
                }
            }
        }while(opcion!=5);
    }
}
