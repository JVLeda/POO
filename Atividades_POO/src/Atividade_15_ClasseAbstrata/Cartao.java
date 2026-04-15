package Atividade_15_ClasseAbstrata;

public class Cartao extends Pagamento{
    public Cartao(double valor){
        super(valor);
    }
    @Override
    public void processarPagamento(){
        System.out.println("Pagamento de R$ " + valor + " com cartão.");
    }
}
