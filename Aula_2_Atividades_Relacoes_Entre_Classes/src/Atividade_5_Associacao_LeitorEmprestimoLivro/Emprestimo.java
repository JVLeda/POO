package Atividade_5_Associacao_LeitorEmprestimoLivro;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Leitor leitor;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Emprestimo(Leitor leitor, Livro livro, LocalDate dataRetirada, LocalDate dataDevolucao){
        this.leitor = leitor;
        this.livro = livro;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }
    public void setLivro(Livro livro){
        this.livro = livro;
    }
    public void setLeitor(Leitor leitor){
        this.leitor = leitor;
    }
    public void setDataRetirada(LocalDate dataRetirada){
        this.dataRetirada = dataRetirada;
    }
    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
    public Livro getLivro(){
        return livro;
    }
    public Leitor getLeitor(){
        return leitor;
    }
    public LocalDate getDataRetirada(){
        return dataRetirada;
    }
    public LocalDate getDataDevolucao(){
        return dataDevolucao;
    }
    public void resumo(){
        System.out.println(leitor.getNome() + " realizou o empréstimo do: " + livro.exibirInformacoes());
        System.out.println("Empréstimo:");
        System.out.println(leitor.exibirInformacoes());
        System.out.println(livro.exibirInformacoes());
        livro.marcarComoEmprestado();
        System.out.println("Data de retirada: " + getDataRetirada());
        System.out.println("Data de Devolução: " + getDataDevolucao());
    }
    public void devolverLivro(){
        livro.marcarComoDisponivel();
        System.out.println("Livro devoldido: " + livro.exibirInformacoes());
    }

    public boolean estaAtrasado(LocalDate hoje){
        if(hoje.isAfter(this.dataDevolucao)){
            return true;
        }else{
            return false;
        }
    }




}
