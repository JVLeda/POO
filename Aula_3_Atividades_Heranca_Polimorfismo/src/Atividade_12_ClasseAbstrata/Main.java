package Atividade_12_ClasseAbstrata;

public class Main {
    public static void main(String[] args){
        Funcionario[] funcionario = new Funcionario[2];
        funcionario[0] = new CLT("Ana", 3000, 30, 22);
        funcionario[1] = new Freelancer("Carlos", 3000, 450, 112);


        for (Funcionario f : funcionario){
            f.calcularSalario();
        }
    }
}
