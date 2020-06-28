package com.udacity.pricing.domain.price;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PriceRepository.class) //this shouldn't work as it only scans the class annotated with @ controllers and @RestControllers
public class PriceRepositoryTest {

    @MockBean
    PriceRepository priceRepository;

    @Autowired
    MockMvc mockMvc;  // This is used to simulate a HTTP request to the tested controller

    @Test
    public void getPrices() throws Exception{
        mockMvc.perform(get("/services/price"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(priceRepository,times(1)).findAll();

    }

    @Test
    public void getPriceById() throws Exception{
        mockMvc.perform(get("/services/price"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(priceRepository,times(1)).findById(1L);

    }
}