package Atividade_13_ClasseAbstrata;

public class Quadrado extends Forma {
    private int lado;

    public Quadrado(int lado){
        this.lado = lado;
    }

    public void setLado(int lado){
        this.lado = lado;
    }
    public int getLado(){
        return lado;
    }

    @Override
    public void area(){
       lado = lado*lado;
       System.out.println("Área do quadrado: " + getLado());
    }
    @Override
    public void perimetro(){
        lado = 4*lado;
        System.out.println("Perímetro do quadrado: " + getLado());
    }
}
