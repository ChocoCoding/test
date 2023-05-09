package boletin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EjercicioAgenda {
    private void cargarFichero() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.txt"))){
            String[] nombres = {"Pepe", "Ana", "Emma", "Marcos"};
            int[] telefonos = {611111111, 622222222, 633333333, 644444444};

            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i] + " " + telefonos[i] + "\n");
            }
            System.out.println("Fichero cargado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void busqueda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de contacto que desea buscar:");
        String nombre = sc.nextLine();

        try (DataInputStream dis = new DataInputStream(new ObjectInputStream(new FileInputStream("datos.txt")))) {
            String linea;
            while (true) {
                linea = dis.readUTF();

                if (linea.split(" ")[0].equalsIgnoreCase(nombre))
                    System.out.println(linea);
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EjercicioAgenda e = new EjercicioAgenda();
        e.cargarFichero();
        e.busqueda();
    }
}
