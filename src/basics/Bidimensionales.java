package basics;

import java.util.ArrayList;

public class Bidimensionales {
    public static void main(String[] args) {
        ArrayList<ArrayList> matriz = new ArrayList<>();
        Integer l = 5;

        for (int i = 0; i < l; i++) {
            matriz.add(new ArrayList());
            for (int j = 0; j < l; j++) {
                //if (i + j == l-1) {
                if (j == l-i-1) {
                    matriz.get(i).add(" ");
                } else {
                    matriz.get(i).add(0);
                }
            }
        }

        printMatrix(matriz);
    }

    public static void printMatrix(ArrayList<ArrayList> matriz) {
        for(ArrayList<Integer> fila: matriz) {
            System.out.println(fila);
        }
    }
}
