import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Materia implements Serializable {
    public String nome;
    public Professor professor;
    private List<Usuario> equipeEAlunos = new ArrayList<>();
    private List<Aula> aulas = new ArrayList<>();
    private List<String> repositorio = new ArrayList<>();
    private Chat chatGeral = new Chat();
    private Chat chatEquipe = new Chat();

    public Materia(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.equipeEAlunos.add(professor);
    }

    // Métodos que a UI está pedindo (Cannot resolve method):
    public void matricularUsuario(Usuario u) { if(!equipeEAlunos.contains(u)) equipeEAlunos.add(u); }
    public void removerUsuario(Usuario u) { equipeEAlunos.remove(u); }
    public void adicionarAula(Aula aula) { aulas.add(aula); }
    public void adicionarMaterial(String link) { repositorio.add(link); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor p) { this.professor = p; }
    public List<Aula> getAulas() { return aulas; }
    public List<String> getRepositorio() { return repositorio; }
    public Chat getChatGeral() { return chatGeral; }
    public Chat getChatEquipe() { return chatEquipe; }
    public int getTotalAlunosMatriculados() {
        int total = 0;
        for(Usuario u : equipeEAlunos) {
            if(u instanceof Estudante) total++; //
        }
        return total;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public List<Monitor> getMonitores() {
        List<Monitor> monitores = new ArrayList<>();
        for(Usuario u : equipeEAlunos) {
            if(u instanceof Monitor) monitores.add((Monitor)u);
        }
        return monitores;
    }
}