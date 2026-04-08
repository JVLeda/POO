public class Feedback {
    private int valor; // 0 a 10 (Compreensão)
    private Estudante aluno;

    public Feedback(int valor, Estudante aluno) {
        this.valor = valor;
        this.aluno = aluno;
    }

    public int getValor() {
        return valor;
    }
}