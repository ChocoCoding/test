import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class _04_ValoresAleatorios {
        /**
         * Programa que cree un fichero y escriba 100 valores numéricos enteros obtenidos aleatoricamente.
         * A continuación, el programa deberá mostrar su contenido en pantalla y calcular su media.
         * Si se abre el fichero con bloc de notas veremos que algunos caracteres son legibles.
         */
        public void valoresAleatorios(){
                DataOutputStream ficheroEscribir = null;
                DataInputStream ficheroLeer = null;

                try {
                        ficheroEscribir = new DataOutputStream(Files.newOutputStream(Paths.get(".\\numeros_aleatorios.txt"), CREATE, APPEND));
                        ficheroLeer = new DataInputStream(new FileInputStream(".\\numeros_aleatorios.txt"));
                        for (int x = 0;x <100; x++){
                                ficheroEscribir.writeInt((int) (Math.random()*100));
                        }
                        int total = 0;
                        int cont = 0;
                        while (ficheroLeer.available() != 0) {
                                int temp = ficheroLeer.readInt();
                                System.out.print(temp + " ");
                                total += temp;
                                cont++;
                        }
                        System.out.println("\nEl fichero contiene " + cont + " números");
                        System.out.println("La media es: " + (total / cont));
                        ficheroEscribir.close();
                        ficheroLeer.close();
                        if (cont >= 1000) {
                                try(OutputStream fic = Files.newOutputStream(Paths.get("100Numeros.txt"), DELETE_ON_CLOSE)) {
                                        System.out.println("Se han excedido los 1000 números. Fichero eliminado");
                                }catch (Exception e){
                                        System.err.println(e.getMessage());
                                }
                        }

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

                }

        }

