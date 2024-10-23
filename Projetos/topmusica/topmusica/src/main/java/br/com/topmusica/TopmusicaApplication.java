package br.com.topmusica;

import br.com.topmusica.principal.Principal;
import br.com.topmusica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopmusicaApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TopmusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.menu();
	}
}
