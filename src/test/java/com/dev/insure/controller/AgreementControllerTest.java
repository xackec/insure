package com.dev.insure.controller;

import com.dev.insure.service.AgreementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AgreementController.class)
public class AgreementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AgreementService service;

    @Test
    public void findAll() throws Exception{

        mvc.perform(get("/")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/homehome.jsp"))
                .andExpect(model().attributeExists("agreements"));

    }
}