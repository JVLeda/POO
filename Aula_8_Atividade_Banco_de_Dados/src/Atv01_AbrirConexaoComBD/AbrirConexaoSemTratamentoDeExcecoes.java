package Atv01_AbrirConexaoComBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbrirConexaoSemTratamentoDeExcecoes {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    public static final String USUARIO = "root";
    public static final String SENHA = "Leda123";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        System.out.println("Conexão realizada com sucesso!");
        return conn;
    }
}
