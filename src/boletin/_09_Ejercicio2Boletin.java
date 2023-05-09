package boletin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * A partir del ejercicio anterior, implementa un método que solicite un nombre de producto al
 * usuario y lo elimine del listado (del fichero). Deberá mostrar también su información por
 * pantalla (nombre y precio)
 */

public class _09_Ejercicio2Boletin {
    public void anhadirProductos() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("productos.txt"));
            String[] productos = {"Pescado", "Cereales", "Carne"};
            double[] precios = {10.0, 5.0, 6.7};

            for (int x = 0; x < productos.length; x++) {
                dos.writeUTF(productos[x] + " " + precios[x] + "€");
            }
            System.out.println("Fichero escrito");
            dos.close();
            leerProductos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void leerProductos() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("productos.txt"));
            String linea;
            while (dis.available() != 0) {
                linea = dis.readUTF();
                System.out.println(linea);
            }
            dis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        String lineaEliminar;
        File archivoEntrada = new File("productos.txt");
        File archivoTemp = new File("temp.txt");

        System.out.println("Introduce el producto a eliminar");
        lineaEliminar = sc.nextLine();

        try {
            DataOutputStream escritor = new DataOutputStream(new FileOutputStream(archivoTemp));
            DataInputStream lector = new DataInputStream(new FileInputStream(archivoEntrada));
            String lineaActual;
            ArrayList<String> productos = new ArrayList<>();

            try {
                while (true) {
                    lineaActual = lector.readUTF();
                    if (!lineaActual.split(" ")[0].equalsIgnoreCase(lineaEliminar)) {
                        productos.add(lineaActual);
                    } else {
                        System.out.println("Producto eliminado: " + lineaActual);
                    }
                }
            } catch (EOFException ex) {
                System.out.println("Fin del archivo");
            }

            for (String prod : productos) {
                escritor.writeUTF(prod);
            }
            lector.close();
            escritor.close();

            if (!archivoEntrada.delete()) {
                System.out.println("No se pudo eliminar el archivo original");
            }
            if (!archivoTemp.renameTo(archivoEntrada)) {
                System.out.println("No se pudo renombrar el archivo temporal");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
