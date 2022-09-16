package br.com.rldcarvalho.mvc.mudi.dto;



import javax.validation.constraints.NotEmpty;

import br.com.rldcarvalho.mvc.mudi.model.Pedido;
import br.com.rldcarvalho.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotEmpty
	private String nomeProduto;
	@NotEmpty
	private String urlProduto;
	@NotEmpty
	private String urlImagem;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		
		Pedido pedido = new Pedido();
		
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

	
}
