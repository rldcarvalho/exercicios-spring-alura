package br.com.rldcarvalho.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rldcarvalho.mvc.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
