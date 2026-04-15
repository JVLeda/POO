package Atividade_11_ClasseAbstrataPolimorfismo;

public class Main {
    public static void main (String[] args){
        Animal[] animal = new Animal[3];
        animal[0] = new Papagaio("Louro", 35);
        animal[1] = new Vaca("Josefina", true);
        animal[2] = new Gato("Felício", true);

        for (Animal a : animal){
            a.emitirSom();
            a.mover();
        }
    }
}
