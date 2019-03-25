package com.dev.insure.repository;

import com.dev.insure.model.Agreement;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AgreementRepository extends Repository<Agreement, Integer> {

    List findAll();

    Agreement findById(Integer id);

    Agreement save(Agreement agreement);
}
