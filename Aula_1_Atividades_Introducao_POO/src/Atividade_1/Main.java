package Atividade_1;

public class Main {
    public static void main(String[] args) {
        Gato g1 = new Gato();
        g1.nome = "Sushi";
        g1.estoqueComida = 3;
        g1.sono = false;
        g1.comer();
        g1.dormir();
        g1.coletarComida();
        Gato g2 = new Gato();
        g2.nome = "Cachaça";
        g2.estoqueComida = 1;
        g2.sono = true;
        g2.comer();
        g2.dormir();
        g2.coletarComida();
    }
}
