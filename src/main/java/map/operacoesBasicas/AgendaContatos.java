package main.java.map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatoMap = new HashMap<>();

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty())
            agendaContatoMap.remove(nome);
        else
            System.out.println("Lista vazia");
    }

    public Integer pesquisarPorNome(String nome){
        return agendaContatoMap.get(nome);
    }

    public Map<String, Integer> exibirContatos(){
        return agendaContatoMap;
    }
    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Ronald", 1244);
        agendaContatos.adicionarContato("teste", 123);
        agendaContatos.adicionarContato("Nome 3", 112);

        System.out.println(agendaContatos.exibirContatos());
        System.out.println(agendaContatos.pesquisarPorNome("Nome 3"));


        agendaContatos.removerContato("teste");
        System.out.println(agendaContatos.exibirContatos());
    }
}
