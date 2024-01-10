package com.LinteRobert.springboot101.repositories;

import com.LinteRobert.springboot101.entities.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer>,
        CrudRepository<Product, Integer> {

    public Product findProductByName(String name);
    public List<Product> findProductsByName(String name, Sort s);
    public List<Product> findProductsByName(String name, Pageable p);

    @Query("SELECT p FROM Product p WHERE p.endTime > :now")
    public List<Product> findProducts(@Param("now") LocalDateTime now, Pageable p);


}
