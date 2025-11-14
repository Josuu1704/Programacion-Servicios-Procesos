package basics;

import java.io.IOException;
import java.io.InputStream;

public class LanzarComandoCMD {
    public static void main(String[] args) {
        System.out.println("Aquí comienza el lanzado.");
        ProcessBuilder creadorDeProceso = new ProcessBuilder("cmd", "/C", "dir");
        Process proceso = null;
        int c;

        try {
            proceso = creadorDeProceso.start();
            InputStream chorro = proceso.getInputStream();

            c = chorro.read();
            while (c != -1) {
                System.out.print((char) c);
                c = chorro.read();
            }
            chorro.close();

            int codigoSalidaProceso = proceso.waitFor();


            System.out.println("Valor de salida es: " + codigoSalidaProceso);
            System.out.println("Aquí se acaba la ejecución del programa lanzado.");

        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
