package Atividade_13_ClasseAbstrata;

public class Quadrado extends Forma {
    private int lado;
    private int op;

    public Quadrado(int lado){
        this.lado = lado;
    }

    public void setLado(int lado){
        this.lado = lado;
    }
    public int getLado(){
        return lado;
    }
    public void setOp(int op){
        this.op = op;
    }
    public int getOp(){
        return op;
    }

    @Override
    public void area(){
       op = lado*lado;
       System.out.println("Área do quadrado: " + getOp());
    }
    @Override
    public void perimetro(){
        op = 4*lado;
        System.out.println("Perímetro do quadrado: " + getOp());
    }
}
