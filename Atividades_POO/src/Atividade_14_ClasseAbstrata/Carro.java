package Atividade_14_ClasseAbstrata;

public class Carro extends Veiculo{
    public Carro(String modelo){
        super(modelo);
    }
    @Override
    public void mover(){
        System.out.println("O carro, do modelo: " + modelo + ", está se movendo com o motor.");

    }
}
