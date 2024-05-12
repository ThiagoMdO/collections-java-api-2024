package main.java.list.operacoesBasicas.desafios.carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras(){
        itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, Double preco, Integer quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem_Lambda(String nome){
        itemList.removeIf(item -> item.getNome().equals(nome));
    }

    public void removerItem_For(String nome){
        List<Item> itemListToRemove = new ArrayList<>();

        for (Item item : itemList){
            if (item.getNome().equalsIgnoreCase(nome)){
                itemListToRemove.add(item);
            }
        }

        itemList.removeAll(itemListToRemove);
    }

    public Double calcularValorTotal_Lambda(){
        return itemList.stream().mapToDouble(Item::getPreco).sum();
    }

    public Double calcularValorTotal_For(){
        Double sum = 0.0;
        for (Item item : itemList){
            sum += item.getPreco();
        }
        return sum;
    }

    public List<Item> exibirItens(){
        return itemList;
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Cereal", 12.30, 12);
        carrinhoDeCompras.adicionarItem("Cereal", 12.30, 12);
        carrinhoDeCompras.adicionarItem("Leite", 10.50, 8);
//        System.out.println(carrinhoDeCompras.calcularValorTotal_Lambda());

        System.out.println(carrinhoDeCompras.calcularValorTotal_For());
        System.out.println(carrinhoDeCompras.exibirItens());

        System.out.println();
//        carrinhoDeCompras.removerItem_Lambda("Cereal");

        carrinhoDeCompras.removerItem_For("Leite");

        System.out.println(carrinhoDeCompras.calcularValorTotal_Lambda());
        System.out.println(carrinhoDeCompras.exibirItens());


        System.out.println();
    }
}
