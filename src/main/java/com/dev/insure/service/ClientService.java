package com.dev.insure.service;

import com.dev.insure.model.Agreement;
import com.dev.insure.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client create(Client client);

    Client update(Client client);


}
