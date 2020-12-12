package com.senforage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.senforage.dao.ClientRepository;
import com.senforage.entities.Client;

@Controller
public class ClientController {
    @Autowired
	private ClientRepository clientRepository; 
    @GetMapping("/index")
    public String chercher(Model model,
    		@RequestParam(name="page", defaultValue="0") int page,
    		@RequestParam(name="motCle", defaultValue="") String mc) {
    	  Page<Client> pageClients=
    			clientRepository.findByNomContains(mc,PageRequest.of(page, 5));
    	model.addAttribute("listClients",pageClients.getContent());
    	model.addAttribute("pages",new int[pageClients.getTotalPages()]);
    	model.addAttribute("currentPage",page);
    	model.addAttribute("motCle,mc");
    	return "clients";
    }
    @GetMapping("/delete")
    public String delete(Long id, int page, String motCle) {
	    clientRepository.deleteById(id);
	    return "redirect:/index?page="+page+"&motCle"+motCle;
    }

    @GetMapping("/formClient")
    public String form() {
	   
	    return "FormClient";
    }
    
    @PostMapping("/save")
    public String save(Client client) {
	   clientRepository.save(client);
	    return "FormClient";
    }
    
}
 