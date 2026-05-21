package Atividade_18_Interface;

public class PortaLaboratorio implements PortaAutomatica{

    @Override
    public void abrirPorta(){
        System.out.println("Porta do laboratório aberta.");
    }

}