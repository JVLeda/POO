package Atividade_8_HerancaSimples;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor (String nome, int idade){
        super(nome,idade);
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    public String getDisciplina(){
        return disciplina;
    }
    public void ensinar(){
        System.out.println("Disciplina: " + getDisciplina());
    }
}
