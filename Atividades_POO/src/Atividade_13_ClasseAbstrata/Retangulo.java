package Atividade_13_ClasseAbstrata;

public class Retangulo extends Forma {
    private double lado1;
    private double lado2;
    private double op;

    public Retangulo(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public void setLado(int lado1){
        this.lado1 = lado1;
    }
    public double getLado1(){
        return lado1;
    }
    public void setLado2(int lado2){
        this.lado2 = lado2;
    }
    public double getLado2(){
        return lado2;
    }
    public void setOp(int op){
        this.op = op;
    }
    public double getOp(){
        return op;
    }

    @Override
    public void area(){
       op = lado1*lado2;
       System.out.printf("Área do retângulo de lados %.2f e %.2f: %.2f. %n",getLado1(),getLado2(), getOp());
    }
}
