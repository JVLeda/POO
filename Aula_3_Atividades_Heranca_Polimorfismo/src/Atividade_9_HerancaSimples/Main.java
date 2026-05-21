package Atividade_9_HerancaSimples;

public class Main {
    public static void main (String[] args) {
        Livro livro1 = new Livro("Equações diferenciais Vol.1", 123456789, "Dennis G. Zill e Michael R Cullen", "123-456-789-1011-1");
        livro1.emprestar();
        Revista revista1 = new Revista(" Veja",321654987,"Abril");
        revista1.emprestar();
        MidiaDigital midiaDigital1 = new MidiaDigital("Stwart_1_ptbr", 987654321, "PDF", 0.007, 54725);
        midiaDigital1.emprestar();

    }
}
