package Atividade_20_Collections;

public class Main {
    public static void main (String[] args){
        ListaCompras lista = new ListaCompras();

        Item item1 = new Item("Batata");
        Item item2 = new Item("Batata palha");
        Item item3 = new Item("Batata frita");

        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        lista.removerItem(item2);
        lista.mostrarLista();
    }
}
