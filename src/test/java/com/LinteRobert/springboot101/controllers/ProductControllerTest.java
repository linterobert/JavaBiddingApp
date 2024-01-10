package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.UpdateProduct;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Test
    public void addProduct() throws Exception {
        User user = new User("Andrei", "andrei@gmail.com", "seller", "testPassword123");
        user = userService.create(user);
        String productJson = "{\"name\":\"Beer\",\"price\":10.0,\"endTime\":\"2025-12-30 22:00:30\",\"user_id\":" + user.getId() + "}";
        MvcResult result = mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isCreated()).andReturn();
        String content = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(content);

        assertEquals("Beer", jsonResponse.getString("name"));
        assertEquals(10.00, jsonResponse.getDouble("price"));
        assertEquals("2025-12-30T22:00:30", jsonResponse.getString("endTime"));
    }

    @Test
    public void getProductById() throws Exception {
        User user = new User("Andrei", "andrei@gmail.com", "buyer", "testPassword123");
        user = userService.create(user);
        Product product = new Product("test product 1", 30.50, LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40), user);
        product.setImages(new ArrayList<>());
        product = productService.create(product);
        MvcResult result = mockMvc.perform(get("/product/{id}", product.getId()))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        JSONObject jsonResponse = new JSONObject(content);

        assertEquals(product.getName(), jsonResponse.getString("name"));
        assertEquals(product.getPrice(), jsonResponse.getDouble("price"));
        assertEquals(product.getId(), jsonResponse.getInt("id"));
    }

    @Test
    public void deleteProduct() throws Exception {
        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    public void getActiveProductsByPage() throws Exception {
        int pageNumber = 0;
        mockMvc.perform(get("/product/pageNumber/{pageNumber}", pageNumber))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    public void updateProduct() throws Exception {
        int productIdToUpdate = 87;
        UpdateProduct updatedProduct = new UpdateProduct();
        updatedProduct.setName("Updated Name");
        updatedProduct.setPrice(20.0);
        mockMvc.perform(put("/product/{id}", productIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}