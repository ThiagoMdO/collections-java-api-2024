package main.java.list.operacoesBasicas.desafios.carrinhoCompras;

public class Item {
    private String nome;

    private Double preco;

    private Integer quantidade;

    public Item(String nome, Double preco, Integer quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("nome: ".concat(nome).concat(", "));
        sb.append("preco R$:".concat(String.format("%.2f", preco).concat(", ")));
        sb.append("quantidade: ".concat(String.valueOf(quantidade)).concat("\n"));
        return sb.toString();
    }

}
