package main.java.set.ordenacao.desafio;

import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorAlunos {
    Set<Aluno> alunoSet = new HashSet<>();

    public void adicionarAluno(String nome, Long matricula, Double nota){
        alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno_Lambda(Long matricula){
        alunoSet.removeIf(aluno -> aluno.getMatricula().equals(matricula));
    }

    public void removerAluno_Iterator(Long matricula){
        Iterator<Aluno> iterator = alunoSet.iterator();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getMatricula().equals(matricula)) {
                iterator.remove();
            }
        }
    }

    public void removerAluno(Long matricula){
        Set<Aluno> alunosParaRemover = new HashSet<>();
        for (Aluno aluno : alunoSet){
            if (aluno.getMatricula().equals(matricula)){
                alunosParaRemover.add(aluno);
            }
        }
        alunoSet.removeAll(alunosParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome_Lambda(){
        return alunoSet.stream()
                        .sorted(Comparator.comparing(Aluno::getNome))
                        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Aluno> exibirAlunosPorNome(){
        return new TreeSet<>(alunoSet);
    }

    public Set<Aluno> exibirAlunosPorNota_Lambda(){
        return alunoSet.stream()
        .sorted(Comparator.comparing(Aluno::getNota))
        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunos = new TreeSet<>(new ComparatorPorNota());
        alunos.addAll(alunoSet);
        return  alunos;
    }

    public Set<Aluno> exibirAlunos(){
        return alunoSet;
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Jorge", 12L, 5.4);
        gerenciadorAlunos.adicionarAluno("Hamilton", 12L, 8.4);
        gerenciadorAlunos.adicionarAluno("Maria", 13L, 5.4);
        gerenciadorAlunos.adicionarAluno("Gabriel", 14L, 9.4);
        gerenciadorAlunos.adicionarAluno("Analice", 15L, 7.4);

        System.out.println(gerenciadorAlunos.exibirAlunos());
        System.out.println();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome_Lambda());
        System.out.println();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota_Lambda());

        gerenciadorAlunos.removerAluno(13L);
        gerenciadorAlunos.removerAluno_Lambda(14L);
        System.out.println(gerenciadorAlunos.exibirAlunos());
    }

}
