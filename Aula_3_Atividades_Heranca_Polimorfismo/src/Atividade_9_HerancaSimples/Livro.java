package Atividade_9_HerancaSimples;

public class Livro extends MaterialBibliografico{
    private String autor;
    private String isbn;

    public Livro(String titulo, int codigo, String autor, String isbn){
        super(titulo, codigo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getIsbn(){
        return isbn;
    }

    @Override
    public void emprestar(){
        super.emprestar();
        System.out.println("Autor(a): " + getAutor() + "| ISBN: " + getIsbn());
    }
}
