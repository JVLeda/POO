package Atividade_5_Associacao_LeitorEmprestimoLivro;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Leitor leitor1 = new Leitor();
        leitor1.setNome("João Vitor") ;
        leitor1.setMatricula(2024406010);
        leitor1.setEmail("leda@unifesspa.edu.br");
        leitor1.setTelefone("(94) 91234-5678");

        Livro livro1 = new Livro();
        livro1.setTitulo("O Pequeno Príncipe");
        livro1.setAutor("Antoine de Saint-Exupéry");
        livro1.setIsbn("978-3-16-148410-0");

        LocalDate hoje = LocalDate.of(2026, 04, 23);
        LocalDate devolucao = hoje.plusDays(7);

        Emprestimo emp = new Emprestimo(leitor1, livro1, hoje, devolucao);

        emp.resumo();

        LocalDate dataSimulada = LocalDate.of(2026, 05, 01);
        System.out.println("Está atrasado em " + dataSimulada + "? " + (emp.estaAtrasado(dataSimulada) ? "Sim" : "Não"));

        emp.devolverLivro();

        System.out.println("Status final do livro: " + livro1.isEmprestado());
    }
}