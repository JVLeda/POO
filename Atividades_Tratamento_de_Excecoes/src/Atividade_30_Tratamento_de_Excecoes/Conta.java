package Atividade_30_Tratamento_de_Excecoes;

public class Conta {
    public double saldo;
    public double limite;

    public Conta(double saldo, double limite){
        this.saldo = saldo;
        this.limite = limite;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setlimite(double limite){
        this.limite = limite;
    }
    public double getlimite(){
        return limite;
    }

    public void deposita (double valor){
        if(valor>0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
            System.out.println("Saldo atual: R$" + valor);
            return;
        }
        throw new IllegalArgumentException("Valor de depósito inválido: "+ valor +" O valor deve ser positivo");
    }
}
