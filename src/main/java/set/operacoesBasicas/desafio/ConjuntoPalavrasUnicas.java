package main.java.set.operacoesBasicas.desafio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas(){
        palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra_Lambda(String palavra){
        palavrasUnicas.removeIf(p -> p.equalsIgnoreCase(palavra));
    }

    public void removerPalavra(String palavra){
        palavrasUnicas.remove(palavra);
    }

    public void verificarPalavra_Lambda(String palavra){
        if(palavrasUnicas.contains(palavra))
            System.out.println("A palavra " + palavra + " já contem na lista");
        else
            System.out.println("A palavra " + palavra + " não está na lista");
    }

    public Set<String> exibirPalavrasUnicas(){
        return palavrasUnicas;
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavrasUnicas = new ConjuntoPalavrasUnicas();

        palavrasUnicas.adicionarPalavra("Palavra 1");
        palavrasUnicas.adicionarPalavra("Palavra 2");
        palavrasUnicas.adicionarPalavra("Palavra 3");
        palavrasUnicas.adicionarPalavra("Palavra 4");

        System.out.println(palavrasUnicas.exibirPalavrasUnicas());

        palavrasUnicas.removerPalavra("Palavra 1");
        System.out.println(palavrasUnicas.exibirPalavrasUnicas());

        palavrasUnicas.removerPalavra_Lambda("Palavra 4");
        System.out.println(palavrasUnicas.exibirPalavrasUnicas());

        palavrasUnicas.verificarPalavra_Lambda("Palavra");
        palavrasUnicas.verificarPalavra_Lambda("Palavra 2");
    }
}
