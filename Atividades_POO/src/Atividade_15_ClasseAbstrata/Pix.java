package Atividade_15_ClasseAbstrata;

public class Pix extends Pagamento{
    public Pix(double valor){
        super(valor);
    }
    @Override
    public void processarPagamento(){
        System.out.println("Pagamento de R$ " + valor + " via Pix.");
    }
}
