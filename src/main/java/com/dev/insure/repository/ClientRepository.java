package com.dev.insure.repository;

import com.dev.insure.model.Client;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client,Long> {

    Client save(Client client);

    Client findById(Long id);

    List<Client> findAll();

    List<Client> findByFullName(String fullName);
}
