package com.LinteRobert.springboot101;

import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.repositories.ProductRepository;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot101ApplicationTests {
	@MockBean
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Test
	public void noProductsReturnedTest() {
		given(productRepository.findAll()).willReturn(Collections.emptyList());
		List<Product> res = productService.getAll();
		assertTrue(res.isEmpty());
	}

	@Test
	public void moreProductsAreFoundTest() {
		User user = new User("Andrei", "andrei@gmail.com", "buyer", "testPassword123");
		user = userService.create(user);
		Product product1 = new Product("test product 1", 30.50, LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40), user);
		Product product2 = new Product("test product 2", 130.50, LocalDateTime.of(2019, Month.NOVEMBER, 29, 19, 30, 40), user);
		List<Product> input = Arrays.asList(product1, product2);
		assertEquals(2, input.size());
	}

}
