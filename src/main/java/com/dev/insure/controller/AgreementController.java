package com.dev.insure.controller;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;
import com.dev.insure.service.AgreementService;
import com.dev.insure.service.ClientService;
import com.dev.insure.validator.AgreementFormValidator;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AgreementController {

    private final Logger logger = LoggerFactory.getLogger(AgreementController.class);

    private final AgreementService agreementService;

    @Autowired
    AgreementFormValidator agreementFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(agreementFormValidator);
    }


    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @RequestMapping(value = { "/","/agreements" }, method = RequestMethod.GET)
    public String listAgreements(ModelMap model) {
        logger.debug("GET -> listAgreements()");
        List<Agreement> agreements = agreementService.findAll();
        model.addAttribute("agreements", agreements);
        return "home";
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String createAgreement(ModelMap model) {
        logger.debug("GET -> createAgreement()");
        Agreement agreement = new Agreement();
        agreement.setClient(new Client());
        model.addAttribute("agreement", agreement);
        return "agreement-form";
    }

    @RequestMapping(value = "/agreements", method = RequestMethod.POST)
    public String saveOrUpdateAgreement(@ModelAttribute("agreement") @Validated Agreement agreement,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {
        logger.debug("POST -> saveOrUpdateAgreement() : {}",agreement);
        if(result.hasErrors()) {
            logger.debug(result.getAllErrors().toString());
            return "agreement-form";
        } else {

            agreementService.saveOrUpdate(agreement);

            return "redirect:/agreements";
        }
    }

    @RequestMapping(value = "/agreements/{id}", method = RequestMethod.GET)
    public String showAgreement(@PathVariable("id") Long id, Model model) {
        logger.debug("showAgreement() id: {}", id);

        Agreement agreement = agreementService.findById(id);
        model.addAttribute("agreement", agreement);

        return "agreement-form";
    }

}
