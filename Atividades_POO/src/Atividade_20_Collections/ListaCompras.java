package Atividade_20_Collections;

import java.util.ArrayList;

public class ListaCompras {
    ArrayList<Item> lista;

    public ListaCompras(){
        lista = new ArrayList<Item>();

    }

    public void adicionarItem(Item item) {
        lista.add(item);
        System.out.println("Item adicionado: "+ item.getNome());
    }

    public void removerItem(Item item){
        lista.remove(item);
        System.out.println("Item removido: "+ item.getNome());
    }

    public void mostrarLista(){
        System.out.println("Lista de compras:");
        for(Item i : lista) {
            System.out.println("- " + i.getNome());

        }
    }
}
