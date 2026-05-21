package Atividade_12_ClasseAbstrata;

public class CLT extends Funcionario{
    private double salario;
    private int diasMes;
    private int diasTrabalhados;


    public CLT(String nome, double salario,int diasMes, int diasTrabalhados){
        super(nome);
        this.salario = salario;
        this.diasMes = diasMes;
        this.diasTrabalhados = diasTrabalhados;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return salario;
    }
    public void setDiasMes(int diasMes){
        this.diasMes = diasMes;
    }
    public int getDiasMes(){
        return diasMes;
    }
    public void getDiasTrabalhados(int diasTrabalhados){
        this.diasTrabalhados = diasTrabalhados;
    }
    public int getDiasTrabalhados(){
        return diasTrabalhados;
    }

    @Override
    public void calcularSalario() {
        salario = (salario*diasTrabalhados)/diasMes;
        System.out.printf("Salário de %s: R$ %.2f.%n", nome, getSalario());

    }
}
