package Atividade_13_ClasseAbstrata;

public class Main {
    public static void main (String[] args){
        Forma[] forma = new Forma[2];
        forma[0] = new Retangulo(3,2);
        forma[1] = new Circulo(2);

        for(Forma f : forma){
            f.area();
        }
    }
}
