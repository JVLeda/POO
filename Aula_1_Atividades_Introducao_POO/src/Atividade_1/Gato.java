package Atividade_1;

public class Gato {
    public String nome;
    public int estoqueComida;
    public boolean sono;

    public void comer() {
        if (estoqueComida > 0) {
            estoqueComida -= 1;
            System.out.println(nome + " acabou de se alimentar e agora está com o buxinho cheio! comida restante: " + estoqueComida);
            if (estoqueComida == 0) {
                System.out.println("Acabou a comida...");
            }
        } else {
            System.out.println("Acabou a comida... Agora   está com raiva e com fome!");
        }

    }

    public void dormir() {
        if (sono) {
            sono = false;
            System.out.println(nome + " tirou um soninho gostoso e está com muita energia!");
        } else {
            System.out.println(nome + " está sapeca demais para dormir agora.");
        }

    }

    public void coletarComida() {
        if (sono) {
            System.out.println(nome + " está com muita preguiça para se mover e precisa descansar.");
        } else {
            estoqueComida += 1;
            sono = true;
            System.out.println(nome + " encontrou um bixinho indefeso enquanto passeava e vai guardá-lo pra comer depois.");
        }

    }
}
