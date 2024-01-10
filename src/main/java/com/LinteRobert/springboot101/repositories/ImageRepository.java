package com.LinteRobert.springboot101.repositories;

import com.LinteRobert.springboot101.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>, PagingAndSortingRepository<Image, Integer> {
    List<Image> findByProductId(Integer product_id);
}
