package Atividade_9_HerancaSimples;

public class Revista extends MaterialBibliografico{
    private String mesEdicao;

    public Revista(String titulo, int codigo, String mesEdicao){
        super(titulo,codigo);
        this.mesEdicao = mesEdicao;
    }

    public void setMesEdicao(String mesEdicao){
        this.mesEdicao = mesEdicao;
    }
    public String getMesEdicao(){
        return mesEdicao;
    }

    @Override
    public void emprestar(){
        super.emprestar();
        System.out.println("Edição referente ao mês de " + getMesEdicao());
    }
}
