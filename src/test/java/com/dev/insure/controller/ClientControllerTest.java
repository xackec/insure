package com.dev.insure.controller;

import com.dev.insure.service.AgreementService;
import com.dev.insure.service.ClientService;
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
public class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService service;

    @Test
    public void searchClient() throws Exception{
        mvc.perform(get("/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/search-client.jsp"))
                .andExpect(model().attributeExists("clients"));
    }

    @Test
    public void newClient()throws Exception{
        mvc.perform(get("/clients/new")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/new-client.jsp"))
                .andExpect(model().attributeExists("client"));
    }

    @Test
    public void searchClientByFullname() {
    }
}