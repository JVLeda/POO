class Professor extends Usuario {
    public Professor(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public int getNivel() {
        return 3;
    }
}
