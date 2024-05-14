package main.java.set.pesquisa;

import java.util.Objects;

public class Contato {
    private String nome;

    private Integer numeroTelefone;

    public Contato(String nome, Integer numeroTelefone){
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(Integer numeroTelefone){
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nome + ", ");
        sb.append("Numero telefone: " + numeroTelefone + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getNumeroTelefone(), contato.getNumeroTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumeroTelefone());
    }

}
