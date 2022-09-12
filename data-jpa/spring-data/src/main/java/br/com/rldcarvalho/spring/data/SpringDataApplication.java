package br.com.rldcarvalho.spring.data;

import br.com.rldcarvalho.spring.data.orm.Cargo;
import br.com.rldcarvalho.spring.data.repository.CargoRepository;
import br.com.rldcarvalho.spring.data.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;

	private  Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService){
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			int action = scanner.nextInt();

			switch (action){
				case 1:
					cargoService.inicial(scanner);
					break;

				default:
					system = false;
			}

		}
	}
}
