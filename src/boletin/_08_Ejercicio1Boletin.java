package boletin;

import java.io.*;

/**
 * A partir de un array con nombres de persona, escribir en un fichero denominado “datos.txt”
 * dichos nombres, cada uno en una línea. A continuación, leer los datos de nuevo del fichero y
 * mostrarlos por pantalla, indicando el índice de la posición que ocupa. Ejemplo de ejecución:
 * 1. Juan
 * 2. María
 * 3. Paco
 * */
public class _08_Ejercicio1Boletin {
    public void escribirNombres(){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.txt"));
            String[] nombres = {"Paco","Lucia","Manuel","Susana","Puma"};

            for (String nombre : nombres) {
                dos.writeUTF(nombre + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void leerNombres(){
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("datos.txt"));
            String linea;
            int cont = 0;
            while (dis.available() != 0){
                linea = dis.readUTF();
                System.out.println(cont + "." + linea);
                cont++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
