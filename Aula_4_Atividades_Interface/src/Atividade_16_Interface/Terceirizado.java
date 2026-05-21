package Atividade_16_Interface;

public class Terceirizado implements Interface{
    private String nome;

    public Terceirizado(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void executarServico() {
        System.out.println(getNome() + " está executando serviços terceirizados.");

    }

    public void registrarPresenca(){
        System.out.println("Presença registrada para o(a) terceirizado(a): "+ getNome());
    }
}
