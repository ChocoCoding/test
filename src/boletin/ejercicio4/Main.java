package boletin.ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Agenda agenda = new Agenda();
        do {
            System.out.println("\n********************** Bienvenido a tu agenda *****************************");
            System.out.println("\n\t1. Añadir Contacto.\t\t\t\t\t4. Listar Contactos.");
            System.out.println("\n\t2. Buscar Contacto.\t\t\t\t\t\t0. Salir.");
            System.out.println("\n\t3. Eliminar Contacto.\t\t\t\t\t");
            System.out.println("\n**************************************************************************");
            System.out.println("Introduce una opcion");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Nombre del contacto");
                    String nombre = sc.next();
                    System.out.println("Direccion del contacto");
                    String direccion =sc.next();
                    System.out.println("Telefono del contacto");
                    String telefono =sc.next();
                    Contacto contacto = new Contacto(nombre,direccion,telefono);
                    agenda.anhadirContacto(contacto);
                    break;
                case 2:
                    System.out.println("Introduce el nombre del contacto que quieres buscar");
                    String nombreBuscar = sc.next();
                    System.out.println(agenda.buscarContacto(nombreBuscar));
                    break;
                case 3:
                    System.out.println("Introduce el nomnbre del contacto que quieres eliminar: ");
                    String nombreEliminar = sc.next();
                    agenda.eliminarContacto(nombreEliminar);
                    break;
                case 4:
                    System.out.println(agenda.listarContactos());
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opcion seleccionada es incorrecta, introduce otra opcion");
            }
        }while (opcion != 0);


    }
}
