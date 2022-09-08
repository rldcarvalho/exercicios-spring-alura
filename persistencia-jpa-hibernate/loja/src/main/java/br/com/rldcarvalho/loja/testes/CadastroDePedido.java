package br.com.rldcarvalho.loja.testes;

import br.com.rldcarvalho.loja.dao.CategoriaDao;
import br.com.rldcarvalho.loja.dao.ClienteDao;
import br.com.rldcarvalho.loja.dao.PedidoDao;
import br.com.rldcarvalho.loja.dao.ProdutoDao;
import br.com.rldcarvalho.loja.modelo.*;
import br.com.rldcarvalho.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedido {

    public static void main(String[] args) {
       popularBancoDeDados();
        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1l);
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(1l);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();



    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Samsung S20 fe", "Muito bom",new BigDecimal("1970.00"), celulares);

        Cliente cliente = new Cliente("Rafael", "13415");

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);


        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
