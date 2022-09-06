package br.com.rldcarvalho.db;

import br.com.rldcarvalho.db.dao.ProdutoDAO;
import br.com.rldcarvalho.db.model.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Comoda", "Comoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){

            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(System.out::println);

        }
    }
}
