package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.consts.Constants;
import com.LinteRobert.springboot101.dtos.*;
import com.LinteRobert.springboot101.entities.Notification;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.entities.Review;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.exceptions.InsufficientFunds;
import com.LinteRobert.springboot101.exceptions.NotAllowedToMakeBitException;
import com.LinteRobert.springboot101.exceptions.NotAllowedToPostProductException;
import com.LinteRobert.springboot101.exceptions.PriceToLowException;
import com.LinteRobert.springboot101.mappers.ProductMapper;
import com.LinteRobert.springboot101.services.NotificationService;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Api(value = "/destinations",
        tags = "Destinations")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Destination was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<PostProductResponse> addProduct(@RequestBody PostProduct productRequest) {
        Product product = productMapper.postProductToProduct(productRequest);
        product.setUser(userService.findById(productRequest.getUser_id()));
        if(!product.getUser().getRole().equals("seller")) {
            throw new NotAllowedToPostProductException();
        }
        productService.create(product);
        PostProductResponse p = productMapper.productToPostProductResponse(product);
        return ResponseEntity.created(URI.create("/product/"+ p.getId()))
                .body(p);
    }

    @GetMapping
    public List<GetProductsResponse> getAllProducts() {
        List<GetProductsResponse> products = new ArrayList<>();
        productService.getAll().forEach(product -> products.add(productMapper.productToGetProductsResponse(product)));
        return products;
    }

    @GetMapping("/{id}")
    public GetProductResponse getProductById(@PathVariable("id") int id) {
        return productMapper.productToGetProductResponse(productService.getById(id));
    }

    @GetMapping("/pageNumber/{pageNumber}")
    public List<GetProductsResponse> getActiveProductsByPage(@PathVariable("pageNumber") int pageNumber,
                                                            @RequestBody(required = false) SortRequest sortedBy) {
        List<GetProductsResponse> productsResponses = new ArrayList<>();
        Pageable p;
        if(sortedBy != null) {
            Sort sort;
            if(sortedBy.getAscending()) {
                sort = Sort.by(sortedBy.getField_name()).ascending();
            } else {
                sort = Sort.by(sortedBy.getField_name()).descending();
            }
            p = PageRequest.of(pageNumber, Constants.PRODUCT_PAGE_SIZE, sort);
        } else {
            p = PageRequest.of(pageNumber, Constants.PRODUCT_PAGE_SIZE);
        }
        productService.findProductsByPage(p).forEach(product -> productsResponses.add(productMapper.productToGetProductsResponse(product)));
        return productsResponses;
    }

    @PutMapping ("/{id}")
    public ResponseEntity<PostProductResponse> updateProduct(@PathVariable("id") int id, @RequestBody UpdateProduct updateProduct) {
        Product product = productService.getById(id);
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setEndTime(updateProduct.getEndTime());
        product = productService.update(product);
        PostProductResponse productResponse = productMapper.productToPostProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/productId/{productId}/userId/{userId}/price/{price}")
    public ResponseEntity<PostProductResponse> makeBit(@PathVariable("productId") int productId,
                                                       @PathVariable("userId") int userId,
                                                       @PathVariable("price") double price) {
        User user = userService.findById(userId);
        if(!user.getRole().equals("buyer")) {
            throw new NotAllowedToMakeBitException();
        }
        if(user.getSold() < price) {
            throw new InsufficientFunds();
        }
        Product product = productService.getById(productId);
        if(product.getPrice() >= price) {
            throw new PriceToLowException();
        }
        if(product.getOwner() != null) {
            notificationService.create(new Notification("You lost the product with id " + productId, product.getOwner()));
        }
        product.setPrice(price);
        product.setOwner(user);
        notificationService.create(new Notification("You have a new offer fort product with id " + productId, product.getUser()));
        user.setSold(user.getSold() - price);
        userService.create(user);
        productService.update(product);
        PostProductResponse productResponse = productMapper.productToPostProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }
    //VALIDARI
    //TESTING

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.DeleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
