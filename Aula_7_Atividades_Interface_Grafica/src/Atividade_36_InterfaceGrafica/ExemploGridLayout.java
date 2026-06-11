package Atividade_36_InterfaceGrafica;

import javax.swing.*;
import java.awt.*;

public class ExemploGridLayout extends JFrame {
    public ExemploGridLayout(){
        super("Exemplo GridLayout (linhas x colunas)");
        this.setLayout(new GridLayout(2, 3));
        this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
