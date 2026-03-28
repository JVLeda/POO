class Monitor extends Usuario {
    public Monitor(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public int getNivel() {
        return 2;
    }
}
