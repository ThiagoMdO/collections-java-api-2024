package main.java.set.pesquisa.desafio;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaTarefas {

    private Set<Tarefa> tarefaSet;

    public ListaTarefas(){
        tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa_Lambda(String descricao){
        tarefaSet.removeIf(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for (Tarefa tf : tarefaSet){
            if (tf.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaRemover = tf;
                break;
            }
        }
        tarefaSet.remove(tarefaParaRemover);
    }

    public Set<Tarefa> exibirTarefas(){
        return tarefaSet;
    }

    public Integer contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas_Lambda(){
        return tarefaSet.stream().filter(tarefa -> tarefa.getStatusTarefa().equals(true)).collect(Collectors.toSet());
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> setTarefasConcluidas = new HashSet<>();
        for (Tarefa tf : tarefaSet){
            if (tf.getStatusTarefa().equals(true)){
                setTarefasConcluidas.add(tf);
            }
        }
        return setTarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> setTarefasPendentes = new HashSet<>();
        for (Tarefa tf : tarefaSet){
            if (tf.getStatusTarefa().equals(false)){
                setTarefasPendentes.add(tf);
            }
        }
        return setTarefasPendentes;
    }

    public void marcarTarefaConcluida_Lambda(String descricao){
        tarefaSet.stream()
                    .filter(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao))
                    .forEach(tarefa -> tarefa.setStatusTarefa(true));
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa tf : tarefaSet){
            if (tf.getDescricao().equalsIgnoreCase(descricao)){
                tf.setStatusTarefa(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente_Lambda(String descricao){
        tarefaSet.stream()
                    .filter(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao))
                    .forEach(tarefa -> tarefa.setStatusTarefa(false));
    }

    public void marcarTarefaPendente(String descricao){
        for (Tarefa tf : tarefaSet){
            if (tf.getDescricao().equalsIgnoreCase(descricao)){
                tf.setStatusTarefa(false);
                break;
            }
        }
    }

    public void limparListaTarefas(){
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Descrição 1");
        listaTarefas.adicionarTarefa("Descrição 2");
        listaTarefas.adicionarTarefa("Descrição 3");
        listaTarefas.adicionarTarefa("Descrição 33");
        listaTarefas.adicionarTarefa("Descrição 37");
        listaTarefas.adicionarTarefa("Descrição 11");

        System.out.println(listaTarefas.exibirTarefas());
        System.out.println();

        listaTarefas.removerTarefa("Descrição 3");
        System.out.println(listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("Descrição 1");
        listaTarefas.marcarTarefaConcluida_Lambda("Descrição 33");
        System.out.println(listaTarefas.exibirTarefas());

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaPendente("Descrição 1");
        listaTarefas.marcarTarefaPendente_Lambda("Descrição 33");

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

        System.out.println();
        listaTarefas.limparListaTarefas();
        System.out.println(listaTarefas.exibirTarefas());

    }
}
