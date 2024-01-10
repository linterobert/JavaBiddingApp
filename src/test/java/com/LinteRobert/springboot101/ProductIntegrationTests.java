package com.LinteRobert.springboot101;

import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.UserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Test
    public void postProduct() throws Exception {
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
    public void getProductByIdTest() throws Exception {
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
    public void deleteProductTest() throws Exception {
        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isOk());
    }
}
