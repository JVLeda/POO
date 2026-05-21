package Atividade_2;

public class Pessoa {
    private String nome;
    private int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
    }
}