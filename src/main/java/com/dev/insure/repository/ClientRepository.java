package com.dev.insure.repository;

import com.dev.insure.model.Client;
import org.springframework.data.repository.Repository;

public interface ClientRepository extends Repository<Client,Integer> {

    Client save(Client client);


}
