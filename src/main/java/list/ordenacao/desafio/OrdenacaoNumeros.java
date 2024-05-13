package main.java.list.ordenacao.desafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoNumeros {

    List<Integer> integerList;

    public OrdenacaoNumeros() {
        integerList = new ArrayList<>();
    }

    public void adicionarNumero(Integer numero) {
        integerList.add(numero);
    }

    public List<Integer> ordenarAscendente_Lambda() {
        return integerList.stream()
                            .sorted(Integer::compareTo)
                            .collect(Collectors.toList());
    }

    public List<Integer> ordenarAscendente_Comparator() {
        List<Integer> list = new ArrayList<>(integerList);
        Collections.sort(list, new OrderCrescenteComparator());
        return list;
    }

    public List<Integer> ordenarDescendente_Lambda(){
        return integerList.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList());
    }

    public List<Integer> ordenarDescendente_Comparator(){
        List<Integer> list = new ArrayList<>(integerList);
        Collections.sort(list, new OrderDecrescenteComparator());
        return list;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(1);
        numeros.adicionarNumero(12);
        numeros.adicionarNumero(9);
        numeros.adicionarNumero(22);
        numeros.adicionarNumero(11);


        System.out.println("Lambda crescente");
        System.out.println(numeros.ordenarAscendente_Lambda());

        System.out.println();
        System.out.println("Comparator crescente");
        System.out.println(numeros.ordenarAscendente_Comparator());

        System.out.println();

        System.out.println("Lambda decrescente");
        System.out.println(numeros.ordenarDescendente_Lambda());

        System.out.println("Comparator decrescente");
        System.out.println(numeros.ordenarDescendente_Comparator());

    }
}

class OrderCrescenteComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}

class OrderDecrescenteComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(-o1, -o2);
    }
}
