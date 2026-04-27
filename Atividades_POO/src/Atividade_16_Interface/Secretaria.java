package Atividade_16_Interface;

public class Secretaria extends Funcionario implements Interface{
    private String turno;

    public Secretaria(String nome, String turno){
        super(nome);
        this.turno = turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }
    public String getTurno(){
        return turno;
    }

    public void organizarDocumento(){
        System.out.println(nome + " está lecionando a disciplina de " + getTurno());
    }

    public void registrarPresenca(){
        System.out.println("Presença registrada para o(a) secretario(a): " + nome);
    }

    @Override
    public void exibirDados(){
        System.out.println("Professor(a):");
        System.out.println("Nome:" + nome);
        System.out.println("Disciplina:" + getTurno());

    }
}
