package Atv_01.app.dao;

import Atv_01.app.model.Pessoa;
import Atv_01.app.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDao {
    public void inserir(Pessoa pessoa) {
        String sql = "insert into pessoa(nome) values(?)";
        try (
                Connection conn = Conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setString(1, pessoa.getNome());
            statement.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Pessoa buscarPorNome(String nome) {
        String sql = "select * from pessoa where nome = ?";
        try (
                Connection conn = Conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                return pessoa;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Pessoa pessoa) {
        String sql = "update pessoa set nome = ? where id = ?";
        try (
                Connection conn = Conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setString(1, pessoa.getNome());
            statement.setInt(2, pessoa.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "delete from pessoa where id = ?";
        try (
                Connection conn = Conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}




