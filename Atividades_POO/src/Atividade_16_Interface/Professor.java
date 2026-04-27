package Atividade_16_Interface;

public class Professor extends Funcionario implements Interface{
    private String disciplina;

    public Professor(String nome, String disciplina){
        super(nome);
        this.disciplina = disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    public String getDisciplina(){
        return disciplina;
    }

    public void lecionar(){
        System.out.println(nome + " está lecionando a disciplina de " + getDisciplina());
    }

    public void registrarPresenca(){
        System.out.println("Presença registrada para o(a) professor(a): "+ nome);
    }

    @Override
    public void exibirDados(){
        System.out.println("Professor(a):");
        System.out.println("Nome:" + nome);
        System.out.println("Disciplina:" + getDisciplina());

    }
}
