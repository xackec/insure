package com.dev.insure.impl;

import com.dev.insure.model.Agreement;
import com.dev.insure.repository.AgreementRepository;
import com.dev.insure.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Agreement findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Agreement saveOrUpdate(Agreement agreement) {
            return repository.save(agreement);
    }
}
