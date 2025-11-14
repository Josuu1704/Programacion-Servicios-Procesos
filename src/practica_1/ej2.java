package practica_1;

public class ej2 {
     /*Crea un programa Java que visualice 5 veces la cadena que se le envía desde los
    argumentos de main().

    Si no se le envía ninguna cadena que muestre un mensaje indicándolo y
    que finalice el programa con System.exit(1).

    A continuación, crea un segundo programa Java que introduzca por teclado una cadena y
    ejecute el programa anterior para visualizar 5 veces esa cadena.*/

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");

        if (args.length == 0) {
            System.out.println("No hay cadena, finalizando con código 1.");
            System.exit(1);
        }

        for (int i = 0; i < 5; i++) {
            //System.out.println(Arrays.toString(args));
            System.out.println(args[0]);
        }
    }
}
