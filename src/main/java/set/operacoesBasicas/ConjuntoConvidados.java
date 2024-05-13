package main.java.set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados(){
        convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, Integer codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite_Lambda(Integer codigoConvite){
        convidadoSet.removeIf(convidado -> convidado.getCodigoConvite().equals(codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(Integer codigoConvite){
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet){
            if (c.getCodigoConvite().equals(codigoConvite)){
                convidadoParaRemover = c;
                break; // economiza processamento
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public Integer contarConvidados(){
        return convidadoSet.size();
    }

    public Set<Convidado> exibirConvidados(){
        return convidadoSet;
    }


    public static void main(String[] args) {

        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Nome 1", 1243);
        conjuntoConvidados.adicionarConvidado("Nome 1", 12432);
        conjuntoConvidados.adicionarConvidado("Nome 2", 11);
        conjuntoConvidados.adicionarConvidado("Nome 3", 11);
        conjuntoConvidados.adicionarConvidado("Nome 2", 12);
        conjuntoConvidados.adicionarConvidado("Nome 4", 13);

        System.out.println(conjuntoConvidados.exibirConvidados());

        conjuntoConvidados.removerConvidadoPorCodigoConvite(12432);
        conjuntoConvidados.removerConvidadoPorCodigoConvite_Lambda(1243);
        System.out.println(conjuntoConvidados.exibirConvidados());

        System.out.println(conjuntoConvidados.contarConvidados());
    }
}
