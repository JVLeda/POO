package Atividade_14_ClasseAbstrata;

public class Bicicleta extends Veiculo{
    public Bicicleta(String modelo){
        super(modelo);
    }
    @Override
    public void mover(){
        System.out.println("A bicicleta, do modelo: " + modelo + ", está se movendo com os pedais.");

    }
}
