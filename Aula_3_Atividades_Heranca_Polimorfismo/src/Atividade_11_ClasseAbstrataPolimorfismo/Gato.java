package Atividade_11_ClasseAbstrataPolimorfismo;

public class Gato extends Animal{
    private boolean sapeca;

    public Gato(String nome,boolean sapeca) {
        super(nome);
        this.sapeca = sapeca;
    }

    public void setSapeca(boolean sapeca){
        this.sapeca = sapeca;
    }
    public boolean setSapeca(){
        return sapeca;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está miando.");
    }
    @Override
    public void mover() {
        System.out.println(nome + " está andando silenciosamente.");
    }
}
