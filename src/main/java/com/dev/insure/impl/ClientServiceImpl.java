package com.dev.insure.impl;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;
import com.dev.insure.repository.ClientRepository;
import com.dev.insure.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Client> findByFullName(String fullName) {
        return clientRepository.findByFullName(fullName);
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
