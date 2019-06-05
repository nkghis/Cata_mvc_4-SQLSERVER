package org.sid.web;

import org.sid.dao.ProduitRepository;
import org.sid.dao.ProjetRepository;
import org.sid.entities.Produit;
import org.sid.entities.ProduitProjet;
import org.sid.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @RequestMapping(value = "/admin/stocks")
    public String index(Model model) {

        //ProduitProjet produitProjet = new ProduitProjet();




        //Model produitprojet = model.addAttribute("produitprojet", new ProduitProjet());
       /* List<Produit> produit = produitRepository.findAll();
        model.addAttribute("produits", produit);*/
        return "stock/index";
    }


    @RequestMapping(value = "/admin/stocks/new", method = RequestMethod.GET)
    public String newStock(Model model){

        List<Produit> p = produitRepository.findAll();
        List<Projet> pr = projetRepository.findAll();
        model.addAttribute("produits", p);
        model.addAttribute("projets", pr);
        //model.addAttribute("propro", new ProduitProjet());
     /*   model.addAttribute("monproduit",new Produit());*/
        return "stock/new";

    }

    @Transactional
    @RequestMapping(value = "/admin/stocks/save", method = RequestMethod.POST)
    public String saveStock(HttpServletRequest request){

       /* if (errors.hasErrors()){
            System.out.println("error YES");
            model.addAttribute("monstock", new Produit());
            //model.addAttribute("errors", errors);
            return "stock/new";
        }
        produitRepository.save(produit);*/
       String projet = request.getParameter("projet");
       String produit = request.getParameter("produit");
       String quantite = request.getParameter("quantite");

       ProduitProjet pp = new ProduitProjet();
       Produit produits = produitRepository.getOne(Long.parseLong(produit));
       Projet projets = projetRepository.getOne(Long.parseLong(projet));
       Integer quantites = Integer.parseInt(quantite);
       LocalDate date = LocalDate.now();
       Date dates = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
       pp.setProduit(produits);
       pp.setProjet(projets);
       pp.setStock_qte(quantites);
       pp.setStock_date(dates);
       projets.getProduitProjets().add(pp);
       projetRepository.save(projets);
       produitRepository.save(produits);



       System.out.println(projet);
       System.out.println(produit);
       System.out.println(quantite);
        System.out.println(dates);
        System.out.println(projets.getProduitProjets().size());
        //System.out.println(projets);



        return "redirect:/admin/stocks/new";
    }

    @RequestMapping(value = "/admin/stocks/edit/{id}", method = RequestMethod.GET)
    public String editStock(@PathVariable Long id, Model model){

        /*Produit c = produitRepository.getOne(id);
        model.addAttribute("produit", c);*/
        return "stock/edit";
    }


    @RequestMapping(value = "/admin/stocks/delete/{id}", method = RequestMethod.GET)
    public String deleteStock(@PathVariable Long id){

       /* produitRepository.deleteById(id);*/
        return "redirect:/admin/stocks";
    }
}
