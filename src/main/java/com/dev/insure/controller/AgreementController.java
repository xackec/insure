package com.dev.insure.controller;

import com.dev.insure.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 86400)
@RestController
@RequestMapping({"/api"})
public class AgreementController {

    private final AgreementService agreementService;

    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @GetMapping("/agreements")
    public List findAll() {
        return agreementService.findAll();
    }
}
