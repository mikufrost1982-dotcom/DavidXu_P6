package practica6;

import java.util.Arrays;
import java.util.Scanner;

/***
 * Es un programa que le podemos llamar agenda o contacto. Básicamente los contactos de tu móvil
 * @author David Xu
 * @version v1 13/03/2026
 */
public class Ejercicio3 {
    public static Scanner sc = new Scanner(System.in);

    /***
     * Menu de opciones para mostrar la funcionalidad que quieres hacer
     */
    public static void menu() {
        System.out.println("1. Nuevo contacto.");
        System.out.println("2. Buscar contacto.");
        System.out.println("3. Ver todo.");
        System.out.println("4. Borrar contacto.");
        System.out.println("5. Salir.");
    }

    /***
     * Añadir a una persona al contacto o agenda
     * @param agenda Recibe un contacto que está vació y sin especificar la longitud
     * @param nombre Recibe el nombre que introduce el usuario
     * @param telefono Recibe el teléfono que introduce el usuario
     * @return Devuelve el variable añadido y asignado el nombre y el teléfono
     */
    public static String[] nuevoContacto(String[] agenda, String nombre, String telefono) {
        agenda = Arrays.copyOf(agenda, agenda.length + 1);
        agenda[agenda.length - 1] = nombre + " (" + telefono + ")";

        return agenda;
    }

    /***
     * Buscamos el contacto que tenga ese nombre y muestra el nombre y el teléfono
     * (Use la función buscar en los array de tipo numérico no ordenados, pero se puede hacer con indexOf)
     * @param agenda Recibe los contactos que tiene el usuario
     * @param nombre Recibe un nombre que quiere buscar el usuario
     */
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

    /***
     * Muestra todos los contactos que tiene el usuario añadido
     * @param agenda Recibe los contactos que tiene
     */
    public static void mostrarTodo(String[] agenda) {
        for (String elemento : agenda) {
            System.out.println("Nombre: " + elemento);
        }
        System.out.println();
    }

    /***
     * Eliminamos el contacto que tenga ese nombre (también use la función buscar no ordenado, también se puede hacer con indexOf)
     * @param agenda Recibe el contacto que tiene el usuario
     * @param nombre Recibe el nombre que quise eliminar el usuario
     * @return Devuelve el contacto que introduzcó el nombre eliminado del contacto
     */
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
        //Variables
        String[] contacto = new String[0];
        String nombrePersona, telefonoContacto;
        int opcion, longitudContacto;

        do {
            //Llamamos a la función menu()
            menu();
            //Pedimos al usuario que quiere hacer
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            //Un switch para los casos que elige el usuario
            switch (opcion) {
                case 1 -> {
                    /**
                     * Podemos usar 2 Scanner o usar nextLine(), lo hacemos así,
                     * porque podemos evitar el búffer \n del nextInt
                     * Pedimos al usuario el contacto de la persona que quiere añadir
                     */
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    nombrePersona = sc.nextLine();

                    System.out.print("Teléfono: ");
                    telefonoContacto = sc.nextLine();

                    //Llamamos a la función para añadir la persona que quiso añadir el usuario
                    contacto = nuevoContacto(contacto, nombrePersona, telefonoContacto);
                    System.out.println();
                }

                case 2 -> {
                    //Pedimos al usuario la persona que quiere buscar
                    sc.nextLine();
                    System.out.print("Nombre a buscar: ");
                    nombrePersona = sc.nextLine();

                    //Llamamos a la función para buscar a la persona
                    buscarContacto(contacto, nombrePersona);
                }

                case 3 -> {
                    //Llamamos a la función para mostrar todos los contacto que tiene el usuario
                    mostrarTodo(contacto);
                }

                case 4 -> {
                    //Pedimos al usuario el contacto de la persona que quiere eliminar de la agenda
                    sc.nextLine();
                    System.out.print("Introduce el nombre del contacto: ");
                    nombrePersona = sc.nextLine();

                    //Para comprobar si ha eliminado podemos guardar en un variable la longitud del
                    //contacto
                    longitudContacto = contacto.length;
                    contacto = borrarContacto(contacto, nombrePersona);

                    //Comprobamos la longitud original si es igual a la nueva longitud nos dice no existe
                    //esa persona, si es contrario nos dirá ha sido eliminado
                    if (longitudContacto == contacto.length) {
                        System.out.println("La persona que quieres borrar no está en la agenda\n");
                    } else {
                        System.out.println("Contacto eliminado\n");
                    }
                }
            }
        } while (opcion != 5);//El programa seguirá repitiendo si la opción es distinto a 5
    }
}
