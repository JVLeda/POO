import java.util.ArrayList;
import java.util.List;

class Chat {
    private List<Mensagem> historico = new ArrayList<>();

    public void adicionarMensagem(Mensagem m) {
        historico.add(m);
    }

    public void removerMensagem(Mensagem m) {
        historico.remove(m);
    }

    public List<Mensagem> getHistorico() {
        return historico;
    }
}
