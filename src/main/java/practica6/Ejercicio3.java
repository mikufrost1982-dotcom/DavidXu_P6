package practica6;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    public static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println("1. Nuevo contacto.");
        System.out.println("2. Buscar contacto.");
        System.out.println("3. Ver todo.");
        System.out.println("4. Borrar contacto.");
        System.out.println("5. Salir.");
    }

    public static String[] nuevoContacto(String[] agenda, String nombre, String telefono) {
        agenda = Arrays.copyOf(agenda, agenda.length + 1);
        agenda[agenda.length - 1] = nombre + " (" + telefono + ")";

        return agenda;
    }

    public static void buscarContacto(String[] agenda, String nombre) {
        int i = 0;
        String minusNombre = nombre.toLowerCase();

        while (i < agenda.length && !agenda[i].toLowerCase().startsWith(minusNombre)) {
            i++;
        }

        if (i < agenda.length) {
            System.out.println("Nombre: " + agenda[i] + '\n');
        } else {
            System.out.println("El contacto de la persona no existe\n");
        }
    }

    public static void mostrarTodo(String[] agenda) {
        for (String elemento : agenda) {
            System.out.println("Nombre: " + elemento);
        }
        System.out.println();
    }

    public static String[] borrarContacto(String[] agenda, String nombre) {
        int i = 0;
        String minusNombre = nombre.toLowerCase();

        while (i < agenda.length && !agenda[i].toLowerCase().startsWith(minusNombre)) {
            i++;
        }

        if (i < agenda.length) {
            agenda[i] = agenda[agenda.length - 1];
            agenda = Arrays.copyOf(agenda, agenda.length - 1);
        }

        return agenda;
    }

    static void main() {
        String[] contacto = new String[0];
        String nombrePersona, telefonoContacto;
        int opcion, longitudContacto;

        do {
            menu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    nombrePersona = sc.nextLine();

                    System.out.print("Teléfono: ");
                    telefonoContacto = sc.nextLine();

                    contacto = nuevoContacto(contacto, nombrePersona, telefonoContacto);
                    System.out.println();
                }

                case 2 -> {
                    sc.nextLine();
                    System.out.print("Nombre a buscar: ");
                    nombrePersona = sc.nextLine();

                    buscarContacto(contacto, nombrePersona);
                }

                case 3 -> {
                    mostrarTodo(contacto);
                }

                case 4 -> {
                    sc.nextLine();
                    System.out.print("Introduce el nombre del contacto: ");
                    nombrePersona = sc.nextLine();

                    longitudContacto = contacto.length;
                    contacto = borrarContacto(contacto, nombrePersona);

                    if (longitudContacto == contacto.length) {
                        System.out.println("La persona que quieres borrar no está en la agenda\n");
                    } else {
                        System.out.println("Contacto eliminado\n");
                    }
                }
            }
        } while (opcion != 5);
    }
}
