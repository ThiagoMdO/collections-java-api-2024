package main.java.list.pesquisa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livroList;

    public CatalogoLivros(){
        livroList = new ArrayList<>();
    }

    public void verificarSeHaLivros(){
        if (livroList.isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
    }


    public void adicionarLivro(String titulo, String autor, Integer anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void pesquisarPorAutor_Lambda(String autor){
        verificarSeHaLivros();
        livroList.stream()
                    .filter(livro -> livro.getAutor()
                    .equalsIgnoreCase(autor))
                    .sorted(Comparator.comparing(livro -> livro.getAnoPublicacao()))
                    .forEach(System.out::println);
    }

    public void pesquisarPorAutor_For(String autor){
        verificarSeHaLivros();
        for (Livro livro : livroList){
            if (livro.getAutor().equalsIgnoreCase(autor)){
                System.out.println(livro);
            }
        }
    }

    public void pesquisarPorIntervaloAnos_Lambda(Integer anoInicial, Integer anoFinal){
        verificarSeHaLivros();
        livroList.stream()
                    .filter(livro -> livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                    .sorted(Comparator.comparingInt(Livro::getAnoPublicacao))
                    .forEach(System.out::println);
    }

    public void pesquisarPorIntervaloAnos_For(Integer anoInicial, Integer anoFinal){
        verificarSeHaLivros();
        for (Livro livro : livroList){
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                System.out.println(livro);
            }
        }
    }

    public void pesquisarPorTitulo_Lambda(String titulo){
        verificarSeHaLivros();
        livroList.stream()
                    .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                    .findFirst()
                    .ifPresentOrElse(
                        livroEncontrado -> System.out.println(livroEncontrado),
                        () -> System.out.println("Livro não encontrado")
                    );
    }

    public void pesquisaPorTitulo_For(String titulo){
        verificarSeHaLivros();
        for (Livro livro : livroList){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println(livro);
                break;
            }
        }
    }

    public static void main(String[] args) {
        try{
            CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("As aventuras 1", "Gustavo", 2001);
        catalogoLivros.adicionarLivro("As aventuras 1", "Gustavo", 2001);
        catalogoLivros.adicionarLivro("As aventuras 3", "Gustavo", 2005);
        catalogoLivros.adicionarLivro("As aventuras 2", "Gustavo", 2004);

        catalogoLivros.adicionarLivro("A historia", "Fabricio", 2001);
        catalogoLivros.adicionarLivro("A Historia 2", "Fabricio", 2009);
        catalogoLivros.adicionarLivro("As Historia 3", "Fabricio", 2006);

            catalogoLivros.pesquisaPorTitulo_For("As aventuras 1");
            System.out.println();

            catalogoLivros.pesquisarPorAutor_For("Fabricio");
            System.out.println();

            catalogoLivros.pesquisarPorIntervaloAnos_For(2001, 2005);
            System.out.println();
            System.out.println();
            System.out.println("Com funções Lambda");

            catalogoLivros.pesquisarPorTitulo_Lambda("As aventuras 2");
            System.out.println();

            catalogoLivros.pesquisarPorAutor_Lambda("Gustavo");
            System.out.println();

            catalogoLivros.pesquisarPorIntervaloAnos_Lambda(2003, 2006);
        }catch (RuntimeException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
