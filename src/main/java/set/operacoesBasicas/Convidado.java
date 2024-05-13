package main.java.set.operacoesBasicas;

import java.util.Objects;

public class Convidado {

    private String nome;

    private Integer codigoConvite;

    public Convidado(String nome, Integer codigoConvite){
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    }

    public String getNome(){
        return nome;
    }

    public Integer getCodigoConvite(){
        return codigoConvite;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nome + ", ");
        sb.append("Codigo Convite: " + codigoConvite + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convidado convidado = (Convidado) o;
        return Objects.equals(codigoConvite, convidado.codigoConvite);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoConvite);
    }
}
