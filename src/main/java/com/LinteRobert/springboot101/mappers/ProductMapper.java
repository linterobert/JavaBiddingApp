package com.LinteRobert.springboot101.mappers;

import com.LinteRobert.springboot101.dtos.*;
import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductMapper {
    public Product postProductToProduct(PostProduct postProduct) {
        return new Product(postProduct.getName(), postProduct.getPrice(), postProduct.getImages(), postProduct.getEndTime());
    }

    public PostProductImageResponse imageToPostProductImage(Image image) {
        return new PostProductImageResponse(image.getId(), image.getTitle(), image.getUrl(), image.getDescription());
    }

    public PostProductResponse productToPostProductResponse(Product product) {
        List<PostProductImageResponse> images = new ArrayList<>();
        product.getImages().forEach(image -> images.add(imageToPostProductImage(image)));
        return new PostProductResponse(product.getId(), product.getName(), product.getPrice(), images, product.getPostedTime(), product.getEndTime());
    }

    public GetProductsImageResponse imageToGetProductsImageResponse(Image image) {
        return new GetProductsImageResponse(image.getId(), image.getTitle(), image.getUrl(), image.getDescription());
    }

    public GetProductsResponse productToGetProductsResponse(Product product) {
        if (product.getImages() != null && !product.getImages().isEmpty()) {
            return new GetProductsResponse(product.getId(), product.getName(), product.getPrice(), imageToGetProductsImageResponse(product.getImages().getFirst()), product.getPostedTime(), product.getEndTime());
        } else {
            return new GetProductsResponse(product.getId(), product.getName(), product.getPrice());
        }
    }

    public GetProductResponse productToGetProductResponse(Product product) {
        List<GetProductsImageResponse> images = new ArrayList<>();
        product.getImages().forEach(image -> images.add(imageToGetProductsImageResponse(image)));
        return new GetProductResponse(product.getId(), product.getName(), product.getPrice(), images, product.getPostedTime(), product.getEndTime());
    }
}
