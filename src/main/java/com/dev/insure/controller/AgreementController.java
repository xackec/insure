package com.dev.insure.controller;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;
import com.dev.insure.service.AgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AgreementController {

    private final Logger logger = LoggerFactory.getLogger(AgreementController.class);

    private final AgreementService agreementService;

    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
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

    @RequestMapping(value = "/agreements", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated Agreement agreement,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {
        logger.debug("saveOrUpdateAgreement() : {}", agreement);
        return "agreement";
    }

    @RequestMapping(value = "/agreements/{id}", method = RequestMethod.GET)
    public String showAgreement(@PathVariable("id") int id, Model model) {
        logger.debug("showAgreement() id: {}", id);

        Agreement agreement = agreementService.findById(id);
        model.addAttribute("agreement", agreement);

        return "agreement";
    }

}
