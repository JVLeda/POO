package Atv_01.app.view;

import Atv_01.app.controller.PessoaController;
import Atv_01.app.model.Pessoa;

import javax.swing.*;

public class JanelaCadastrarPessoa extends JFrame {
    private PessoaController controller = new PessoaController();

    // Componentes antigos e novos
    private JLabel labelId;
    private JTextField textoId;
    private JLabel labelNome;
    private JTextField textoNome;

    private JButton botaoCadastrar;
    private JButton botaoConsultar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    private JTextArea textoResultado;

    public JanelaCadastrarPessoa(){
        initComponents();
    }

    private void initComponents(){
        labelId = new JLabel();
        textoId = new JTextField();
        labelNome = new JLabel();
        textoNome = new JTextField();

        botaoCadastrar = new JButton();
        botaoConsultar = new JButton();
        botaoAtualizar = new JButton();
        botaoExcluir = new JButton();

        textoResultado = new JTextArea();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pessoa");
        setLayout(null);

        // Campo ID (Adicionado para a Atividade 2)
        labelId.setText("ID:");
        labelId.setBounds(50, 20, 40, 25);
        add(labelId);

        textoId.setColumns(10);
        textoId.setBounds(90, 20, 180, 25);
        add(textoId);

        // Campo Nome
        labelNome.setText("Nome:");
        labelNome.setBounds(50, 60, 40, 25);
        add(labelNome);

        textoNome.setColumns(20);
        textoNome.setBounds(90, 60, 180, 25);
        add(textoNome);

        // Botão Cadastrar
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(evt -> {
            String nome = textoNome.getText();
            controller.cadastrarPessoa(nome);
            JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
            textoResultado.setText("Pessoa cadastrada com sucesso!");
        });
        botaoCadastrar.setBounds(30, 110, 110, 30);
        add(botaoCadastrar);

        // Botão Consultar
        botaoConsultar.setText("Consultar");
        botaoConsultar.addActionListener(evt -> {
            String nome = textoNome.getText();
            Pessoa pessoa = controller.consultarPessoa(nome);
            if (pessoa != null) {
                textoResultado.setText(
                        "id: " + pessoa.getId() +
                                "\nnome: " + pessoa.getNome()
                );
            } else {
                textoResultado.setText("Pessoa não encontrada.");
            }
        });
        botaoConsultar.setBounds(160, 110, 110, 30);
        add(botaoConsultar);

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(evt -> {
            try {
                int id = Integer.parseInt(textoId.getText());
                String novoNome = textoNome.getText();
                controller.atualizarPessoa(id, novoNome);
                JOptionPane.showMessageDialog(this, "Pessoa atualizada com sucesso!");
                textoResultado.setText("Pessoa atualizada com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido para atualizar.");
            }
        });
        botaoAtualizar.setBounds(30, 150, 110, 30);
        add(botaoAtualizar);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(evt -> {
            try {
                int id = Integer.parseInt(textoId.getText());
                controller.excluirPessoa(id);
                JOptionPane.showMessageDialog(this, "Pessoa removida com sucesso!");
                textoResultado.setText("Pessoa removida com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido para excluir.");
            }
        });
        botaoExcluir.setBounds(160, 150, 110, 30);
        add(botaoExcluir);

        textoResultado.setColumns(20);
        textoResultado.setRows(5);
        textoResultado.setEditable(false);
        textoResultado.setBounds(30, 200, 240, 90);
        add(textoResultado);

        setSize(320, 360);
        setLocationRelativeTo(null);
    }
}