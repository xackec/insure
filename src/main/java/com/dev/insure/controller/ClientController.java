package com.dev.insure.controller;

import com.dev.insure.model.Client;
import com.dev.insure.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String searchClient(ModelMap model) {
        List<Client> clients = new ArrayList<>();
        model.addAttribute("clients", clients);
        return "search-client";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        Client client = new Client("one", "two", new Date(Calendar.getInstance().getTimeInMillis()));
        model.addAttribute("client", client);
        model.addAttribute("edit", true);
        return "new-client";
    }

    @RequestMapping(value = { "/search-{fullName}" }, method = RequestMethod.GET)
    public String searchClientByFullname(ModelMap model) {
        Client client = new Client();
        model.addAttribute("clients", client);
        return "client";
    }
}
