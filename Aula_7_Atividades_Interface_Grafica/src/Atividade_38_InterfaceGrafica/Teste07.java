package Atividade_38_InterfaceGrafica;

import javax.swing.*;
import java.awt.*;


public class Teste07 extends JFrame{
    private JLabel label;
    private final Icon icone;

    public Teste07() {
        super("Testando JLabel");
        label = new JLabel("Teste");
        icone = new ImageIcon("C:\\Users\\JoãoVitorLêdaNogueir\\Downloads\\drive-download-20260515T113729Z-3-001\\POO_Atividades\\Aula_7_Atividades_Interface_Grafica\\src\\Atividade_38_InterfaceGrafica\\imagens\\download.jpg");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        label = new JLabel();
        label.setText("imagem aleatória");
        label.setIcon(icone);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setToolTipText("Este é o label");
        container.add(label);
        setSize(500, 300);
        setVisible(true);

    }
}
