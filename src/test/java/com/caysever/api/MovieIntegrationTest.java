package com.caysever.api;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by alican on 25.04.2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieIntegrationTest {

    private RestTemplate restTemplate;

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void verifyMovie() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("http://www.omdbapi.com/?t=dexter", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        jsonPath("$.Response").value(true);
        jsonPath("$.Title").value("Dexter");
    }
}
