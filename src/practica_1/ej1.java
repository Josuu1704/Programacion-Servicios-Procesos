package practica_1;

public class ej1 {
    /**
     * Realiza un programa que admita argumentos desde main()
     * System.exit()
     * Si el número de argumentos es <1 devolveis 1
     * Si el argumento es una cadena, 2
     * Si el argumento es un numero entero menor que 0, 3
     * Cualquier otra situación: 0
     */

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(1);
            System.exit(1);
        } else if (isNumeric(args[0])) {
            if (Integer.parseInt(args[0] ) < 0) {
                System.out.println(3);
                System.exit(3);
            }
            System.out.println(2);
            System.exit(2);
        }
    }

    public static boolean isNumeric(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
