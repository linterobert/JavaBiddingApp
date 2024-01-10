package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.exceptions.ProductNotFoundException;
import com.LinteRobert.springboot101.repositories.ImageRepository;
import com.LinteRobert.springboot101.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product create(Product product) {
        product.getImages().forEach(image -> image.setProduct(product));
        return productRepository.save(product);
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public Product getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if( product.isPresent() ) {
            return product.get();
        } else {
            throw new ProductNotFoundException(id);
        }
    }
    public void DeleteProduct(int id) {
        productRepository.deleteById(id);
    }
    public List<Product> findProductsByPage(Pageable p) {
        LocalDateTime now = LocalDateTime.now();
        return productRepository.findProducts(now, p);
    }
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
