package main.java.map.operacoesBasicas.desafio;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dicionario {

    private Map<String, String> palavrasDicionario = new HashMap<>();

    public void adicionarPalavra(String palavra, String definicao){
        palavrasDicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if (!palavrasDicionario.isEmpty())
            palavrasDicionario.remove(palavra);
    }

    public Map<String, String> exibirPalavras(){
        if (!palavrasDicionario.isEmpty())
            return palavrasDicionario;
        return Collections.emptyMap();
    }

    public String pesquisarPorPalavra(String palavra){
        return palavrasDicionario.get(palavra);
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Dicionario", "Livro de palavras que possue seus significados");
        dicionario.adicionarPalavra("Dicionario", "Livro de palavras que possue seus significados");
        dicionario.adicionarPalavra("Livro", "Que contem informações sobre determinado assunto");
        dicionario.adicionarPalavra("Assunto", "É uma linha de pensamentos, topicos relalacionado há alguma coisa");

        System.out.println(dicionario.exibirPalavras());

        dicionario.removerPalavra("Livro");
        System.out.println(dicionario.exibirPalavras());

        System.out.println(dicionario.pesquisarPorPalavra("Dicionario"));
    }

}
