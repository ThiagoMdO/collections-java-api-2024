package main.java.map.ordenacao.desafio;

import java.util.*;
import java.util.stream.Collectors;

public class LivrariaOnline {

    private Map<String, Livro> listaLivrosMap;

    public LivrariaOnline(){
        listaLivrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, Double preco){
        listaLivrosMap.put(link, new Livro(titulo,autor, preco));
    }

    // Nesse caso pode remover mais de um livro, porque vai buscar somente pelo titulo,
    // pode haver mais de um site com o mesmo nome de livro e vai deletar todos,
    // com findFirst vai deletar somente o primeiro
    public void removerLivro_Lambda(String titulo){
        Map.Entry<String, Livro> stringLivroEntry = listaLivrosMap.entrySet().stream()
                                                                    .filter(entry -> entry.getValue().getTitulo().equalsIgnoreCase(titulo))
                                                                    .findFirst()
                                                                    .orElse(null);
        if (stringLivroEntry != null)
            listaLivrosMap.remove(stringLivroEntry.getKey());
    }

    // Nesse caso pode remover mais de um livro, porque vai buscar somente pelo titulo,
    // pode haver mais de um site com o mesmo nome de livro e vai deletar todos,
    // com break vai deletar somente o primeiro
    public void removerLivro(String titulo){
        for (Map.Entry<String, Livro> entry : listaLivrosMap.entrySet()){
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                listaLivrosMap.remove(entry.getKey());
                break;
            }
        }
    }

    //copiado para estudar
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco_Lambda(){
        return listaLivrosMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Livro::getPreco)))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (p1, p2) -> p1,
            LinkedHashMap::new
        ));
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdernarPorPreco = new ArrayList<>(listaLivrosMap.entrySet());

        Collections.sort(livrosParaOrdernarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdernarPorPreco){
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor_Lambda(){
        return listaLivrosMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparing(Livro::getAutor)))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (l1, l2) -> l1,
            LinkedHashMap::new
        ));
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor(){
        List<Map.Entry<String, Livro>> livrosParaExibirPorAutor = new ArrayList<>(listaLivrosMap.entrySet());

        Collections.sort(livrosParaExibirPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdernadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaExibirPorAutor){
            livrosOrdernadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdernadosPorAutor;
    }

    //Apesar de não ter equals and Hashcode na class Livro, preferir usar List por que se mudar essa regra pode ser comparado por autor, assim garante que não irá ter erro
    public List<Livro> pesquisarLivrosPorAutor_Lambda(String autor){
        return listaLivrosMap.values().stream()
            .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
            .collect(Collectors.toList());
    }

    public Livro obterLivroMaisCaro_Lambda(){
        return listaLivrosMap.values().stream()
                                        .max(Comparator.comparingDouble(Livro::getPreco))
                                        .orElse(null);
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;
        double maisCaro = Double.MIN_VALUE;
        if (!listaLivrosMap.values().isEmpty()){
            for (Livro livro : listaLivrosMap.values()){
                if (livro.getPreco() > maisCaro){
                    maisCaro = livro.getPreco();
                    livroMaisCaro = livro;
                }
            }
        }
        return livroMaisCaro;
    }

    public Livro exibirLivroMaisBarato_Lambda(){
        return listaLivrosMap.values().stream()
                                        .min(Comparator.comparingDouble(Livro::getPreco))
                                        .orElse(null);
    }

    public Livro exibirLivroMaisBarato(){
        Livro livroMaisBarato = null;
        double maisBarato = Double.MAX_VALUE;
        if (!listaLivrosMap.values().isEmpty()){
            for (Livro livro : listaLivrosMap.values()){
                if (livro.getPreco() < maisBarato){
                    maisBarato = livro.getPreco();
                    livroMaisBarato = livro;
                }
            }
        }
        return livroMaisBarato;
    }

    public Map<String, Livro> exibirTodosLivros(){
        return listaLivrosMap;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("ww.3.com", "Code 1", "Autor 1", 120.3);
        livrariaOnline.adicionarLivro("ww.3.com", "Codez 10", "Autora 1", 123.3);
        livrariaOnline.adicionarLivro("ww.32.com", "Code 2", "Autor 2", 15.0);
        livrariaOnline.adicionarLivro("ww.22.com", "Code 22", "Autor 2", 105.0);
        livrariaOnline.adicionarLivro("ww.4.com", "Coda 4", "Autor 3", 25.0);
        livrariaOnline.adicionarLivro("ww.5.com", "Code 5", "Autor 1", 18.0);

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco_Lambda());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

//        livrariaOnline.removerLivro("Code 5");
//        livrariaOnline.removerLivro_Lambda("Code 2");

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco_Lambda());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println();

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorAutor_Lambda());
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorAutor());

//        System.out.println(livrariaOnline.exibirTodosLivros());

        System.out.println(livrariaOnline.pesquisarLivrosPorAutor_Lambda("Autor 2"));

        System.out.println(livrariaOnline.obterLivroMaisCaro_Lambda());
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.exibirLivroMaisBarato_Lambda());
        System.out.println(livrariaOnline.exibirLivroMaisBarato());
    }
}
