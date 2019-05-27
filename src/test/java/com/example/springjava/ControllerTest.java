package com.example.springjava;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class ControllerTest {

    private static final String URL_SERVICE = "/api/v1/products";
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initTests() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test1ShouldReturnProductListOK() throws Exception {
        mockMvc.perform( get( URL_SERVICE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect( status().isOk() )
                .andExpect(jsonPath("$.length()", is(4)))
                .andExpect(jsonPath("$.[0].id", is("1")))
                .andExpect(jsonPath("$.[0].name", is("galletas")))
                .andExpect(jsonPath("$.[0].value", is(2000)));
    }

    @Test
    public void test2ShouldSaveAProductOK() throws Exception {
        String product_json = "{\n" +
                "    \"id\": \"5\",\n" +
                "    \"name\": \"Quesito\",\n" +
                "    \"value\": 3500\n" +
                "}";

        mockMvc.perform(post( URL_SERVICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(product_json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Producto guardado sarisfactoriamente"));
    }


    @Test
    public void test3ShouldFailToSaveAProduct() throws Exception {
        String product_json = "{\n" +
                "    \"id\": \"5\",\n" +
                "    \"name\": \"Quesito\",\n" +
                "    \"value\": \"Quesito\",\n" +
                "}";

        mockMvc.perform(post( URL_SERVICE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(product_json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}