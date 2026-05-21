package Atividade_6_Agregacao_CursoInstrutor;

public class Curso {
    private String nome;
    private int cargaHoraria;
    private String nivel;
    private String descricao;
    private Instrutor instrutor1;
    private Instrutor instrutor2;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setInstrutor1(Instrutor instrutor1){
        this.instrutor1 = instrutor1;
    }
    public void setInstrutor2(Instrutor instrutor2){
        this.instrutor2 = instrutor2;
    }
    public String getNome(){
        return nome;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public String getNivel() {
        return nivel;
    }
    public String getDescricao(){
        return descricao;
    }
    public Instrutor getInstrutor1(){
        return instrutor1;
    }
    public Instrutor getInstrutor2(){
        return instrutor2;
    }

    public void associarInstrutor(){

    }
    public void exibirCurso(){
        System.out.println("Curso: " + getNome());
        System.out.println("Carga Horária: " + getCargaHoraria() + "h");
        System.out.println("Nível: " + getNivel());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Instrutor: " + getInstrutor1());
        System.out.println("Instrutor: " + getInstrutor2());
    }
}
