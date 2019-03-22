package com.dev.insure.impl;

import com.dev.insure.model.Agreement;
import com.dev.insure.repository.AgreementRepository;
import com.dev.insure.service.AgreementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgreementServiceImplTest {

    @Autowired
    AgreementRepository repository;

    AgreementService service;

    @Before
    public void before() {
        this.service = new AgreementServiceImpl(repository);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void create() {
        assertNotNull(service.create(new Agreement(1,2,new Date(Calendar.getInstance().getTimeInMillis()),
                new Date(Calendar.getInstance().getTimeInMillis()), "123.45")));
    }

    @Test
    public void update() {
    }
}