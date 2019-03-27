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

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

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
        assertNotNull( clientService.saveOrUpdate(new Client("2200","610552", "Иванов Иван Иванович",
                new Date(Calendar.getInstance().getTimeInMillis()))));
    }

    @Test
    @Transactional
    public void saveUpdateTest() {
        Client first = clientService.saveOrUpdate(new Client("1","2","Петров", new Date()));
        assertNotNull(first.getId());
        Client second = clientService.findById(first.getId());
        second.setFullName("Сидоров");
        Client updated = clientService.saveOrUpdate(second);
        assertEquals(first.getId(),updated.getId());
        assertEquals(updated.getFullName(),"Сидоров");
    }

    @Test
    @Transactional
    public void findByFullNameTest() {
        clientService.saveOrUpdate(new Client("1","2","Иванов Иван Иванович", new Date()));
        assertNotNull(clientService.findByFullName("Иванов Иван Иванович"));
    }

}