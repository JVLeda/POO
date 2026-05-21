package Atividade_34_InterfaceGrafica;

import javax.swing.*;
import java.awt.*;

public class ExemploBorderLayout extends JFrame {
    public ExemploBorderLayout(){
        super("ExemploBorderLayout");

        this.setLayout(new BorderLayout());

        JButton norte = new JButton("Norte");
        JButton sul = new JButton("Sul");
        JButton oeste = new JButton("Oeste");
        JButton leste = new JButton("leste");

        this.setSize(400,300);
        this.setVisible(true);
    }
}
