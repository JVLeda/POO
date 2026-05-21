package Atividade_11_ClasseAbstrataPolimorfismo;

public abstract class Animal {
    protected String nome;

    public Animal(String nome){
        this.nome = nome;
    }

    public abstract void emitirSom();
    public abstract void mover();

}
