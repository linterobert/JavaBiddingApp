package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.PostImage;
import com.LinteRobert.springboot101.dtos.PostProductImageResponse;
import com.LinteRobert.springboot101.dtos.PostProductResponse;
import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.mappers.ProductMapper;
import com.LinteRobert.springboot101.repositories.ImageRepository;
import com.LinteRobert.springboot101.services.ImageService;
import com.LinteRobert.springboot101.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    public ImageService imageService;
    @Autowired
    public ProductService productService;
    @Autowired
    public ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<PostProductImageResponse> addImage(@RequestBody PostImage postImage) {
        Image image = new Image();
        image.setDescription(postImage.getDescription());
        image.setUrl(postImage.getUrl());
        image.setTitle(postImage.getTitle());
        image.setProduct(productService.getById(postImage.getProduct_id()));
        image = imageService.create(image);
        PostProductImageResponse p = productMapper.imageToPostProductImage(image);
        return ResponseEntity.created(URI.create("/image/"+ p.getId()))
                .body(p);
    }

    @GetMapping("/productId/{productId}")
    public List<PostProductImageResponse> getImagesByProductId(@PathVariable("productId") int productId) {
        List<PostProductImageResponse> images = new ArrayList<>();
        imageService.getByProductId(productId).forEach(image -> images.add(productMapper.imageToPostProductImage(image)));
        return images;
    }

    @GetMapping("/{id}")
    public PostProductImageResponse getImageById(@PathVariable("id") int id) {
        return productMapper.imageToPostProductImage(imageService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImagr(@PathVariable("id") int id) {
        imageService.delete(id);
        return ResponseEntity.ok("Image deleted successfully!");
    }
}
