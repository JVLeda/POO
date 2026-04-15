package Atividade_13_ClasseAbstrata;

public class Main {
    public static void main (String[] args){
        Forma[] forma = new Forma[2];
        forma[0] = new Quadrado(3);

        for(Forma f : forma){
            f.area();
            f.perimetro();
        }
    }
}
