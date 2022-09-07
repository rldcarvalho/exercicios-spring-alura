package br.com.rldcarvalho.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rldcarvalho.jdbc.dao.CategoriaDAO;
import br.com.rldcarvalho.jdbc.factory.ConnectionFactory;
import br.com.rldcarvalho.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController(){
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}
	public List<Categoria> listar() {

		return this.categoriaDAO.listar();
	}
}
