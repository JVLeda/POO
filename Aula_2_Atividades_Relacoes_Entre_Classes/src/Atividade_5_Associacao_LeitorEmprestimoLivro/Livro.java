package Atividade_5_Associacao_LeitorEmprestimoLivro;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean getEmprestado(){
        return emprestado;
    }

    public void marcarComoEmprestado(){
        emprestado = true;
    }
    public void marcarComoDisponivel(){
        emprestado = false;
    }

    public String isEmprestado(){
        if(emprestado){
           return "Este livro está indisponível para empréstimo no momento.";
        } else{
            return "Este livro está disponível para empréstimo.";
        }
    }

    public String exibirInformacoes(){
            return "Livro: " + getTitulo() + " | Autor" + getAutor() + " | ISBN: " + getIsbn() + " | Status: " + isEmprestado();
    }
}
