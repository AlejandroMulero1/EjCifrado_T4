import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class LeerMensaje {
    public static void main(String[] args) {
        Key clave=Cifrador.generatePassword("1234567891234567");
        String mensajeCifrado=leerFichero();
        String mensajeDescifrado=Cifrador.descifrar(clave, mensajeCifrado);
        System.out.println(mensajeDescifrado);
    }

    public static String leerFichero(){
        BufferedReader br = null;
        String contenido="";

        try {
            br = new BufferedReader(new FileReader("src/mensaje.txt"));
            Scanner sc = new Scanner(br);

            // Se lee el fichero
            while (sc.hasNext()) {
                contenido = sc.nextLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return contenido;
    }

}

