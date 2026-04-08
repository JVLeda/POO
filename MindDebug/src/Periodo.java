import java.util.ArrayList;
import java.util.List;

class Periodo {
    private String nome;
    private List<Materia> materias = new ArrayList<>();

    public Periodo(String nome) {
        this.nome = nome;
    }

    public void adicionarMateria(Materia m) {
        materias.add(m);
    }

    public void removerMateria(Materia m) {
        materias.remove(m);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
