package practica_1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ej4extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lanzamiento = sc.nextLine()+"\n";

        ProcessBuilder processBuilder = new ProcessBuilder("java", "practica_1.ej4");
        File directory = new File("./out/production/ServiciosProcesos");
        processBuilder.directory(directory);
        Process process = null;

        try {
            process = processBuilder.start();

            //Envía la palabra escrita al Ejercicio4 en forma de bytes
            OutputStream os = process.getOutputStream();
            os.write(lanzamiento.getBytes());
            os.flush();

            //Se prepara para escribir la información que llegue del Ejercicio4
            FileWriter escribania = new FileWriter("salida-ej4.txt");
            BufferedWriter escritor = new BufferedWriter(escribania);

            //Se capta la información del Ejercicio4 y se va escribiendo a través del escritor
            InputStream is = process.getInputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(is));
            String linea = lector.readLine();
            while (linea != null) {
                escritor.write(linea);
                escritor.newLine();
                linea = lector.readLine();
            }
            escritor.close();
            lector.close();
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
