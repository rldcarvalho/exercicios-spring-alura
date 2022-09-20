package br.com.rldcarvalho.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rldcarvalho.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.rldcarvalho.mvc.mudi.model.Pedido;
import br.com.rldcarvalho.mvc.mudi.model.User;
import br.com.rldcarvalho.mvc.mudi.repository.PedidoRepository;
import br.com.rldcarvalho.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userRepository.findByUsername(username);
		
		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}

}
