package com.dev.insure.repository;

import com.dev.insure.model.Client;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client,String> {

    Client save(Client client);

    List<Client> findAll();
}
