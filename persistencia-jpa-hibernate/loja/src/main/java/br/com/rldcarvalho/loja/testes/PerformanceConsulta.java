package br.com.rldcarvalho.loja.testes;

import br.com.rldcarvalho.loja.dao.CategoriaDao;
import br.com.rldcarvalho.loja.dao.ClienteDao;
import br.com.rldcarvalho.loja.dao.PedidoDao;
import br.com.rldcarvalho.loja.dao.ProdutoDao;
import br.com.rldcarvalho.loja.modelo.*;
import br.com.rldcarvalho.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PerformanceConsulta {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JpaUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPedidoComCLiente(1l);

        em.close();

        System.out.println(pedido.getCliente().getNome());
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Samsung S20 fe", "Celular Branco",new BigDecimal("1970.00"), celulares);
        Produto videogame = new Produto("PS5", "PlayStation 5",new BigDecimal("4000.00"), celulares);
        Produto macbook = new Produto("Mackbook", "Mackbook pro",new BigDecimal("10000.00"), celulares);

        Cliente cliente = new Cliente("Rafael", "13415");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, celular));
        pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

        Pedido pedido2 = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(2, pedido2, macbook));


        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);


        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        clienteDao.cadastrar(cliente);

        pedidoDao.cadastrar(pedido);
        pedidoDao.cadastrar(pedido2);

        em.getTransaction().commit();
        em.close();
    }
}
