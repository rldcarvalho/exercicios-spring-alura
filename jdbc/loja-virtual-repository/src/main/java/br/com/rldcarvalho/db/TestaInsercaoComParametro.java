package br.com.rldcarvalho.db;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "Mouse";
        String descricao = "Mouse sem fio";

        Connection connection = new ConnectionFactory().recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, nome);
        statement.setString(2, descricao);


        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        while (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}