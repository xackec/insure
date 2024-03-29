package com.dev.insure.service;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    List<Client> findByFullName(String fullName);

    Client findById(Long id);

    Client saveOrUpdate(Client client);


}
