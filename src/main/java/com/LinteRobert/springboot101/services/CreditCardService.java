package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.CreditCard;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.exceptions.CreditCardNotFoundException;
import com.LinteRobert.springboot101.exceptions.ProductNotFoundException;
import com.LinteRobert.springboot101.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public CreditCard getById(int id) {
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);
        if( creditCard.isPresent() ) {
            return creditCard.get();
        } else {
            throw new CreditCardNotFoundException(id);
        }
    }
}
