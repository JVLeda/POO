import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Mensagem implements Serializable {
    private Usuario autor;
    private String texto;
    private String hora;

    public Mensagem(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.hora = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public Usuario getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        // Agora o autor.getNome() vai funcionar!
        return "[" + hora + "] " + autor.getNome() + ": " + texto;
    }
}