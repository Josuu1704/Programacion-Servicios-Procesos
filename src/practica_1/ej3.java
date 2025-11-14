package practica_1;
import java.io.*;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        ProcessBuilder processBuilder = new ProcessBuilder("java", "practica_1.Ejercicio2", cadena);
        File file = new File("./out/production/RepasoJava");
        processBuilder.directory(file);

        try {
            Process process = processBuilder.start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea = lector.readLine();
            if (linea == null) {
                System.out.println("No hay entrada de información.");
            } else {
                BufferedWriter escritor = new BufferedWriter(new FileWriter("archivo-ej3.txt"));
                while (linea != null) {
                    escritor.write(linea);
                    escritor.newLine();
                    linea = lector.readLine();
                }
                escritor.close();
            }
            System.out.println("El valor de salida es: "+process.exitValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
