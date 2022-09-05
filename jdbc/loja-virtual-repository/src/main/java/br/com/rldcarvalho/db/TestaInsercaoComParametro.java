package br.com.rldcarvalho.db;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            connection.setAutoCommit(false);


            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                adicionarVariavel("SmartTV", "45 polegadas", statement);
                adicionarVariavel("Radio", "Radio a bateria", statement);

                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);


        statement.execute();

        try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
            while (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        }
    }
}