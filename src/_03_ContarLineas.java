import java.io.FileInputStream;
import java.io.IOException;

public class _03_ContarLineas {
    FileInputStream fis;
    public void contarLineas(){
        try {
            fis = new FileInputStream(".\\prueba.txt");
            int contLineas = 1;
            int c;

            while ((c = fis.read()) != -1){
                if (c==10){
                    contLineas++;
                }
            }
            System.out.println("Hay " + contLineas + " saltos de linea");
        } catch (IOException e) {
            // manejar la excepción
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
