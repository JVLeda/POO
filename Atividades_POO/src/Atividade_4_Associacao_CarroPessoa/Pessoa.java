package Atividade_4_Associacao_CarroPessoa;

public class Pessoa {
    private String nome;
    private String endereco;
    private int idade;
    private boolean habilitado;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public void setHabilitado(boolean habilitado){
        this.habilitado = habilitado;
    }
    public String getNome(){
        return nome;
    }
    public String getEnderco(){
        return endereco;
    }
    public int getIdade(){
        return idade;
    }
    public boolean getHabilitado(){
        return habilitado;
    }
    public void usarCarro(Carro carro){
       if(idade < 18){
           habilitado = false;
           System.out.println(getNome() + " não tem a idade mínima para ter uma habilitação. Logo não pode dirigir.");
       } else{
           System.out.println(getNome() + " está usando um carro.");
           carro.dirigir();
       }
    }

}
