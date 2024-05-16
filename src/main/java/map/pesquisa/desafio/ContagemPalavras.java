package main.java.map.pesquisa.desafio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContagemPalavras {

    private Map<String, Integer> listPalavras;

    public ContagemPalavras(){
        listPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        listPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        listPalavras.remove(palavra);
    }

    public Integer exibirContagemPalavras_Lambda(){
        return listPalavras.values().stream().mapToInt(Integer::intValue).sum();
    }

    public Integer exibirContagemPalavras(){
        Integer contagem = 0;
        for (Integer c : listPalavras.values()){
            contagem += c;
        }
        return contagem;
    }

    //copiado, para estudar
    public String encontrarPalavraMaisFrequente_Lambda() {
        Optional<Map.Entry<String, Integer>> maxEntry = listPalavras.entrySet()
        .stream()
        .max(Map.Entry.comparingByValue());

        return maxEntry.map(Map.Entry::getKey).orElse(null);
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : listPalavras.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Java", 7);
        contagemPalavras.adicionarPalavra("JDK", 4);
        contagemPalavras.adicionarPalavra("Docker", 7);
        contagemPalavras.adicionarPalavra("JS", 10);

        System.out.println(contagemPalavras.exibirContagemPalavras_Lambda());
        System.out.println(contagemPalavras.exibirContagemPalavras());

        contagemPalavras.removerPalavra("JS");

        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente_Lambda());
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());


    }
}
