package Atividade_5_Associacao_LeitorEmprestimoLivro;

public class Leitor {
    private String nome;
    private int matricula;
    private String email;
    private String telefone;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getNome(){
        return nome;
    }
    public int getMatricula(){
        return matricula;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }
    public String exibirInformacoes(){
        return "Leitor: " + getNome() + " | Matrícula: " + getMatricula();
    }
    public void confirmarEmprestimo(){
        System.out.println("Empréstimo realizado com sucesso!");
    }

}
