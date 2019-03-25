package com.dev.insure.service;

import com.dev.insure.model.Agreement;

import java.util.List;

public interface AgreementService {

    List<Agreement> findAll();

    Agreement findById(int id);

    Agreement create(Agreement agreement);

    Agreement update(Agreement update);

}
