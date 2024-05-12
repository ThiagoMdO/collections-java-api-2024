package main.java.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> tarefaList;

    public ListaTarefa(){
        tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefaPorDescricao_Lambda(String descricao){
        tarefaList.removeIf(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao));
    }

    public void removerListaDeTarefasPorDescricao_For(String descricao){
        List<Tarefa> listaParaRemover = new ArrayList<>();
        for (Tarefa tarefa : tarefaList){
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                listaParaRemover.add(tarefa);
            }
        }
        tarefaList.removeAll(listaParaRemover);
    }

    public Integer obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
//        for (Tarefa tarefa : tarefaList){
//            System.out.println(tarefa.getDescricao());
//        }
        tarefaList.forEach(System.out::println);
    }


    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Descricao 1");
        listaTarefa.adicionarTarefa("Descricao 1");
        listaTarefa.adicionarTarefa("Descricao 2");
        listaTarefa.adicionarTarefa("Descricao 2");
        listaTarefa.adicionarTarefa("Descricao 3");

//        listaTarefa.removerTarefaPorDescricao_Lambda("Descricao 1");

        listaTarefa.removerListaDeTarefasPorDescricao_For("Descricao 1");
        System.out.println(listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.obterDescricoesTarefas();
    }
}
