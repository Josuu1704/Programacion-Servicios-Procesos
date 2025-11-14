package basics;
import java.io.*;
import java.util.Scanner;

public class SalidaDatos {
    public static void main(String[] args) {
        ProcessBuilder creadorDeProceso = new ProcessBuilder("cmd", "/C", "DATE");
        Process ps = null;
        String fecha = new Scanner(System.in).nextLine();
        try {
            ps = creadorDeProceso.start();
            OutputStream os = ps.getOutputStream();
            os.write(fecha.getBytes());
            os.flush();

            InputStream is = ps.getInputStream();
            InputStream err = ps.getErrorStream();
            imprimirResultadoProceso(is);
            imprimirResultadoProceso(err);
            /*int c = is.read();
            while (c != -1) {
                System.out.print((char) c);
                c = is.read();
            }*/
            is.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
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
