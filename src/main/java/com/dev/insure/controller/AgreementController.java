package com.dev.insure.controller;

import com.dev.insure.model.Agreement;
import com.dev.insure.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AgreementController {

    private final AgreementService agreementService;

    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAgreements(ModelMap model) {

        List<Agreement> agreements = agreementService.findAll();
        model.addAttribute("agreements", agreements);
        return "index";
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Agreement agreement = new Agreement();
        model.addAttribute("agreement", agreement);
        return "agreement";
    }

}
