package br.com.rldcarvalho.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.rldcarvalho.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/home")
	public String home(Model model) {
//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Kindle 11ª Geração");
//		pedido.setUrlImagem("https://m.media-amazon.com/images/I/71B1wzw1LkL._AC_SX679_.jpg");
//		pedido.setUrlProduto("https://www.amazon.com.br/dp/B09SWTG9GF?pf_rd_r=3JTRJN43TRVASSZ2A7CG&pf_rd_p=1f0425c2-3d67-45e8-a18d-b06503872a24&pd_rd_r=d026fe44-ebad-4b83-9131-c02254cf140b&pd_rd_w=e9863&pd_rd_wg=U0DNM&ref_=pd_gw_unk");
//		pedido.setDescricao("Novo Kindle 11ª Geração (lançamento 2022) – Mais leve, com resolução de 300 ppi e o dobro de armazenamento - Cor Preta");
//		
//		List<Pedido> pedidos = Arrays.asList(pedido);
		
		Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
		List<Pedido> pedidos = query.getResultList();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
