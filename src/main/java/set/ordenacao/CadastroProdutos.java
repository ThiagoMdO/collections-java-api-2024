package main.java.set.ordenacao;

import java.util.*;
import java.util.stream.Collectors;

public class CadastroProdutos {

    private Set<Produto> produtoSet = new HashSet<>();

    public void adicionarProduto(Long cod, String nome, Double preco, Integer quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome_Lambda(){
        return produtoSet.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtoSetPorNome = new TreeSet<>(produtoSet);
        return produtoSetPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco_Lambda(){
        return produtoSet.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Produto> exibirProdutosPorPreco(){
        //Não seram exibidos os produtos que tiverem os mesmos preços, menos interessante usar um compator para ordenar informações que podem repetir
        Set<Produto> produtoSetPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtoSetPorPreco.addAll(produtoSet);
        return produtoSetPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(12L, "Carregador", 133.77, 12);
        cadastroProdutos.adicionarProduto(13L, "Batedeira", 373.42, 123);
        cadastroProdutos.adicionarProduto(13L, "Mouse", 33.42, 42);
        cadastroProdutos.adicionarProduto(14L, "Ventilador", 100.00, 122);
        cadastroProdutos.adicionarProduto(15L, "Abaju", 100.00, 122);

//        System.out.println(cadastroProdutos.exibirProdutosPorNome_Lambda());
//        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco_Lambda());
//        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
