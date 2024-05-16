package main.java.map.pesquisa;

public class Produto {

    private String nome;

    private Integer quantidade;

    private Double preco;

    public Produto(String nome, Integer quantidade, Double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
        "nome='" + nome + '\'' +
        ", quantidade=" + quantidade +
        ", preco=" + preco +
        '}' + "\n";
    }

}
