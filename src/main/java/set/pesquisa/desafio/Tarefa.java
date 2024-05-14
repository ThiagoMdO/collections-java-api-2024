package main.java.set.pesquisa.desafio;

import java.util.Objects;

public class Tarefa {
    private String descricao;

    private Boolean statusTarefa;

    public Tarefa(String descricao){
        this.descricao = descricao;
        this.statusTarefa = false;
    }

    public Tarefa(String descricao, Boolean statusTarefa){
        this.descricao = descricao;
        this.statusTarefa = statusTarefa;
    }

    public Boolean getStatusTarefa() {
        return statusTarefa;
    }
    public void setStatusTarefa(Boolean statusTarefa){
        this.statusTarefa = statusTarefa;
    }

    public String getDescricao() {
        return descricao;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String situacao;
        sb.append("Descrição: " + descricao + ", ");
        if (statusTarefa.equals(true))
            situacao = " Concluida";
        else
            situacao = " Pendente";
        sb.append("Está " + situacao + "\n");
        return sb.toString();
    }
}
