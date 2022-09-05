package br.com.rldcarvalho.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.println(id);
            String nome = resultSet.getString("NOME");
            System.out.println(nome);
            String descricao = resultSet.getString("DESCRICAO");
            System.out.println(descricao);
        }

        connection.close();
    }
}
