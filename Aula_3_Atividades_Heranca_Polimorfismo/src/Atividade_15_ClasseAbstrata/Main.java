package Atividade_15_ClasseAbstrata;

public class Main {
    public static void main(String[] args){
        Pagamento[] pagamento = new Pagamento[2];
        pagamento[0] = new Cartao(150);
        pagamento[1] = new Pix(250);

        for(Pagamento p : pagamento){
            p.processarPagamento();
        }
    }
}
