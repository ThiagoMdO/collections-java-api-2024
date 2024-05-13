package main.java.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPessoas {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas(){
        pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, Integer idade, Double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoas = new ArrayList<>(pessoaList);
        Collections.sort(pessoas);
        return pessoas;
    }

    public List<Pessoa> ordenarPorIdade_Lambda(){
        return pessoaList.stream().sorted().collect(Collectors.toList());
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoas = new ArrayList<>(pessoaList);
        Collections.sort(pessoas, new ComparatorPorAltura());
        return pessoas;
    }

    public List<Pessoa> ordenarPorAltura_Lambda(){
        List<Pessoa> pessoas = new ArrayList<>(pessoaList);
        pessoas.sort(Comparator.comparingDouble(Pessoa::getAltura));
        return pessoas;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas pessoas = new OrdenacaoPessoas();

        pessoas.adicionarPessoa("nome 1", 12, 1.32);
        pessoas.adicionarPessoa("nome 2", 16, 1.55);
        pessoas.adicionarPessoa("nome 3", 13, 1.36);
        pessoas.adicionarPessoa("nome 4", 15, 1.86);

        System.out.println("por idade");
        System.out.println(pessoas.ordenarPorIdade());
        System.out.println(pessoas.ordenarPorIdade_Lambda());

        System.out.println();
        System.out.println("por altura");
        System.out.println(pessoas.ordenarPorAltura());
        System.out.println(pessoas.ordenarPorAltura_Lambda());
    }
}


