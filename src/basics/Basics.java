package basics;

import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> listaInicial = new ArrayList<>();
        listaInicial.add(2);
        listaInicial.add(3);

        System.out.println("1");
        System.out.println(listaInicial.size());
        addNumberToArraylist(listaInicial, 5);

        System.out.println("2");
        System.out.println(listaInicial);

        ArrayList<Integer> segundaLista = listaInicial;
        System.out.println("3");
        System.out.println(segundaLista);

        addNumberToArraylist(listaInicial, 6);
        System.out.println("4");
        System.out.println(listaInicial.size());
        System.out.println(segundaLista);
    }

    public static void addNumberToArraylist(ArrayList<Integer> lista, Integer numero) {
        lista.add(numero);
    }
}
