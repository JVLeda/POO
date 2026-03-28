import java.io.Serializable;

public abstract class Usuario implements Serializable {
    // Mude para public para facilitar o acesso da UI por enquanto
    public String nome;
    public String login;
    public String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // A UI e a classe Mensagem precisam deste método:
    public String getNome() {
        return nome;
    }

    public abstract int getNivel();

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}