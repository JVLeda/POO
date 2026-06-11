package Atividade_34_InterfaceGrafica;

import javax.swing.*;
import java.awt.*;

public class ExemploBorderLayout extends JFrame {
    public ExemploBorderLayout(){
        super("ExemploBorderLayout");

        this.setLayout(new BorderLayout());


        JButton norte = new JButton("NORTH");
        JButton sul = new JButton("SOUTH");
        JButton oeste = new JButton("EAST");
        JButton leste = new JButton("WEST");
        JButton center = new JButton("CENTER");

        this.add(norte,BorderLayout.NORTH);
        this.add(sul,BorderLayout.SOUTH);
        this.add(oeste,BorderLayout.EAST);
        this.add(leste,BorderLayout.WEST);
        this.add(center,BorderLayout.CENTER);

        this.setSize(400,300);
        this.setVisible(true);
    }
}
