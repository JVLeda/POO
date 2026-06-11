package Atv02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void criarTabela(){
        try(
                Connection conn = AbrirConexaoComBD.getConnection();
                Statement sentenca = conn.createStatement()
        ){
            sentenca.execute(
                    "Create table pessoa("
                    + "id decimal(10,0) Primary key,"
                    + "nome varchar(50),"
                    + "endereco varchar(100)"
                    + ")"
            );
            System.out.println("Tabela criada com sucesso!");
        }catch(SQLException e){
            System.out.println("Erro ao criar tabela.");

        }
    }
}
