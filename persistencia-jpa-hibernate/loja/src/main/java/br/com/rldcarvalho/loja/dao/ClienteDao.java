package br.com.rldcarvalho.loja.dao;

import br.com.rldcarvalho.loja.modelo.Cliente;
import br.com.rldcarvalho.loja.modelo.Pedido;
import br.com.rldcarvalho.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }


    public Cliente buscarPorId(long id) {

        return em.find(Cliente.class, id);

    }
}
