import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _01_ContarCaracteres {

    public void contarCaracteres(){
        try {
            FileReader fr =  new FileReader(".\\prueba.txt");
            int c;
            while ((c = fr.read()) != -1) {
                if (c != 32){
                    System.out.print((char)c);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
