package com.jeffsimonitto.spring.springbootplayground.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoadingWebSiteIntegrationTest {

    @Autowired MockMvc mockMvc;

    @Test
    void test() throws Exception {
        this.mockMvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML + ";charset=UTF-8"))
                .andExpect(content().string(containsString("<form method=\"post\" action=\"/add")));
    }

}
