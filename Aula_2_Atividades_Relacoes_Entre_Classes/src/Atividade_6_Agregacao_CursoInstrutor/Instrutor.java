package Atividade_6_Agregacao_CursoInstrutor;

public class Instrutor {
    private String nome;
    private String formacao;
    private String email;
    private int experienciaAnos;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setFormacao(String formacao){
        this.formacao = formacao;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setExperienciaAnos(int experienciaAnos){
        this.experienciaAnos = experienciaAnos;
    }
    public String getNome(){
        return nome;
    }
    public String getFormacao(){
        return formacao;
    }
    public String getEmail(){
        return email;
    }
    public int getExperienciaAnos(){
            return experienciaAnos;
    }

    public void exibirInstrutor(){
        System.out.println("Instrutor: " + getNome());
        System.out.println("Formação: " + getFormacao());
        System.out.println("Email: " + getEmail());
        System.out.println("Experiencia: " + (getExperienciaAnos() > 1 ? "anos.": "ano."));

    }
    public void aplicarAvaliacao(String cursoNome){
        System.out.println("Prof. " + getNome() + " vai aplicar uma avaliação referenta à disciplina de " + cursoNome);
    }
    public void responderDuvidas(String duvida){
        System.out.println("Prof. " + getNome() + "vai responder a seguinte dúvida de um aluno:");
        System.out.println(duvida);
    }
    public void criarMaterialDeApoio(String titulo){
        System.out.println("Prof. " + getNome() + " criou o seguinte material de apoio: " + titulo);
    }
    public void agendarLive(String dataHora){
        System.out.println("Prof. " + getNome() + " agendou uma live para a seguinte data: " + dataHora);
    }
}
