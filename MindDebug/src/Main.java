import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    // Listas que funcionam como nosso "Banco de Dados" temporário
    private List<Usuario> bancoUsuarios = new ArrayList<>();
    private List<Curso> bancoCursos = new ArrayList<>();

    private CardLayout cardLayout = new CardLayout();
    private JPanel painelPrincipal = new JPanel(cardLayout);

    public Main() {
        configurarJanela();
        inicializarDadosMock();
        construirTelas();

        add(painelPrincipal);
        setVisible(true); // Agora funciona porque a classe extends JFrame
    }

    private void configurarJanela() {
        setTitle("MindDebug LMS");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarDadosMock() {
        Professor alan = new Professor("Alan Turing", "prof", "123");
        bancoUsuarios.add(alan); // Agora o .add funciona!

        Curso c = new Curso("Engenharia da Computação");
        bancoCursos.add(c);
    }

    private void construirTelas() {
        // Aqui você adiciona os métodos que criam os JPanels de cada tela
        // painelPrincipal.add(criarTelaLogin(), "LOGIN");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI janela = new UI();
            janela.setVisible(true);
        });
    }
}