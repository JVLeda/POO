package Atividade_30_Interface;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        Conta c1 = new Conta(300,1500);
        try {
            c1.deposita(-1);
        }catch(IllegalArgumentException e){
            System.out.println("Erro " + e);
        }

        Conta c2 = new Conta(300,1500);
        try {
            c2.deposita(0);
        }catch(IllegalArgumentException e){
            System.out.println("Erro " + e);
        }

        Conta c3 = new Conta(300,1500);
        try {
            c1.deposita(500);
        }catch(IllegalArgumentException e){
            System.out.println("Erro "+ e);
        }
    }
}
