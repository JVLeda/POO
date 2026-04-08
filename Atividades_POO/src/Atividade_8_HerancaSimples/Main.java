package Atividade_8_HerancaSimples;

public class Main {
    public static void main(String[] args) {
        Professor p1 = new Professor("Marcela Alves", 37);
        p1.setDisciplina("Cálculo 1");
        p1.apresentar();
        p1.ensinar();
    }
}