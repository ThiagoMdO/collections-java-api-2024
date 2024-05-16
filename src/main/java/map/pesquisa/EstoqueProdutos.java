package main.java.map.pesquisa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> longProdutoMap = new HashMap<>();

    public void adicionarProduto(Long cod, String nome, Integer quantidade, Double preco){
        longProdutoMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public Map<Long, Produto> exibirProdutos(){
        return longProdutoMap;
    }

    public Double calcularValorTotalEstoque_Lambda(){
        return longProdutoMap.values().stream()
                                        .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                                        .sum();
    }

    public Double calcularValorTotalEstoque(){
        Double sum = 0.0;
        if (!longProdutoMap.isEmpty()){
            for (Produto p : longProdutoMap.values()){
                sum += p.getPreco() * p.getQuantidade();
            }
        }
        return sum;
    }

    public Produto obterProdutoMaisCaro_Lambda(){
        return longProdutoMap.values().stream()
                                    .max(Comparator.comparing(Produto::getPreco))
                                    .orElse(null);
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!longProdutoMap.isEmpty()){
            for (Produto p : longProdutoMap.values()){
                if (p.getPreco() > maiorPreco){
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato_Lambda(){
        return longProdutoMap.values().stream()
                                        .min(Comparator.comparing(Produto::getPreco))
                                        .orElse(null);
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!longProdutoMap.isEmpty()){
            for (Produto p : longProdutoMap.values()){
                if (p.getPreco() < menorPreco){
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque_Lambda(){
        return longProdutoMap.values().stream()
                                        .max(Comparator.comparingDouble(produto -> produto.getPreco() * produto.getQuantidade()))
                                        .orElse(null);
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoEstoqueMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!longProdutoMap.isEmpty()){
            for (Produto p : longProdutoMap.values()){
                if (p.getPreco() * p.getQuantidade() > maiorPreco){
                    maiorPreco = p.getPreco() * p.getQuantidade();
                    produtoEstoqueMaisCaro = p;
                }
            }
        }
        return produtoEstoqueMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Bateria", 37, 55.90);
        estoqueProdutos.adicionarProduto(1L, "Prato", 34, 54.90);
        estoqueProdutos.adicionarProduto(3L, "Violão", 1, 102.0);
        estoqueProdutos.adicionarProduto(2L, "Pandeiro", 3, 12.90);
        estoqueProdutos.adicionarProduto(4L, "carregador", 1, 10.0);

        System.out.println(estoqueProdutos.exibirProdutos());

        System.out.println("calcularValorTotalEstoque");
        System.out.println(estoqueProdutos.calcularValorTotalEstoque());
        System.out.println(estoqueProdutos.calcularValorTotalEstoque_Lambda());

        System.out.println();
        System.out.println("obterProdutoMaisCaro");
        System.out.println(estoqueProdutos.obterProdutoMaisCaro());
        System.out.println(estoqueProdutos.obterProdutoMaisCaro_Lambda());

        System.out.println();
        System.out.println("obterProdutoMaisBarato");
        System.out.println(estoqueProdutos.obterProdutoMaisBarato());
        System.out.println(estoqueProdutos.obterProdutoMaisBarato_Lambda());

        System.out.println();
        System.out.println("obterProdutoMaiorQuantidadeValorTotalNoEstoque");
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque_Lambda());
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
