package com.dev.insure.impl;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;
import com.dev.insure.repository.ClientRepository;
import com.dev.insure.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }
}
