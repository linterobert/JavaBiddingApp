package com.LinteRobert.springboot101.repositories;
import com.LinteRobert.springboot101.entities.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>, PagingAndSortingRepository<Review, Integer>,
        CrudRepository<Review, Integer> {

    public List<Review> findReviewsByProductId(int product_id);
    public List<Review> findReviewsByProductId(int product_id, Pageable p);
}
