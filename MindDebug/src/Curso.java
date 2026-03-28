import java.util.ArrayList;
import java.util.List;

class Curso {
    private String nome;
    private List<Periodo> periodos = new ArrayList<>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public void adicionarPeriodo(Periodo p) {
        periodos.add(p);
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
