import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Aula implements Serializable {
    private String titulo;
    private List<Feedback> feedbacks = new ArrayList<>();
    private Chat chatAula = new Chat();

    public Aula(String titulo) { this.titulo = titulo; }

    public void adicionarFeedback(Feedback f) { feedbacks.add(f); }
    public double calcularMedia() {
        if (feedbacks.isEmpty()) return 0;
        double soma = 0;
        for(Feedback f : feedbacks) soma += f.getValor();
        return soma / feedbacks.size();
    }
    public boolean isCritico() { return calcularMedia() > 7.0; }
    public String getTitulo() { return titulo; }
    public Chat getChat() { return chatAula; }
    @Override public String toString() { return titulo; }
}