package basics;

import java.io.*;

public class LanzarComandoCMDError {
    public static void main(String[] args) {
        System.out.println("Aquí comienza el lanzado.");
        ProcessBuilder creadorDeProceso = new ProcessBuilder("cmd", "/C", "dir");
        File file = new File("C:\\Users");
        creadorDeProceso.directory(file);
        Process proceso = null;
        int c;

        try {
            proceso = creadorDeProceso.start();
            InputStream is = proceso.getInputStream();
            InputStream err = proceso.getErrorStream();

            if (is.read() == -1) {
                imprimirResultadoProceso(err);
            } else {
                imprimirResultadoProceso(is);
            }

            int codigoSalidaProceso = proceso.waitFor();

            System.out.println("Valor de salida es: " + codigoSalidaProceso);
            System.out.println("Aquí se acaba la ejecución del programa lanzado.");

        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public static void imprimirResultadoProceso(InputStream info) {
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(info));
            String linea = lector.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("MÉTODO");
            e.printStackTrace();
        }
    }

}
