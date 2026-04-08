public class Estudante extends Usuario {
    private String email;
    private String matricula;
    private Curso curso;

    public Estudante(String nome, String email, String matricula, String senha, Curso curso) {
        super(nome, matricula, senha);
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Curso getCurso() { return curso; }
    @Override public int getNivel() { return 1; }
}