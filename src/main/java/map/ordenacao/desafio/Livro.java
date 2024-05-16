package main.java.map.ordenacao.desafio;

import java.util.Comparator;
import java.util.Map;

public class Livro {

    private String titulo;

    private String autor;

    private Double preco;

    public Livro(String titulo, String autor, Double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Livro{" +
        "autor='" + autor + '\'' +
        ", titulo='" + titulo + '\'' +
        ", preco=" + preco +
        '}' + "\n";
    }


}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return Double.compare(o1.getValue().getPreco(), o2.getValue().getPreco());
    }
}

class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getAutor().compareTo(o2.getValue().getAutor());
    }
}
