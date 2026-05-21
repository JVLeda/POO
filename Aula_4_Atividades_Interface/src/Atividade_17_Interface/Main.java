package Atividade_17_Interface;

public class Main {
    public static void main(String[] args){
        Email e1 = new Email();
        e1.enviarMensagem();

        Sms s1 = new Sms();
        s1.enviarMensagem();
    }
}
