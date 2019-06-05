package org.sid.web;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Client;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value = "/admin/produits")
	public String index(Model model) {
		List<Produit> produit = produitRepository.findAll();
		model.addAttribute("produits", produit);
		return "produit/index";
	}

	@RequestMapping(value = "/admin/produits/new", method = RequestMethod.GET)
	public String newProduit(Model model){

		model.addAttribute("monproduit",new Produit());
		return "produit/new";

	}


	@RequestMapping(value = "/admin/produits/save", method = RequestMethod.POST)
	public String saveProduit(@Valid Produit produit, Errors errors, Model model){

		if (errors.hasErrors()){
			System.out.println("error YES");
			model.addAttribute("monproduit", new Produit());
			//model.addAttribute("errors", errors);
			return "produit/new";
		}
		produitRepository.save(produit);
		return "redirect:/admin/produits";
	}

	@RequestMapping(value = "/admin/produits/edit/{id}", method = RequestMethod.GET)
	public String editProduit(@PathVariable Long id, Model model){

		Produit c = produitRepository.getOne(id);
		model.addAttribute("produit", c);
		return "produit/edit";
	}


	@RequestMapping(value = "/admin/produits/delete/{id}", method = RequestMethod.GET)
	public String deleteProduit(@PathVariable Long id){

		produitRepository.deleteById(id);
		return "redirect:/admin/produits";
	}
	
}
