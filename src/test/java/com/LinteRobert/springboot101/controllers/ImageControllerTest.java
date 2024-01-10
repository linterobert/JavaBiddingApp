package com.LinteRobert.springboot101.controllers;
import com.LinteRobert.springboot101.dtos.PostImage;
import com.LinteRobert.springboot101.dtos.PostProductImageResponse;
import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.mappers.ProductMapper;
import com.LinteRobert.springboot101.services.ImageService;
import com.LinteRobert.springboot101.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImageControllerTest {

    @Mock
    private ImageService imageService;

    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ImageController imageController;

    @Test
    public void testAddImage() {
        when(productService.getById(anyInt())).thenReturn(new Product());

        when(imageService.create(any())).thenReturn(new Image());

        when(productMapper.imageToPostProductImage(any())).thenReturn(new PostProductImageResponse());

        PostImage postImage = new PostImage();
        ResponseEntity<PostProductImageResponse> response = imageController.addImage(postImage);

        verify(productService, times(1)).getById(anyInt());
        verify(imageService, times(1)).create(any());
        verify(productMapper, times(1)).imageToPostProductImage(any());
    }

    @Test
    public void testGetImageById() {
        when(imageService.findById(anyInt())).thenReturn(new Image());

        when(productMapper.imageToPostProductImage(any())).thenReturn(new PostProductImageResponse());

        int imageId = 123;
        PostProductImageResponse image = imageController.getImageById(imageId);

        verify(imageService, times(1)).findById(anyInt());
        verify(productMapper, times(1)).imageToPostProductImage(any());
    }

    @Test
    public void testDeleteImage() {
        int imageId = 123;

        imageController.deleteImagr(imageId);

        verify(imageService, times(1)).delete(imageId);
    }
}