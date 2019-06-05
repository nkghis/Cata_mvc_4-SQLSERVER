package org.sid;

import org.sid.dao.ArticleRepository;
import org.sid.dao.ClientRepository;
import org.sid.dao.ProduitRepository;
import org.sid.dao.ProjetRepository;
import org.sid.entities.Article;
import org.sid.entities.Client;
import org.sid.entities.Produit;
import org.sid.entities.Projet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StockCoffreFortApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StockCoffreFortApplication.class, args);
		
		/*ArticleRepository articleRepository = ctx.getBean(ArticleRepository.class);
		articleRepository.save(new Article("Desktop HP 15", 150, 150));
		articleRepository.save(new Article("Laptop Dell 1570", 120, 250));
		articleRepository.save(new Article("Printer HP 2363", 500, 300));
		articleRepository.save(new Article("Printer Epson 4120", 7500, 450));
		articleRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
		//produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));

		ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
		Client c1 = clientRepository.save(new Client("UBA","+22501010101"));
		Client c2 = clientRepository.save(new Client("SOCIETE GENERALE","+22502020202"));
		Client c3 = clientRepository.save(new Client("BNI","+22502020202"));
		clientRepository.findAll().forEach(p->System.out.println(p.getClient_nom()));

		ProjetRepository projetRepository = ctx.getBean(ProjetRepository.class);
		//projetRepository.save(new Projet("Test"));
		projetRepository.save(new Projet("Carte bleu", c1));*/

	}

}
