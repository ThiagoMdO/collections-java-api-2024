package main.java.map.ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> listEventos;

    public AgendaEventos(){
        listEventos = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        listEventos.put(data, new Evento(nome, atracao ));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(listEventos);

        for (Map.Entry<LocalDate, Evento> entry : eventoTreeMap.entrySet()){
            System.out.println("Data: " + entry.getKey() + ", Evento: " + entry.getValue().getNome() + ", Atração : " + entry.getValue().getAtracao());
        }
    }

    public void exibirAgenda_Lambda(){
        new TreeMap<>(listEventos).entrySet().stream()
        .forEach(entry ->System.out.println("Data: " + entry.getKey() + ", Evento: " + entry.getValue().getNome() + ", Atração : " + entry.getValue().getAtracao()));
    }

    public void obterProximoEvento(){
        Map<LocalDate, Evento> eventoMap = new TreeMap<>(listEventos);
        for (Map.Entry<LocalDate, Evento> entry : eventoMap.entrySet()){
            if (entry.getKey().equals(LocalDate.now()) || entry.getKey().isAfter(LocalDate.now())){
                System.out.println("Proximo evento é em " + entry.getKey() + ", Nome: " + entry.getValue().getNome() + ", atração é: " + entry.getValue().getAtracao());
                break;
            }
        }
    }

    public void obterProximoEvento_Lambda(){
        new TreeMap<>(listEventos).entrySet().stream()
        .filter(entry -> !entry.getKey().isBefore(LocalDate.now()))
        .findFirst()
        .ifPresent(entry -> System.out.println("Proximo evento é em " + entry.getKey() + ", Nome: " + entry.getValue().getNome() + ", atração é: " + entry.getValue().getAtracao()));
    }

    public static void main(String[] args) {

        AgendaEventos agendaEventos = new AgendaEventos();
//        agendaEventos.adicionarEvento(LocalDate.now(), "Festival Cultural", "Toque 1");
        agendaEventos.adicionarEvento(LocalDate.parse("2025-10-03"), "Festival Cultural", "Toque 2");
        agendaEventos.adicionarEvento(LocalDate.parse("2022-10-03"), "Festival Cultural", "Toque 2");
        agendaEventos.adicionarEvento(LocalDate.parse("2024-12-31"), "Festival Fim de Ano", "Toque 1");
        agendaEventos.adicionarEvento(LocalDate.parse("2024-12-25"), "Festival Natal", "Toque 16");

        agendaEventos.exibirAgenda();
        System.out.println();
        agendaEventos.exibirAgenda_Lambda();
        agendaEventos.obterProximoEvento();
        agendaEventos.obterProximoEvento_Lambda();
    }
}
