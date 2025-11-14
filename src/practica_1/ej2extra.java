package practica_1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ej2extra {
    /* A continuación, crea un segundo programa Java que introduzca por teclado una cadena y
    ejecute el programa anterior para visualizar 5 veces esa cadena.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        ProcessBuilder processBuilder = new ProcessBuilder("java", "practica_1.ej2", cadena);
        Process process = null;
        File file = new File("./out/production/ServiciosProcesos");
        processBuilder.directory(file);

        try {
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            int c = inputStream.read();
            while (c != -1) {
                System.out.print((char) c);
                c = inputStream.read();
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
