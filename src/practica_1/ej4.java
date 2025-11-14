package practica_1;

import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        if (isPalindromo(entrada)) {
            System.out.println("______________");
            System.out.println("Es palíndromo.");
            System.out.println("______________");
        } else {
            System.out.println("No es palíndromo.");
        }
    }

    public static boolean isPalindromo(String candidato) {
        for (int i = 0; i < Math.abs(candidato.length()/2); i++) {
            if (candidato.charAt(i) != candidato.charAt(candidato.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
