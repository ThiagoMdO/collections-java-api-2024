package main.java.list.pesquisa.desafio.somaNumeros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SomaNumeros {

    List<Integer> numeros;

    public SomaNumeros(){
        numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public Integer calcularSoma_Lambda(){
        return numeros.stream().mapToInt(numero -> numero).sum();
    }

    public Integer calcularSoma_For(){
        Integer sum = 0;
        for (Integer numero : numeros){
            sum += numero;
        }
        return sum;
    }

    public Integer encontrarMaiorNumero_Lambda(){
        return numeros.stream().max(Integer::compareTo).orElse(null);
    }

    public Integer encontrarMaiorNumero_For(){
        if (numeros.isEmpty()){
            return null;
        }
        Integer num = numeros.get(0);
        for (Integer numero : numeros){
            if (numero > num){
                num = numero;
            }
        }
        return num;
    }

    public Integer encontrarMenorNumero_Lambda(){
        return numeros.stream().min(Integer::compareTo).orElse(null);
    }

    public Integer encontrarMenorNumero(){
        if (numeros.isEmpty()){
            return null;
        }
        Integer num = numeros.get(0);
        for (Integer numero : numeros){
            if (numero < num){
                num = numero;
            }
        }
        return num;
    }

    public List<Integer> exibirNumeros(){
        return numeros;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(4);
        somaNumeros.adicionarNumero(5);

        System.out.println(somaNumeros.exibirNumeros());

        System.out.println(somaNumeros.calcularSoma_For());

        System.out.println(somaNumeros.encontrarMaiorNumero_For());
        System.out.println(somaNumeros.encontrarMenorNumero());

        System.out.println();
        System.out.println("Lambda");
        System.out.println(somaNumeros.calcularSoma_Lambda());
        System.out.println(somaNumeros.encontrarMaiorNumero_Lambda());
        System.out.println(somaNumeros.encontrarMenorNumero_Lambda());


    }
}
