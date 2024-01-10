package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.PostCreditCard;
import com.LinteRobert.springboot101.dtos.PostNotification;
import com.LinteRobert.springboot101.dtos.ReturnCreditCard;
import com.LinteRobert.springboot101.dtos.ReturnNotification;
import com.LinteRobert.springboot101.entities.CreditCard;
import com.LinteRobert.springboot101.entities.Notification;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.mappers.CreditCardMapper;
import com.LinteRobert.springboot101.services.CreditCardService;
import com.LinteRobert.springboot101.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private UserService userService;
    @Autowired
    private CreditCardMapper creditCardMapper;

    @PostMapping
    public ResponseEntity<ReturnCreditCard> createCreditCard(@RequestBody PostCreditCard postCreditCard) {
        User user = userService.findById(postCreditCard.getUserId());
        CreditCard creditCard = creditCardMapper.postCreditCardToCreditCard(postCreditCard);
        creditCard.setUser(user);
        ReturnCreditCard toReturn = creditCardMapper.creditCardToReturnCreditCard(creditCardService.save(creditCard));

        return ResponseEntity.created(URI.create("/creditCard/"+ toReturn.getId()))
                .body(toReturn);
    }
}
