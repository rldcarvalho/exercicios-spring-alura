package br.com.rldcarvalho.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {

        String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "password";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
