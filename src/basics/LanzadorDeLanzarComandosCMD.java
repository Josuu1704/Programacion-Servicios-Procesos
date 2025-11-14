package basics;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzadorDeLanzarComandosCMD {
    public static void main(String[] args) {
        System.out.println("Aquí comienza el lanzador.");

        ProcessBuilder constructorProceso = new ProcessBuilder("java", "basics.LanzarComandoCMD");
        Process proceso = null;
        File directorio = new File("./out/production/RepasoJava/"); //Le decimos donde ejecuta el comando java
        constructorProceso.directory(directorio); //añadimos el directorio (File) al constructor de proceso
        System.out.println("Directorio de trabajo: " + constructorProceso.directory());

        int c;
        try {
            proceso = constructorProceso.start();
            //-----------------------------------------------------------------
            InputStream chorro = proceso.getInputStream();
            c = chorro.read();
            while (c != -1) {
                System.out.print((char) c);
                c = chorro.read();
            }
            chorro.close();

            System.out.println("Aquí se acaba la ejecución del lanzador.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


