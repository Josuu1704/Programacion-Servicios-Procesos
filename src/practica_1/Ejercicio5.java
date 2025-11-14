package practica_1;
import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        File file = new File("ejercicio5.txt");
        File ficheroCodigo = new File("./out/production/ServiciosProcesos");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String linea = bufferedReader.readLine();
            if (linea != null) {
                ProcessBuilder processBuilder = new ProcessBuilder("java", "practica_1.ej4");
                processBuilder.directory(ficheroCodigo);
                Process process = processBuilder.start();

                OutputStream os = process.getOutputStream();
                os.write((linea+"\n").getBytes());
                os.flush();

                InputStream is = process.getInputStream();
                int c = is.read();
                while (c != -1) {
                    System.out.print((char) c);
                    c = is.read();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
