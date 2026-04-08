import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Renomeado para UI para coincidir com o nome do arquivo UI.java
public class UI extends JFrame {

    private List<Usuario> bancoUsuarios = new ArrayList<>();
    private List<Curso> bancoCursos = new ArrayList<>();
    private Usuario usuarioLogado;
    private Materia materiaAtiva;

    private JPanel painelPrincipal;
    private CardLayout cardLayout;

    public UI() {
        aplicarTema();
        inicializarDadosMock();
        configurarJanela();
        construirTelas();
    }

    private void aplicarTema() {
        UIManager.put("Panel.background", new Color(245, 247, 250));
        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 13));
        UIManager.put("Button.background", new Color(41, 128, 185));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("TextField.margin", new Insets(5, 5, 5, 5));
        UIManager.put("PasswordField.margin", new Insets(5, 5, 5, 5));
        UIManager.put("ComboBox.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("List.font", new Font("Segoe UI", Font.PLAIN, 14));
    }

    private void inicializarDadosMock() {
        bancoUsuarios.add(new Dev("Equipe Dev", "dev", "admin"));
        Professor prof1 = new Professor("Dr. Alan Turing", "prof", "123");
        Monitor mon1 = new Monitor("Ada Lovelace", "monitor", "123");
        bancoUsuarios.add(prof1);
        bancoUsuarios.add(mon1);

        Curso engComp = new Curso("Engenharia da Computacao");
        Periodo p1 = new Periodo("1o Periodo");
        Materia m1 = new Materia("POO Avancada", prof1);
        m1.matricularUsuario(mon1);
        m1.adicionarAula(new Aula("Heranca e Polimorfismo"));
        m1.adicionarMaterial("[Dr. Alan Turing] Arquivo: Livro_Clean_Code.pdf");
        m1.getChatGeral().adicionarMensagem(new Mensagem(prof1, "Bem-vindos a disciplina de POO!"));

        p1.adicionarMateria(m1);
        engComp.adicionarPeriodo(p1);
        bancoCursos.add(engComp);
    }

    private void configurarJanela() {
        setTitle("MindDebug LMS - Gestao Academica");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);
        add(painelPrincipal);
    }

    private void construirTelas() {
        painelPrincipal.add(criarTelaLogin(), "LOGIN");
        painelPrincipal.add(criarTelaDev(), "DEV");
        painelPrincipal.add(criarTelaNavegacaoCursos(), "NAVEGACAO");
        painelPrincipal.add(criarTelaMateriaDashboard(), "DASHBOARD_MATERIA");
    }

    private void efetuarLogout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Sair do sistema?", "Logoff", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            usuarioLogado = null;
            materiaAtiva = null;
            cardLayout.show(painelPrincipal, "LOGIN");
        }
    }

    private JPanel criarHeaderMenu() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        header.setBackground(new Color(236, 240, 241));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        String textoMateria = (materiaAtiva != null) ? " | Materia: " + materiaAtiva.getNome() : "";
        JLabel lblUser = new JLabel(String.format("Logado: %s (Nivel %d)%s  ", usuarioLogado.nome, usuarioLogado.getNivel(), textoMateria));
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnSenha = new JButton("Trocar Senha");
        btnSenha.setBackground(new Color(52, 73, 94));
        JButton btnSair = new JButton("Logoff");
        btnSair.setBackground(new Color(192, 57, 43));

        btnSenha.addActionListener(e -> {
            String nova = JOptionPane.showInputDialog(this, "Nova senha:");
            if (nova != null && !nova.trim().isEmpty()) {
                usuarioLogado.senha = nova.trim();
                JOptionPane.showMessageDialog(this, "Senha atualizada!");
            }
        });
        btnSair.addActionListener(e -> efetuarLogout());

        header.add(lblUser);
        header.add(btnSenha);

        JButton btnVoltar = new JButton(usuarioLogado.getNivel() == 4 ? "Voltar ao Painel Dev" : "Voltar aos Cursos");
        btnVoltar.setBackground(new Color(127, 140, 141));
        btnVoltar.addActionListener(e -> {
            materiaAtiva = null;
            if (usuarioLogado.getNivel() == 4) {
                atualizarTelaDev();
                cardLayout.show(painelPrincipal, "DEV");
            } else {
                atualizarTelaNavegacao();
                cardLayout.show(painelPrincipal, "NAVEGACAO");
            }
        });
        header.add(btnVoltar);

        header.add(btnSair);
        return header;
    }

    // --- SISTEMA DE CHAT REFORMULADO ---
    private JPanel criarPainelChat(Chat chat, Runnable onUpdate) {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(new EmptyBorder(10, 10, 10, 10));

        DefaultListModel<Mensagem> modelChat = new DefaultListModel<>();
        for (Mensagem m : chat.getHistorico()) modelChat.addElement(m);

        JList<Mensagem> listaChat = new JList<>(modelChat);
        listaChat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        painel.add(new JScrollPane(listaChat), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(10, 10));
        JTextField txtInput = new JTextField();

        JPanel pnlBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        JButton btnEnviar = new JButton("Enviar");

        JButton btnApagar = new JButton("Apagar Selecionada");
        btnApagar.setBackground(new Color(231, 76, 60));
        btnApagar.setEnabled(false);

        listaChat.addListSelectionListener(e -> {
            Mensagem selecionada = listaChat.getSelectedValue();
            if (selecionada != null) {
                boolean souAutor = selecionada.getAutor().login.equals(usuarioLogado.login);
                boolean souModerador = usuarioLogado.getNivel() >= 2;
                btnApagar.setEnabled(souAutor || souModerador);
            } else {
                btnApagar.setEnabled(false);
            }
        });

        btnApagar.addActionListener(e -> {
            Mensagem selecionada = listaChat.getSelectedValue();
            if (selecionada != null) {
                chat.removerMensagem(selecionada);
                modelChat.removeElement(selecionada);
            }
        });

        pnlBotoes.add(btnApagar);
        pnlBotoes.add(btnEnviar);

        Runnable enviarMensagem = () -> {
            if (!txtInput.getText().trim().isEmpty()) {
                Mensagem nova = new Mensagem(usuarioLogado, txtInput.getText().trim());
                chat.adicionarMensagem(nova);
                modelChat.addElement(nova);
                txtInput.setText("");
                int lastIndex = modelChat.getSize() - 1;
                if (lastIndex >= 0) listaChat.ensureIndexIsVisible(lastIndex);
                if (onUpdate != null) onUpdate.run();
            }
        };

        btnEnviar.addActionListener(e -> enviarMensagem.run());
        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) enviarMensagem.run();
            }
        });

        bottom.add(txtInput, BorderLayout.CENTER);
        bottom.add(pnlBotoes, BorderLayout.EAST);
        painel.add(bottom, BorderLayout.SOUTH);
        return painel;
    }

    private void adicionarLinhaGridBag(JPanel pnl, GridBagConstraints gbc, int row, String label, JComponent comp) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        if (label != null) pnl.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        if (comp != null) pnl.add(comp, gbc);
    }

    private JPanel criarTelaLogin() {
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        JPanel cardLogin = new JPanel(new GridBagLayout());
        cardLogin.setBackground(Color.WHITE);
        cardLogin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel lblTitulo = new JLabel("MindDebug Login", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(41, 128, 185));
        JTextField txtUser = new JTextField(15);
        JPasswordField txtSenha = new JPasswordField(15);
        JButton btnLogin = new JButton("Entrar");
        JButton btnCadastrar = new JButton("Sou Aluno (Cadastrar)");
        btnCadastrar.setBackground(new Color(39, 174, 96));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        cardLogin.add(lblTitulo, gbc);
        gbc.gridwidth = 1;
        adicionarLinhaGridBag(cardLogin, gbc, 1, "Login:", txtUser);
        adicionarLinhaGridBag(cardLogin, gbc, 2, "Senha:", txtSenha);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        cardLogin.add(btnLogin, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cardLogin.add(new JSeparator(), gbc);
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        cardLogin.add(btnCadastrar, gbc);

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtSenha.getPassword());

            usuarioLogado = null;
            for(Usuario u : bancoUsuarios) {
                if(u.autenticar(user, pass)) {
                    usuarioLogado = u;
                    break;
                }
            }

            if (usuarioLogado == null) {
                JOptionPane.showMessageDialog(this, "Credenciais invalidas!");
            } else if (usuarioLogado.getNivel() == 4) {
                atualizarTelaDev();
                cardLayout.show(painelPrincipal, "DEV");
            } else {
                atualizarTelaNavegacao();
                cardLayout.show(painelPrincipal, "NAVEGACAO");
            }
            txtUser.setText("");
            txtSenha.setText("");
        });

        btnCadastrar.addActionListener(e -> {
            JDialog dialog = new JDialog(this, "Cadastro de Aluno", true);
            dialog.setSize(450, 400);
            dialog.setLocationRelativeTo(this);
            JPanel pnl = new JPanel(new GridBagLayout());
            pnl.setBorder(new EmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbcForm = new GridBagConstraints();
            gbcForm.insets = new Insets(10, 10, 10, 10);

            JTextField txtNome = new JTextField(15);
            JTextField txtEmail = new JTextField(15);
            JTextField txtMat = new JTextField(15);
            JPasswordField txtSenhaCad = new JPasswordField(15);
            JComboBox<Curso> comboCurso = new JComboBox<>(bancoCursos.toArray(new Curso[0]));
            JButton btnSalvar = new JButton("Matricular");

            adicionarLinhaGridBag(pnl, gbcForm, 0, "Nome Completo:", txtNome);
            adicionarLinhaGridBag(pnl, gbcForm, 1, "Email:", txtEmail);
            adicionarLinhaGridBag(pnl, gbcForm, 2, "Login (Matricula):", txtMat);
            adicionarLinhaGridBag(pnl, gbcForm, 3, "Senha:", txtSenhaCad);
            adicionarLinhaGridBag(pnl, gbcForm, 4, "Curso:", comboCurso);
            gbcForm.gridy = 5;
            gbcForm.gridx = 1;
            gbcForm.fill = GridBagConstraints.NONE;
            gbcForm.anchor = GridBagConstraints.EAST;
            pnl.add(btnSalvar, gbcForm);

            btnSalvar.addActionListener(ev -> {
                Curso c = (Curso) comboCurso.getSelectedItem();
                if (c != null && !txtMat.getText().isEmpty()) {
                    Estudante est = new Estudante(txtNome.getText(), txtEmail.getText(), txtMat.getText(), new String(txtSenhaCad.getPassword()), c);
                    bancoUsuarios.add(est);
                    JOptionPane.showMessageDialog(dialog, "Cadastro realizado! Logue com sua Matricula.");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Preencha todos os campos.");
                }
            });
            dialog.add(pnl);
            dialog.setVisible(true);
        });
        painel.add(cardLogin);
        return painel;
    }

    private JComboBox<Curso> comboNavCurso = new JComboBox<>();
    private JComboBox<Periodo> comboNavPeriodo = new JComboBox<>();
    private DefaultListModel<Materia> listaNavMateriaModel = new DefaultListModel<>();

    private JPanel criarTelaNavegacaoCursos() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JPanel pnlFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        pnlFiltros.add(new JLabel("Curso:"));
        pnlFiltros.add(comboNavCurso);
        pnlFiltros.add(new JLabel("Periodo:"));
        pnlFiltros.add(comboNavPeriodo);

        JList<Materia> listMaterias = new JList<>(listaNavMateriaModel);
        listMaterias.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        JPanel pnlAcoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnEntrar = new JButton("Acessar Materia");
        JButton btnSair = new JButton("Sair do Sistema");
        btnSair.setBackground(new Color(192, 57, 43));

        btnSair.addActionListener(e -> efetuarLogout());
        btnEntrar.addActionListener(e -> {
            Materia m = listMaterias.getSelectedValue();
            if (m != null) {
                m.matricularUsuario(usuarioLogado);
                materiaAtiva = m;
                atualizarTelaMateriaDashboard();
                cardLayout.show(painelPrincipal, "DASHBOARD_MATERIA");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma materia.");
            }
        });

        pnlAcoes.add(btnSair);
        pnlAcoes.add(btnEntrar);
        painel.add(pnlFiltros, BorderLayout.NORTH);
        painel.add(new JScrollPane(listMaterias), BorderLayout.CENTER);
        painel.add(pnlAcoes, BorderLayout.SOUTH);

        comboNavCurso.addActionListener(e -> {
            comboNavPeriodo.removeAllItems();
            Curso c = (Curso) comboNavCurso.getSelectedItem();
            if (c != null) for (Periodo p : c.getPeriodos()) comboNavPeriodo.addItem(p);
        });
        comboNavPeriodo.addActionListener(e -> {
            listaNavMateriaModel.clear();
            Periodo p = (Periodo) comboNavPeriodo.getSelectedItem();
            if (p != null) for (Materia m : p.getMaterias()) listaNavMateriaModel.addElement(m);
        });
        return painel;
    }

    private void atualizarTelaNavegacao() {
        comboNavCurso.removeAllItems();
        if (usuarioLogado instanceof Estudante) {
            comboNavCurso.addItem(((Estudante) usuarioLogado).getCurso());
        } else {
            for (Curso c : bancoCursos) comboNavCurso.addItem(c);
        }
    }

    // --- TELA ÁREA DEV ---
    private JComboBox<Curso> cbCursosDev = new JComboBox<>();
    private JComboBox<Curso> cbCursosMatDev = new JComboBox<>();
    private JComboBox<Periodo> cbPeriodosMatDev = new JComboBox<>();
    private JComboBox<Professor> cbProfsMatDev = new JComboBox<>();
    private DefaultListModel<Materia> listDevMateriaModel = new DefaultListModel<>();
    private DefaultListModel<Professor> listProfModel = new DefaultListModel<>();

    private JPanel criarTelaDev() {
        JPanel painel = new JPanel(new BorderLayout());
        JTabbedPane abas = new JTabbedPane();

        JPanel pnlEstrutura = new JPanel(new GridLayout(2, 1, 10, 10));
        pnlEstrutura.setBorder(new EmptyBorder(20, 20, 20, 20));
        JPanel pnlCur = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlCur.setBorder(BorderFactory.createTitledBorder("Novo Curso"));
        JTextField txtNomeCur = new JTextField(20);
        JButton btnCur = new JButton("Criar Curso");
        pnlCur.add(new JLabel("Nome:"));
        pnlCur.add(txtNomeCur);
        pnlCur.add(btnCur);
        btnCur.addActionListener(e -> {
            bancoCursos.add(new Curso(txtNomeCur.getText()));
            atualizarTelaDev();
            txtNomeCur.setText("");
            JOptionPane.showMessageDialog(this, "Curso Criado!");
        });

        JPanel pnlPer = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlPer.setBorder(BorderFactory.createTitledBorder("Novo Periodo"));
        JTextField txtNomePer = new JTextField(15);
        JButton btnPer = new JButton("Adicionar ao Curso");
        pnlPer.add(new JLabel("Curso:"));
        pnlPer.add(cbCursosDev);
        pnlPer.add(new JLabel("Periodo:"));
        pnlPer.add(txtNomePer);
        pnlPer.add(btnPer);
        btnPer.addActionListener(e -> {
            Curso c = (Curso) cbCursosDev.getSelectedItem();
            if (c != null) {
                c.adicionarPeriodo(new Periodo(txtNomePer.getText()));
                txtNomePer.setText("");
                atualizarTelaDev();
                JOptionPane.showMessageDialog(this, "Periodo Adicionado!");
            }
        });
        pnlEstrutura.add(pnlCur);
        pnlEstrutura.add(pnlPer);
        abas.addTab("1. Cursos e Periodos", pnlEstrutura);

        JPanel pnlGestaoMaterias = new JPanel(new BorderLayout(10, 10));
        pnlGestaoMaterias.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel pnlFiltroMat = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlFiltroMat.add(new JLabel("Curso:"));
        pnlFiltroMat.add(cbCursosMatDev);
        pnlFiltroMat.add(new JLabel("Periodo:"));
        pnlFiltroMat.add(cbPeriodosMatDev);
        pnlGestaoMaterias.add(pnlFiltroMat, BorderLayout.NORTH);
        JList<Materia> listMateriasDev = new JList<>(listDevMateriaModel);
        pnlGestaoMaterias.add(new JScrollPane(listMateriasDev), BorderLayout.CENTER);

        JPanel pnlAcoesMat = new JPanel(new GridBagLayout());
        pnlAcoesMat.setBorder(BorderFactory.createTitledBorder("Gerenciar Materia"));
        GridBagConstraints gbcMat = new GridBagConstraints();
        gbcMat.insets = new Insets(5, 5, 5, 5);
        JTextField txtEditNomeMat = new JTextField(15);
        JButton btnAddMat = new JButton("Adicionar");
        btnAddMat.setBackground(new Color(39, 174, 96));
        JButton btnSaveMat = new JButton("Salvar");
        JButton btnDelMat = new JButton("Remover");
        btnDelMat.setBackground(new Color(192, 57, 43));

        adicionarLinhaGridBag(pnlAcoesMat, gbcMat, 0, "Nome Materia:", txtEditNomeMat);
        adicionarLinhaGridBag(pnlAcoesMat, gbcMat, 1, "Designar Prof:", cbProfsMatDev);
        JPanel pnlBotoesMat = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBotoesMat.add(btnAddMat);
        pnlBotoesMat.add(btnSaveMat);
        pnlBotoesMat.add(btnDelMat);
        gbcMat.gridy = 2;
        gbcMat.gridx = 0;
        gbcMat.gridwidth = 2;
        gbcMat.fill = GridBagConstraints.HORIZONTAL;
        pnlAcoesMat.add(pnlBotoesMat, gbcMat);
        pnlGestaoMaterias.add(pnlAcoesMat, BorderLayout.SOUTH);

        cbCursosMatDev.addActionListener(e -> {
            cbPeriodosMatDev.removeAllItems();
            Curso c = (Curso) cbCursosMatDev.getSelectedItem();
            if (c != null) for (Periodo p : c.getPeriodos()) cbPeriodosMatDev.addItem(p);
        });
        cbPeriodosMatDev.addActionListener(e -> {
            listDevMateriaModel.clear();
            Periodo p = (Periodo) cbPeriodosMatDev.getSelectedItem();
            if (p != null) for (Materia m : p.getMaterias()) listDevMateriaModel.addElement(m);
        });
        listMateriasDev.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Materia m = listMateriasDev.getSelectedValue();
                if (m != null) {
                    txtEditNomeMat.setText(m.getNome());
                    cbProfsMatDev.setSelectedItem(m.getProfessor());
                }
            }
        });

        btnAddMat.addActionListener(e -> {
            Periodo p = (Periodo) cbPeriodosMatDev.getSelectedItem();
            Professor prof = (Professor) cbProfsMatDev.getSelectedItem();
            if (p != null && prof != null && !txtEditNomeMat.getText().isEmpty()) {
                p.adicionarMateria(new Materia(txtEditNomeMat.getText(), prof));
                atualizarListagemMateriasDev();
                txtEditNomeMat.setText("");
            }
        });
        btnSaveMat.addActionListener(e -> {
            Materia m = listMateriasDev.getSelectedValue();
            Professor novoProf = (Professor) cbProfsMatDev.getSelectedItem();
            if (m != null && novoProf != null && !txtEditNomeMat.getText().isEmpty()) {
                m.setNome(txtEditNomeMat.getText());
                m.setProfessor(novoProf);
                atualizarListagemMateriasDev();
            }
        });
        btnDelMat.addActionListener(e -> {
            Periodo p = (Periodo) cbPeriodosMatDev.getSelectedItem();
            Materia m = listMateriasDev.getSelectedValue();
            if (p != null && m != null) {
                p.removerMateria(m);
                atualizarListagemMateriasDev();
                txtEditNomeMat.setText("");
            }
        });

        abas.addTab("2. Gestao Materias", pnlGestaoMaterias);

        JPanel pnlGestaoProfs = new JPanel(new BorderLayout(10, 10));
        pnlGestaoProfs.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel pnlNovoProf = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlNovoProf.setBorder(BorderFactory.createTitledBorder("Novo Professor"));
        JTextField txtNomeProf = new JTextField(12);
        JTextField txtLogProf = new JTextField(10);
        JPasswordField txtSenhaProf = new JPasswordField(10);
        JButton btnAddProf = new JButton("Cadastrar");
        pnlNovoProf.add(new JLabel("Nome:"));
        pnlNovoProf.add(txtNomeProf);
        pnlNovoProf.add(new JLabel("Login:"));
        pnlNovoProf.add(txtLogProf);
        pnlNovoProf.add(new JLabel("Senha:"));
        pnlNovoProf.add(txtSenhaProf);
        pnlNovoProf.add(btnAddProf);

        btnAddProf.addActionListener(e -> {
            bancoUsuarios.add(new Professor(txtNomeProf.getText(), txtLogProf.getText(), new String(txtSenhaProf.getPassword())));
            atualizarTelaDev();
            JOptionPane.showMessageDialog(this, "Prof Cadastrado!");
            txtNomeProf.setText("");
            txtLogProf.setText("");
            txtSenhaProf.setText("");
        });

        JList<Professor> listProfs = new JList<>(listProfModel);
        JPanel pnlAcoesProf = new JPanel(new FlowLayout());
        JButton btnRemoverProf = new JButton("Remover");
        btnRemoverProf.setBackground(new Color(192, 57, 43));
        JButton btnResetSenha = new JButton("Redefinir Senha");
        btnResetSenha.setBackground(new Color(243, 156, 18));

        btnRemoverProf.addActionListener(e -> {
            Professor p = listProfs.getSelectedValue();
            if (p != null) {
                bancoUsuarios.remove(p);
                atualizarTelaDev();
            }
        });
        btnResetSenha.addActionListener(e -> {
            Professor p = listProfs.getSelectedValue();
            if (p != null) {
                String nova = JOptionPane.showInputDialog(this, "Nova senha:");
                if (nova != null) p.senha = nova;
            }
        });

        pnlAcoesProf.add(btnResetSenha);
        pnlAcoesProf.add(btnRemoverProf);
        pnlGestaoProfs.add(pnlNovoProf, BorderLayout.NORTH);
        pnlGestaoProfs.add(new JScrollPane(listProfs), BorderLayout.CENTER);
        pnlGestaoProfs.add(pnlAcoesProf, BorderLayout.SOUTH);
        abas.addTab("3. Gestao Professores", pnlGestaoProfs);

        painel.add(abas, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        JButton btnEntrarComoDev = new JButton("Acessar Navegacao de Materias");
        btnEntrarComoDev.setBackground(new Color(46, 204, 113));
        btnEntrarComoDev.addActionListener(e -> {
            atualizarTelaNavegacao();
            cardLayout.show(painelPrincipal, "NAVEGACAO");
        });
        JButton btnSairDev = new JButton("Sair");
        btnSairDev.addActionListener(e -> efetuarLogout());

        bottom.add(btnEntrarComoDev, BorderLayout.WEST);
        bottom.add(btnSairDev, BorderLayout.EAST);
        painel.add(bottom, BorderLayout.SOUTH);

        return painel;
    }

    private void atualizarTelaDev() {
        cbCursosDev.removeAllItems();
        cbCursosMatDev.removeAllItems();
        for (Curso c : bancoCursos) {
            cbCursosDev.addItem(c);
            cbCursosMatDev.addItem(c);
        }

        cbProfsMatDev.removeAllItems();
        listProfModel.clear();
        for (Usuario u : bancoUsuarios) {
            if (u instanceof Professor) {
                listProfModel.addElement((Professor) u);
                cbProfsMatDev.addItem((Professor) u);
            }
        }
    }

    private void atualizarListagemMateriasDev() {
        listDevMateriaModel.clear();
        Periodo p = (Periodo) cbPeriodosMatDev.getSelectedItem();
        if (p != null) for (Materia m : p.getMaterias()) listDevMateriaModel.addElement(m);
    }

    private JPanel painelConteudoMateria = new JPanel(new BorderLayout());

    private JPanel criarTelaMateriaDashboard() {
        return painelConteudoMateria;
    }

    private void atualizarTelaMateriaDashboard() {
        painelConteudoMateria.removeAll();
        painelConteudoMateria.add(criarHeaderMenu(), BorderLayout.NORTH);

        JTabbedPane abas = new JTabbedPane();
        int nivel = usuarioLogado.getNivel();

        if (nivel == 1) {
            JPanel pnlFeedback = new JPanel(new GridBagLayout());
            pnlFeedback.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridBagConstraints gbcFb = new GridBagConstraints();
            gbcFb.insets = new Insets(10, 10, 10, 10);
            JLabel lblInstrucao = new JLabel("Quanto você compreendeu desta aula? (0: Nada, 10: Domínio Total)");
            JComboBox<Aula> comboAulas = new JComboBox<>(materiaAtiva.getAulas().toArray(new Aula[0]));
            JSlider slider = new JSlider(0, 10, 5); // 5 é o valor inicial médio
            slider.setMajorTickSpacing(1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            JButton btnFeed = new JButton("Registrar Compreensão");

            adicionarLinhaGridBag(pnlFeedback, gbcFb, 0, "Aula:", comboAulas);
            adicionarLinhaGridBag(pnlFeedback, gbcFb, 1, "Nível de compreensão (0=Crítico, 10=Ótimo):", slider);
            gbcFb.gridy = 2;
            gbcFb.gridx = 1;
            gbcFb.fill = GridBagConstraints.NONE;
            gbcFb.anchor = GridBagConstraints.CENTER;
            pnlFeedback.add(btnFeed, gbcFb);

            btnFeed.addActionListener(e -> {
                Aula a = (Aula) comboAulas.getSelectedItem();
                if (a != null) {
                    a.adicionarFeedback(new Feedback(slider.getValue(), (Estudante) usuarioLogado));
                    JOptionPane.showMessageDialog(this, "Nível de compreensão registrado com sucesso!");
                }
            });
            abas.addTab("Dar Feedback", pnlFeedback);
        }

        if (nivel >= 2) {
            DefaultTableModel modelGargalos = new DefaultTableModel(
                    new String[]{"Aula", "Participação", "Média Compreensão", "Status"}, 0
            ); //

            int totalInscritos = materiaAtiva.getTotalAlunosMatriculados(); //

            for (Aula a : materiaAtiva.getAulas()) {
                int responderam = a.getQuantidadeRespostas(); //
                double media = a.calcularMedia(); //
                String status;
                String participacao = responderam + " / " + totalInscritos; //

                if (responderam == 0) {
                    status = "Sem Respostas"; //
                } else if (media >= 8.0) {
                    status = "Domínio Total"; //
                } else if (media >= 5.0) {
                    status = "Regular"; //
                } else {
                    status = "ALERTA: Baixa Compreensão"; //
                }
                modelGargalos.addRow(new Object[]{
                        a.getTitulo(),
                        participacao,
                        (responderam > 0 ? String.format("%.2f", media) : "N/A"),
                        status
                }); //
            }
            JTable tabela = new JTable(modelGargalos);
            tabela.setRowHeight(30);
            tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            abas.addTab("Dashboard", new JScrollPane(tabela));

            abas.addTab("Chat Equipe", criarPainelChat(materiaAtiva.getChatEquipe(), null));
        }

        if (nivel >= 3) {
            JPanel pnlAula = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
            JTextField txtTitAula = new JTextField(25);
            JButton btnAula = new JButton("Criar Aula");
            pnlAula.add(new JLabel("Titulo Aula:"));
            pnlAula.add(txtTitAula);
            pnlAula.add(btnAula);
            btnAula.addActionListener(e -> {
                materiaAtiva.adicionarAula(new Aula(txtTitAula.getText()));
                atualizarTelaMateriaDashboard();
            });
            abas.addTab("Gestao Aulas", pnlAula);

            JPanel pnlMonitores = new JPanel(new GridLayout(1, 2, 20, 20));
            pnlMonitores.setBorder(new EmptyBorder(20, 20, 20, 20));
            JPanel pnlAddMon = new JPanel(new GridBagLayout());
            pnlAddMon.setBorder(BorderFactory.createTitledBorder("Adicionar Monitor"));
            GridBagConstraints gbcMon = new GridBagConstraints();
            gbcMon.insets = new Insets(10, 10, 10, 10);
            JTextField txtNomeMon = new JTextField(15);
            JTextField txtLogMon = new JTextField(15);
            JPasswordField txtSenhaMon = new JPasswordField(15);
            JButton btnMon = new JButton("Adicionar");

            adicionarLinhaGridBag(pnlAddMon, gbcMon, 0, "Nome:", txtNomeMon);
            adicionarLinhaGridBag(pnlAddMon, gbcMon, 1, "Login:", txtLogMon);
            adicionarLinhaGridBag(pnlAddMon, gbcMon, 2, "Senha:", txtSenhaMon);
            gbcMon.gridy = 3;
            gbcMon.gridx = 1;
            gbcMon.fill = GridBagConstraints.NONE;
            gbcMon.anchor = GridBagConstraints.EAST;
            pnlAddMon.add(btnMon, gbcMon);

            JPanel pnlRemMon = new JPanel(new BorderLayout(10, 10));
            pnlRemMon.setBorder(BorderFactory.createTitledBorder("Remover Monitor"));
            DefaultListModel<Monitor> listMonModel = new DefaultListModel<>();
            for (Monitor m : materiaAtiva.getMonitores()) listMonModel.addElement(m);
            JList<Monitor> listMon = new JList<>(listMonModel);
            JButton btnRemoverMon = new JButton("Remover Selecionado");
            btnRemoverMon.setBackground(new Color(192, 57, 43));
            pnlRemMon.add(new JScrollPane(listMon), BorderLayout.CENTER);
            pnlRemMon.add(btnRemoverMon, BorderLayout.SOUTH);

            pnlMonitores.add(pnlAddMon);
            pnlMonitores.add(pnlRemMon);
            btnMon.addActionListener(e -> {
                Monitor m = new Monitor(txtNomeMon.getText(), txtLogMon.getText(), new String(txtSenhaMon.getPassword()));
                bancoUsuarios.add(m);
                materiaAtiva.matricularUsuario(m);
                atualizarTelaMateriaDashboard();
            });
            btnRemoverMon.addActionListener(e -> {
                Monitor m = listMon.getSelectedValue();
                if (m != null) {
                    materiaAtiva.removerUsuario(m);
                    atualizarTelaMateriaDashboard();
                }
            });
            abas.addTab("Gerenciar Monitores", pnlMonitores);
        }

        JPanel pnlRepo = new JPanel(new BorderLayout(10, 10));
        pnlRepo.setBorder(new EmptyBorder(10, 10, 10, 10));
        DefaultListModel<String> repoModel = new DefaultListModel<>();
        for (String s : materiaAtiva.getRepositorio()) repoModel.addElement(s);
        JList<String> listRepo = new JList<>(repoModel);
        listRepo.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JPanel pnlTopRepo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtLink = new JTextField(20);
        JButton btnAddLink = new JButton("Adicionar Link");
        JButton btnAddFile = new JButton("Enviar Arquivo");

        btnAddLink.addActionListener(e -> {
            if (!txtLink.getText().trim().isEmpty()) {
                String entry = "[" + usuarioLogado.nome + "] Link: " + txtLink.getText().trim();
                materiaAtiva.adicionarMaterial(entry);
                repoModel.addElement(entry);
                txtLink.setText("");
            }
        });

        btnAddFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String entry = "[" + usuarioLogado.nome + "] Arquivo: " + file.getName();
                materiaAtiva.adicionarMaterial(entry);
                repoModel.addElement(entry);
            }
        });

        pnlTopRepo.add(new JLabel("Novo Item:"));
        pnlTopRepo.add(txtLink);
        pnlTopRepo.add(btnAddLink);
        pnlTopRepo.add(btnAddFile);

        JPanel pnlBotRepo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRemoverRepo = new JButton("Apagar Selecionado");
        btnRemoverRepo.setBackground(new Color(231, 76, 60));
        btnRemoverRepo.setForeground(Color.WHITE);
        btnRemoverRepo.setEnabled(false);

        listRepo.addListSelectionListener(e -> {
            String selected = listRepo.getSelectedValue();
            if (selected != null) {
                boolean isAutor = selected.startsWith("[" + usuarioLogado.nome + "]");
                boolean isMod = usuarioLogado.getNivel() >= 2;
                btnRemoverRepo.setEnabled(isAutor || isMod);
            } else {
                btnRemoverRepo.setEnabled(false);
            }
        });

        btnRemoverRepo.addActionListener(e -> {
            String selected = listRepo.getSelectedValue();
            if (selected != null) {
                materiaAtiva.getRepositorio().remove(selected);
                repoModel.removeElement(selected);
            }
        });

        pnlBotRepo.add(btnRemoverRepo);
        pnlRepo.add(pnlTopRepo, BorderLayout.NORTH);
        pnlRepo.add(new JScrollPane(listRepo), BorderLayout.CENTER);
        pnlRepo.add(pnlBotRepo, BorderLayout.SOUTH);
        abas.addTab("Repositorio de Arquivos", pnlRepo);
        abas.addTab("Chat Geral", criarPainelChat(materiaAtiva.getChatGeral(), null));

        JPanel pnlChatAulas = new JPanel(new BorderLayout(10, 10));
        pnlChatAulas.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel topChatAulas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Aula> comboAulasChat = new JComboBox<>(materiaAtiva.getAulas().toArray(new Aula[0]));
        topChatAulas.add(new JLabel("Aula:"));
        topChatAulas.add(comboAulasChat);
        JPanel areaDeChatDinamico = new JPanel(new BorderLayout());

        Runnable atualizarChatAula = () -> {
            areaDeChatDinamico.removeAll();
            Aula a = (Aula) comboAulasChat.getSelectedItem();
            if (a != null) areaDeChatDinamico.add(criarPainelChat(a.getChat(), null), BorderLayout.CENTER);
            areaDeChatDinamico.revalidate();
            areaDeChatDinamico.repaint();
        };
        comboAulasChat.addActionListener(e -> atualizarChatAula.run());
        atualizarChatAula.run();
        pnlChatAulas.add(topChatAulas, BorderLayout.NORTH);
        pnlChatAulas.add(areaDeChatDinamico, BorderLayout.CENTER);
        abas.addTab("Chats por Aula", pnlChatAulas);

        painelConteudoMateria.add(abas, BorderLayout.CENTER);
        painelConteudoMateria.revalidate();
        painelConteudoMateria.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UI().setVisible(true));
    }
}