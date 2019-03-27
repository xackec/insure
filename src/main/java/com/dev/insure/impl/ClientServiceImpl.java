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
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByFullName(String fullName) {
        return clientRepository.findByFullName(fullName);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }


    @Override
    public Client saveOrUpdate(Client client) {
        if(client.isNew()) {
            return clientRepository.save(client);
        } else {
            Client exist = clientRepository.findById(client.getId());
            exist.setFullName(client.getFullName());
            exist.setBirthDate(client.getBirthDate());
            exist.setPassportN(client.getPassportN());
            exist.setPassportS(client.getPassportS());
            exist.setAgreements(client.getAgreements());
            return clientRepository.save(exist);
        }
    }
}
