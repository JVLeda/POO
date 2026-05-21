package Atividade_16_Interface;

public class Diretor extends Funcionario{
    private String setor;

    public Diretor(String nome, String setor){
        super(nome);
        this.setor = setor;
    }

    public void getSetor(String setor){
        this.setor = setor;
    }
    public String getSetor(){
        return setor;
    }

    public void tomarDecisao(){
        System.out.println(nome + " está tomando decisões no setor de " + getSetor());
    }

    @Override
    public void exibirDados(){
        System.out.println("Diretor(a):");
        System.out.println("Nome:" + nome);
        System.out.println("Setor:" + getSetor());

    }
}
