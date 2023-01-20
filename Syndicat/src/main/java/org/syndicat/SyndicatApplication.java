package org.syndicat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.syndicat.web.ISyndicatInitService;

@SpringBootApplication
public class SyndicatApplication implements CommandLineRunner {
	//@Autowired
	 //private ISyndicatInitService syndicatInitService;
	public static void main(String[] args) {
		SpringApplication.run(SyndicatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*syndicatInitService.initImmeuble();
	syndicatInitService.initAppartement();
	syndicatInitService.initUtilisateur();
	syndicatInitService.initCaisse();
	syndicatInitService.initAnnonceUtilisateur();
	syndicatInitService.initReglement();*/
		System.out.println("----------Run application--------");
	}
}
