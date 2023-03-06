import java.io.*;
import java.security.Key;

public class CrearMensaje {
    public static void main(String[] args) {
        Key clave=Cifrador.generatePassword("1234567891234567");
        String mensajeCifrado=Cifrador.cifrar(clave);
        escribirEnFichero(mensajeCifrado);
    }
    public static void escribirEnFichero(String mensajeCifrado){
        try {
            String fileName = "src/mensaje.txt";
            File myFile = new File(fileName);
            FileWriter fw=new FileWriter(myFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mensajeCifrado);
            bw.newLine();
            bw.close();
        }catch (FileNotFoundException e){
            System.err.println("El fichero no ha sido encontrado");
        }
        catch (IOException e){
            System.out.println("Error con la escritura");
        }
    }
}
