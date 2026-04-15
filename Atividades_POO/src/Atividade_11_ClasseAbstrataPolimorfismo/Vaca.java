package Atividade_11_ClasseAbstrataPolimorfismo;

public class Vaca extends Animal{
    private boolean ferrada;

    public Vaca(String nome,boolean ferrada) {
        super(nome);
        this.ferrada = ferrada;
    }

    public void setferrada(boolean ferrada){
        this.ferrada = ferrada;
    }
    public boolean setSapeca(){
        return ferrada;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está mujindo.");
    }
    @Override
    public void mover() {
        System.out.println(nome + " está andando.");
    }

}
