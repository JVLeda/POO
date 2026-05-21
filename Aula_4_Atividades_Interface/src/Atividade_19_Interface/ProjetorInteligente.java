package Atividade_19_Interface;

public class ProjetorInteligente implements Ligavel, Conectavel{


    @Override
    public void ligar(){
        System.out.println("Projetor ligado com sucesso!");
    }

    @Override
    public void conectarInternet(){
        System.out.println("Projetor conectado à internet.");

    }

}
