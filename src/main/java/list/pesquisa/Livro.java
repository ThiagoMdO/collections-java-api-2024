package main.java.list.pesquisa;

import java.util.Objects;

public class Livro {
    private String titulo;

    private String autor;

    private Integer anoPublicacao;

    public Livro(String titulo, String autor, Integer anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ".concat(getTitulo()).concat(", "));
        sb.append("Autor: ".concat(getAutor()).concat(", "));
        sb.append("Ano Fabricação: ".concat(getAnoPublicacao().toString()));
        return sb.toString();
    }

}
