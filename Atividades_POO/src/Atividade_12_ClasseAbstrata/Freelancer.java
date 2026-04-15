package Atividade_12_ClasseAbstrata;

public class Freelancer extends Funcionario{
    private double salario;
    private double custosMensais;
    private int horasProdutivas;


    public Freelancer(String nome,double salario, double custosMensais, int horasProdutivas){
        super(nome);
        this.salario = salario;
        this.custosMensais = custosMensais;
        this.horasProdutivas = horasProdutivas;

    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return salario;
    }
    public void setCustosMensais(double custosMensais){
        this.custosMensais = custosMensais;
    }
    public double getCustosMensais(){
        return custosMensais;
    }
    public void setHorasProdutivas(int horasProdutivas){
        this.horasProdutivas = horasProdutivas;
    }
    public int getHorasProdutivas(){
        return horasProdutivas;
    }



    @Override
    public void calcularSalario(){
        salario = (salario+custosMensais)/horasProdutivas;
        System.out.printf("Salário de %s: R$ %.2f por hora.%n", nome, getSalario());

    }
}
