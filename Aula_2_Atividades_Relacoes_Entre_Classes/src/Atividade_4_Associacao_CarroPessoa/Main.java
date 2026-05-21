package Atividade_4_Associacao_CarroPessoa;

public class Main {
    public static void main(String[] args){
        Carro c1 = new Carro();
        c1.setModelo("Supra");
        c1.setMarca("Toyota");
        c1.setPlaca("ABC-1D23");
        c1.setDisponivel(true);

        Pessoa p1 = new Pessoa();
        p1.setNome("Fernando");
        p1.setEndereco("Rua Rio de Janeiro");
        p1.setIdade(21);
        p1.setHabilitado(true);
        p1.usarCarro(c1);
    }
}
