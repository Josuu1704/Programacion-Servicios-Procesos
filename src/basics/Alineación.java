package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Alineación {
    /*Nombre del equipo
      Basic.Alineación: 433, 532

      Meter un alineación de un equipo. El programa tendrá que imprimir
      el nombre del equipo y los números de camiseta de los jugadores en su posición.
       */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Leer la alineación

        System.out.println("Introduce el nombre del equipo:");
        String nombreEquipo = sc.nextLine();

        String alineaciónStr = "";
        boolean alineacionCorrecta = false;
        while (!alineacionCorrecta) {
            System.out.println("Introduce la alineación (4-2-2)");
            alineaciónStr = sc.next();
            alineacionCorrecta = comprobarAlineacion(alineaciónStr);
        }

        String[] alineacion = alineaciónStr.split("-");


        // Leer los dorsales
        ArrayList<Integer> defensa = new ArrayList<>();
        ArrayList<Integer> medioCentro = new ArrayList<>();
        ArrayList<Integer> delantera = new ArrayList<>();
        ArrayList<ArrayList<Integer>> equipo = new ArrayList<>();
        equipo.add(defensa);
        equipo.add(medioCentro);
        equipo.add(delantera);

        for (int i = 0; i < equipo.size(); i++) {
            Integer numJ = Integer.valueOf(alineacion[i]);
            for (int j = 0; j < numJ; j++) {
                System.out.println("Introduce el dorsal de la posición " + (j+1) + " en la línea " + (i+1));
                equipo.get(i).add(sc.nextInt());
            }
        }

        System.out.println("Basic.Alineación del " + nombreEquipo);

        // Colocar los dorsales en cada fila
        ArrayList<ArrayList> equipoDef = new ArrayList<>();
        ArrayList portero = new ArrayList();
        System.out.println("¿Cuál es el dorsal del portero?");
        portero.add(sc.nextInt());
        equipoDef.add(colocarJugadores(delantera));
        equipoDef.add(colocarJugadores(medioCentro));
        equipoDef.add(colocarJugadores(defensa));
        equipoDef.add(colocarJugadores(portero));

        // Imprimir el equipo
        printMatrix(equipoDef);
    }

    public static ArrayList colocarJugadores (ArrayList<Integer> dorsales) {
        int numJ = dorsales.size();
        ArrayList fila = new ArrayList();
        ArrayList<Integer> posicionesFila = new ArrayList<>();
        switch (numJ) {
            case (1):
                posicionesFila.add(2);
                break;
            case (2):
                posicionesFila.add(1);
                posicionesFila.add(3);
                break;
            case (3):
                posicionesFila.add(0);
                posicionesFila.add(2);
                posicionesFila.add(4);
                break;
            case (4):
                posicionesFila.add(0);
                posicionesFila.add(1);
                posicionesFila.add(3);
                posicionesFila.add(4);
                break;
            case (5):
                return dorsales;
        }

        for (int i = 0; i < 5; i++) {
            if (posicionesFila.contains(i)) {
                fila.add(dorsales.removeFirst());
            } else {
                fila.add(" ");
            }
        }

        return fila;
    }

    public static boolean comprobarAlineacion(String alineacion) {
        int sumador = 0;
        String [] al = alineacion.split("-");
        for (String num: al) {
            sumador += Integer.parseInt(num);
        }
        if (sumador != 10)
            return false;
        else
            return true;
    }

    public static void printMatrix(ArrayList<ArrayList> m) {
        for (int i = 0; i < m.size(); i++) {
            System.out.println((m.get(i).toString()));
        }

    }
}
