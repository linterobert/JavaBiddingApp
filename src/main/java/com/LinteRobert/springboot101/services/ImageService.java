package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.exceptions.ImageNotFoundException;
import com.LinteRobert.springboot101.exceptions.UserNotFoundException;
import com.LinteRobert.springboot101.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image create(Image image) {
        return imageRepository.save(image);
    }
    public List<Image> getByProductId(int productId) {
        return imageRepository.findByProductId(productId);
    }

    public Image findById(int id) {
        Optional<Image> image = imageRepository.findById(id);
        if(image.isPresent()) {
            return image.get();
        } else {
            throw new ImageNotFoundException(id);
        }
    }

    public void delete(int id) {
        imageRepository.deleteById(id);
    }
}
