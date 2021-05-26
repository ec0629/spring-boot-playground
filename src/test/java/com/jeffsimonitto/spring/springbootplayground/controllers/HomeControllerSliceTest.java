package com.jeffsimonitto.spring.springbootplayground.controllers;

import com.jeffsimonitto.spring.springbootplayground.entities.Cart;
import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import com.jeffsimonitto.spring.springbootplayground.services.InventoryService;
import com.jeffsimonitto.spring.springbootplayground.services.VarietyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(HomeController.class)
public class HomeControllerSliceTest {

    @MockBean InventoryService inventoryService;
    @MockBean VarietyService varietyService;

    @Autowired MockMvc mockMvc;

    @Test
    void homePage() throws Exception {
        when(inventoryService.getInventory()).thenReturn(Arrays.asList(
                new Item(1, "name1", "desc1", 1.99),
                new Item(2, "name2", "desc2", 9.99)
        ));

        when(inventoryService.getCart("My Cart"))
                .thenReturn(Optional.of(new Cart("My Cart")));

        mockMvc
                .perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("action=\"/add/1\"")))
                .andExpect(content().string(containsString("action=\"/add/2\"")));
    }
}
