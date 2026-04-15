package Atividade_11_ClasseAbstrataPolimorfismo;

public class Papagaio extends Animal{
    private int comprimentoAsas;

    public Papagaio(String nome,int comprimentoAsas) {
        super(nome);
        this.comprimentoAsas = comprimentoAsas;
    }

    public void setComprimentoAsas(int comprimentoAsas){
        this.comprimentoAsas = comprimentoAsas;
    }
    public int setComprimentoAsas(){
        return comprimentoAsas;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está cantarolando.");
    }
    @Override
    public void mover() {
        System.out.println(nome + " está voandor pelos céus.");
    }

}
