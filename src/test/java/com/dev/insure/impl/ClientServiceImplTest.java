package com.dev.insure.impl;

import com.dev.insure.repository.ClientRepository;
import com.dev.insure.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    ClientRepository clientRepository;

    ClientService clientService;

    @Before
    public void before() {
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    public void findAll() {

    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }
}