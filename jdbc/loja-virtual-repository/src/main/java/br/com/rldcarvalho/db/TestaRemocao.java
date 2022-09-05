package br.com.rldcarvalho.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionFactory().recuperarConexao();

        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM PRODUTO WHERE ID > 2");

        int linhasModificadas = statement.getUpdateCount();

        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }
}
