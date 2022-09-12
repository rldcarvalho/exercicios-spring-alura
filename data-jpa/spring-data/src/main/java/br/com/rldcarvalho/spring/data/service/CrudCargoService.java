package br.com.rldcarvalho.spring.data.service;

import br.com.rldcarvalho.spring.data.orm.Cargo;
import br.com.rldcarvalho.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        salvar(scanner);
    }

    private void salvar(Scanner scanner){
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

}
