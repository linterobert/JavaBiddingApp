package com.LinteRobert.springboot101.repositories;

import com.LinteRobert.springboot101.entities.CreditCard;
import com.LinteRobert.springboot101.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>, PagingAndSortingRepository<CreditCard, Integer> {
}
