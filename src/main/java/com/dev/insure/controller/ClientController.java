package com.dev.insure.controller;

import com.dev.insure.model.Client;
import com.dev.insure.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String clients(ModelMap model) {
        logger.debug("clients()");
        model.addAttribute("clients", clientService.findAll());
        return "search-client";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "new-client";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("client") Client client,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("saveOrUpdateClient() : {}", client);
        return "agreement";
    }


    @RequestMapping(value = { "/search-{fullName}" }, method = RequestMethod.GET)
    public String searchClientByFullname(@PathVariable("fullName") String fullName, Model model) {
        logger.debug("search client by FIO - " + fullName);
        List<Client> clients = clientService.findByFullName(fullName);
        model.addAttribute("clients", clients);
        return "search-client";
    }


    @RequestMapping(value = { "/{passportSN}"},  method = RequestMethod.GET)
    public String search(Model model, @PathVariable("passportSN")String passportSN) {
        logger.debug("POST client with id- " + passportSN);
        Client client = clientService.findById(passportSN);

        model.addAttribute("client", client);

        return "forward:/create";
    }
}
