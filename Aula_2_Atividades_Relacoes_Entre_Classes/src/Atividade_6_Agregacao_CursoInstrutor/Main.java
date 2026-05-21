package Atividade_6_Agregacao_CursoInstrutor;

public class Main {
    public static void main (String[] args){
        Instrutor i1 = new Instrutor();
        i1.setNome("Ana Ribeiro");
        i1.setFormacao("Engenharia da Computação.");
        i1.setEmail("anaribeiro@unifesspa.edu.br");
        i1.setExperienciaAnos(15);

        Curso c1 = new Curso();
        c1.setNome("Programação em Java.");
        c1.setCargaHoraria(60);
        c1.setNivel("Avançado");
        c1.setDescricao("Curso focado no desenvolvidmento de técnicas avançadas de programação em Java");
        c1.setInstrutor1(i1);
        c1.exibirCurso();
        i1.aplicarAvaliacao("Programação em Java");
        i1.agendarLive("10/04/2026 às 19h");
    }
}
