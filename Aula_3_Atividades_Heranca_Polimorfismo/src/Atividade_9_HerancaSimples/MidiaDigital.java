package Atividade_9_HerancaSimples;

public class MidiaDigital extends MaterialBibliografico{
    private String formato;
    private double tamanhoMb;
    private int totalDownloads;

    public MidiaDigital(String titulo, int codigo, String formato, double tamanhoMb, int totalDownloads){
        super(titulo, codigo);
        this.formato = formato;
        this.tamanhoMb = tamanhoMb;
        this.totalDownloads = totalDownloads;
    }

    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getFormato(){
        return formato;
    }
    public void setTamanhoMb(double tamanhoMb){
        this.tamanhoMb = tamanhoMb;
    }
    public double getTamanhoMb(){
        return tamanhoMb;
    }
    public void setTotlaDownloads(int totalDownloads){
        this.totalDownloads = totalDownloads;
    }
    public int getTotalDownloads(){
        return totalDownloads;
    }

    @Override
    public void emprestar(){
        super.emprestar();
        System.out.println("Formato do arquivo: " + getFormato() + "| Tamanho do arquivo (MB): " + getTamanhoMb() + "MB" + "| Total de downloads: " + getTotalDownloads());
    }
}
