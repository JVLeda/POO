package Atividade_3;

public class Flor {
    private String nome;
    private String cor;
    private String perfume;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return this.cor;
    }

    public void setPerfume(String perfume) {
        this.perfume = perfume;
    }

    public String getPerfume() {
        return this.perfume;
    }

    public void mostrarDados() {
        System.out.println("Nome da flor: " + this.getNome());
        System.out.println("Cor da flor: " + this.getCor());
        System.out.println("Tem perfume? " + this.getPerfume());
    }
}
