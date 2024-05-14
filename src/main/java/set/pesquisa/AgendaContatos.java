package main.java.set.pesquisa;

import java.util.*;

public class AgendaContatos {

    private Set<Contato> contatosSet;

    public AgendaContatos() {
        contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatosSet.add(new Contato(nome, numero));
    }

    public Set<Contato> exibirContatos() {
        return contatosSet;
    }

    public Contato pesquisarPorNome_Lambda(String nome) {
        Optional<Contato> contato = contatosSet.stream().filter(contato1 -> contato1.getNome().equalsIgnoreCase(nome)).findFirst();
        return contato.orElse(null);
    }

    public Contato pesquisarPorNome_For(String nome) {
        Contato contato = null;
        for (Contato c : contatosSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contato = c;
            }
        }
        return contato;
    }

    public void atualizarNumeroContato_Lambda(String nome, Integer novoNumero){
        contatosSet.stream().filter(contato -> contato.getNome().equals(nome)).forEach(contato -> contato.setNumeroTelefone(novoNumero));
    }

    public Contato atualizarNumeroContato_For(String nome, Integer novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatosSet){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumeroTelefone(novoNumero);
               contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("Ana", 1234);
        agendaContatos.adicionarContato("Beatriz", 1234);
        agendaContatos.adicionarContato("Beatriz", 1);
        agendaContatos.adicionarContato("Mario", 12343);

        System.out.println(agendaContatos.exibirContatos());
        System.out.println(agendaContatos.pesquisarPorNome_Lambda("Mario"));
        System.out.println(agendaContatos.pesquisarPorNome_For("Mario"));
        System.out.println();

        agendaContatos.atualizarNumeroContato_Lambda("Ana", 23);
        System.out.println(agendaContatos.exibirContatos());
        agendaContatos.atualizarNumeroContato_For("Ana", 88);
        System.out.println(agendaContatos.exibirContatos());
    }
}
