package com.dev.insure.controller;

import com.dev.insure.model.Client;
import com.dev.insure.service.ClientService;
import com.dev.insure.validator.ClientFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    private final ClientFormValidator clientFormValidator;

    @Autowired
    public ClientController(ClientService clientService, ClientFormValidator clientFormValidator) {
        this.clientService = clientService;
        this.clientFormValidator = clientFormValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(clientFormValidator);
    }

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String clients(ModelMap model) {
        logger.debug("GET -> clients()");
        model.addAttribute("clients", clientService.findAll());
        return "all-clients";
    }


    @RequestMapping(value = { "/change-{id}" }, method = RequestMethod.GET)
    public String changeClient(@PathVariable("id") Long id,ModelMap model) {
        logger.debug("GET -> changeClient() - {}", id);
        model.addAttribute("client", clientService.findById(id));
        return "new-client";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveOrUpdateClient(@ModelAttribute("client") @Validated Client client,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("POST -> saveOrUpdateClient() : {}", client);
        if(result.hasErrors()) {
            return "new-client";
        } else {
            clientService.saveOrUpdate(client);
            return "redirect:/clients";
        }
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        logger.debug("GET -> newClient()");
        Client client = new Client();
        model.addAttribute("client", client);
        return "new-client";
    }

    @RequestMapping(value = { "/search-{fullName}" }, method = RequestMethod.GET)
    public String searchClientByFullname(@PathVariable("fullName") String fullName, Model model) {
        logger.debug("GET -> searchClientByFullname() - " + fullName);
        List<Client> clients = clientService.findByFullName(fullName);
        model.addAttribute("clients", clients);
        return "all-clients";
    }
}
