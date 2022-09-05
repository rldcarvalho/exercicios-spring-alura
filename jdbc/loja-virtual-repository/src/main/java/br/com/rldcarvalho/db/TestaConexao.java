package br.com.rldcarvalho.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "password";

        Connection connection = DriverManager.getConnection(url, user, password);

        connection.close();

    }
}
