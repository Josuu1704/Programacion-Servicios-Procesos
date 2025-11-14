package basics;

import java.io.IOException;

public class LanzarPrograma {
    public static void main(String[] args) {
        ProcessBuilder constructorProcesos = new ProcessBuilder("notepad");
        try {
            constructorProcesos.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
