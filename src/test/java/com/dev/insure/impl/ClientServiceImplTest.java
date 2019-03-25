package com.dev.insure.impl;

import com.dev.insure.model.Client;
import com.dev.insure.repository.ClientRepository;
import com.dev.insure.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;

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
        assertNotNull( clientService.create(new Client("2200610552", "Иванов Иван Иванович",
                new Date(Calendar.getInstance().getTimeInMillis()))));
    }

    @Test
    public void findByFullNameTest() {
        assertNotNull(clientService.findByFullName("Иванов Иван Иванович"));
    }

    @Test
    public void update() {
    }
}