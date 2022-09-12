package br.com.rldcarvalho.spring.data.repository;

import br.com.rldcarvalho.spring.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {


}
