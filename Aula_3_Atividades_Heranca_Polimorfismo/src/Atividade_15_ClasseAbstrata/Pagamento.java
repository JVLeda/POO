package Atividade_15_ClasseAbstrata;

public abstract class Pagamento {
    protected double valor;

    public Pagamento(double valor){
        this.valor = valor;
    }

    public abstract void processarPagamento();
}
