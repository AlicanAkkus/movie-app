package com.caysever.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;


/**
 * Created by alican on 25.04.2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConnectivityTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        restTemplate = new RestTemplate();
    }

    @Test
    public void verifiesHomePageLoads() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void verifiesApiConnectivity() throws Exception{
        assertTrue(restTemplate.headForHeaders(URI.create("http://www.omdbapi.com")).size() > 0);
    }

}
