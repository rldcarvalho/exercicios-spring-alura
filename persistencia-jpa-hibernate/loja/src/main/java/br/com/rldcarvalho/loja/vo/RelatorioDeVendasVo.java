package br.com.rldcarvalho.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

    private String nomeProduto;
    private Long quantidadeVendida;
    private LocalDate dataUltimaVenda;

    public RelatorioDeVendasVo(String nomeProduto, Long quantiedadeVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantiedadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo{" +
                "Nome do Produto ='" + nomeProduto + '\'' +
                ", Quantidade Vendida =" + quantidadeVendida +
                ", Data da Ultima Venda =" + dataUltimaVenda +
                '}';
    }
}
