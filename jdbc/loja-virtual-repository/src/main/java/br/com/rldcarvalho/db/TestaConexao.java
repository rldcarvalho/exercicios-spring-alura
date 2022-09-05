package br.com.rldcarvalho.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().recuperarConexao();

        System.out.println("Fechando conexao");

        connection.close();

    }
}
