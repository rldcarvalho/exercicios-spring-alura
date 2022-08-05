package br.com.rldcarvalho.loja.testes;

import br.com.rldcarvalho.loja.dao.CategoriaDao;
import br.com.rldcarvalho.loja.dao.ProdutoDao;
import br.com.rldcarvalho.loja.modelo.Categoria;
import br.com.rldcarvalho.loja.modelo.Produto;
import br.com.rldcarvalho.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

//        List<Produto> todos = produtoDao.buscarTodos();
//        todos.forEach(p2 -> System.out.println(p.getNome()));

//        List<Produto> todos = produtoDao.buscarPorNome("Samsung S20 fe");
//        todos.forEach(p2 -> System.out.println(p.getNome()));

//        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
//        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Samsung S20 fe");
        System.out.println("Preço do produto: "  + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Samsung S20 fe", "Muito bom",new BigDecimal("1970.00"), celulares);

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);


        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
