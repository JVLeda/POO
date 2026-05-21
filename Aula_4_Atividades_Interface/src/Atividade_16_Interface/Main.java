package Atividade_16_Interface;

public class Main {
    public static void main (String [] args){
        Diretor d1 = new Diretor("Josivaldo", "Admnistrativo");
        d1.exibirDados();
        d1.tomarDecisao();

        Professor p1 = new Professor("Ronaldo", "Historia");
        p1.exibirDados();
        p1.lecionar();
        p1.registrarPresenca();


        Secretaria s1 = new Secretaria("Isabel", "Manhã");
        s1.exibirDados();
        s1.organizarDocumento();
        s1.registrarPresenca();


        Terceirizado t1 = new Terceirizado("Edinaldo Pedro Pereira");
        t1.executarServico();
        t1.registrarPresenca();
    }
}
