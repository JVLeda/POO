package Atividade_14_ClasseAbstrata;

public class Main {
    public static void main(String[] args){
        Veiculo[] veiculo = new Veiculo[2];
        veiculo[0] = new Carro("Honda Civic");
        veiculo[1] = new Bicicleta("Magrela");

        for(Veiculo v : veiculo){
            v.mover();
        }
    }
}
