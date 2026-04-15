package Atividade_13_ClasseAbstrata;

public class Circulo extends Forma {
    private double raio;
    private double op;

    public Circulo(double raio){
        this.raio = raio;
    }
    public void setRaio(int raio){
        this.raio = raio;
    }
    public double getRaio(){
        return raio;
    }
    public void setOp(int op){
        this.op = op;
    }
    public double getOp(){
        return op;
    }

    @Override
    public void area(){
        op = Math.PI * Math.pow(raio,2);
        System.out.printf("Area do círculo de raio %.2f: %.2f.%n",getRaio(),getOp());
    }

}
