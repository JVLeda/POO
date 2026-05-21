package Atividade_9_HerancaSimples;

public class MaterialBibliografico {
    protected String titulo;
    protected int codigo;

    public MaterialBibliografico(String titulo, int codigo){
        this.titulo = titulo;
        this.codigo = codigo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }

    public void emprestar(){
        System.out.println("Material: " +  getTitulo() + "| Código: " + getCodigo() + " foi emprestado com sucesso!");
        System.out.println("Mais informações: ");

    }
}
