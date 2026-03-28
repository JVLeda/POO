class Dev extends Usuario {
    public Dev(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public int getNivel() {
        return 4;
    }
}
