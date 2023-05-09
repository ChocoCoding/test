import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementa un programa que lea el contenido de un fichero y cuente el número de letras mayúsculas.
 * */
public class _02_ContarMayus {
    public void contarMayus(){
        File file = new File(".\\prueba.txt");
        int contador = 0;
        int c;
        try {
            FileReader fr = new FileReader(file);
            while ((c = fr.read()) != -1){
                if (c >= 65 && c <= 90){
                    contador++;
                }
            }
            System.out.println("Hay " + contador + " mayusculas");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException ex){
            throw new RuntimeException();
        }

    }

}
