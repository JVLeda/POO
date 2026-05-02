package Atividade_17_Interface;

public class Sms implements Notificacao {
    private String numeroRemetente;


    @Override
    public void enviarMensagem(){
        System.out.println("Mensagem enviada por SMS");
    }
}
