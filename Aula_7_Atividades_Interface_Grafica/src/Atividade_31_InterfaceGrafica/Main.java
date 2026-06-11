package Atividade_31_InterfaceGrafica;
import Atividade_32_InterfaceGrafica.JanelaEvento;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args){
        JanelaEvento janela = new JanelaEvento();
        janela.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }
}
