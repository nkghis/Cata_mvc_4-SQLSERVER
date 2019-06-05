package org.sid.web;

import org.sid.dao.ClientRepository;
import org.sid.dao.ProjetRepository;
import org.sid.entities.Client;
import org.sid.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/admin/projets")
    public String index(Model model){

        List<Projet> projets = projetRepository.findAll();
        model.addAttribute("listprojets",projets);
        return "projet/index";
    }


    @RequestMapping(value = "/admin/projets/save", method = RequestMethod.POST)
    public String saveProjet(@Valid Projet projet, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            model.addAttribute("monprojet", new Projet());
            return "projet/new";
        }
        projetRepository.save(projet);
        return "redirect:/admin/projets";
    }

    @RequestMapping(value = "/admin/projets/new", method = RequestMethod.GET)
    public String newProjet (Model model){
        List<Client> clients =clientRepository.findAll();
        model.addAttribute("monprojet", new Projet());
        model.addAttribute("clients", clients);
        return "projet/new";
    }

    @RequestMapping(value = "/admin/projets/edit/{id}", method = RequestMethod.GET)
    public String editProjet(@PathVariable Long id,  Model model){

        Projet p = projetRepository.getOne(id);
        List<Client> c = clientRepository.findAll();
        model.addAttribute("projet", p);
        model.addAttribute("clients", c);
        return "projet/edit";
    }

    @RequestMapping(value = "/admin/projets/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable Long id){

        projetRepository.deleteById(id);
        return "redirect:/admin/projets";
    }

}

