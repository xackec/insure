package com.dev.insure.impl;

import com.dev.insure.model.Agreement;
import com.dev.insure.repository.AgreementRepository;
import com.dev.insure.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository repository;

    @Autowired
    public AgreementServiceImpl(AgreementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Agreement> findAll() {
        return repository.findAll();
    }

    @Override
    public Agreement create(Agreement agreement) {
        return repository.save(agreement);
    }

    @Override
    public Agreement update(Agreement update) {
        return null;
    }
}
