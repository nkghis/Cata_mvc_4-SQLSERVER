package org.sid.web;

import org.sid.dao.ClientRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/admin/clients")
    public String index(Model model){

        List<Client> clients = clientRepository.findAll();
        //String message = "je suis content";
        //model.addAttribute("monclient", new Client());
        model.addAttribute("listClients", clients);
        //model.addAttribute("lolo", message);
        return "client/index";
    }

    @RequestMapping(value = "/admin/clients/new", method = RequestMethod.GET)
    public String newClient(Model model){

        model.addAttribute("monclient",new Client());
        return "client/new";

    }

    /*@RequestMapping(value = "/admin/clients/save", method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult bindingResult, Model model){


        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());


            model.addAttribute("monclient", new Client());


            return "client/new";
        }
        clientRepository.save(client);
        return "redirect:/admin/clients";

    }*/
    @RequestMapping(value = "/admin/clients/save", method = RequestMethod.POST)
    public String saveClient(@Valid Client client, Errors errors, Model model){

        if (errors.hasErrors()){
            System.out.println("error YES");
            model.addAttribute("monclient", new Client());
            //model.addAttribute("errors", errors);
            return "client/new";
        }
        clientRepository.save(client);
        return "redirect:/admin/clients";
    }


    /*@RequestMapping(value = "/admin/clients/edit/{id}", method = RequestMethod.POST)
    public String updateClient(@Valid Client client, Errors errors, @PathVariable Long id, Model model){

        if (errors.hasErrors()){
            System.out.println("error YES");
            model.addAttribute("monclient", new Client());
            //model.addAttribute("errors", errors);
            return "client/new";
        }
        //Client client1 = clientRepository.getOne(id);
        //clientupdate = clientRepository.getOne()
        //clientRepository.save(client);
        //model.a
        return "redirect:/admin/clients";
    }*/

    @RequestMapping(value = "/admin/clients/edit/{id}", method = RequestMethod.GET)
    public String editClient(@PathVariable Long id, Model model){

        Client c = clientRepository.getOne(id);
        model.addAttribute("client", c);
        return "client/edit";
    }

    @RequestMapping(value = "/admin/clients/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable Long id){

        clientRepository.deleteById(id);
        return "redirect:/admin/clients";
    }
}
