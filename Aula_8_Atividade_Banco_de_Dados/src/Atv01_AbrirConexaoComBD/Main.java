package Atv01_AbrirConexaoComBD;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Testando Consexão");
        Connection conn = AbrirConexaoSemTratamentoDeExcecoes.getConnection();
    }
}
