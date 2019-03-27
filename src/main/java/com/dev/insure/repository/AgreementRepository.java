package com.dev.insure.repository;

import com.dev.insure.model.Agreement;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AgreementRepository extends Repository<Agreement, Long> {

    List findAll();

    Agreement findById(Long id);

    Agreement save(Agreement agreement);
}
